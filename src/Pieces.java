import javax.swing.*;
import java.awt.*;

public abstract class Pieces {
    String Color;
    ImageIcon image;
    JLabel label;

    static int blackKingCounter = 0, whiteKingCounter = 0,
            left_B_Rock = 0, right_B_Rock = 0,
            left_W_Rock = 0, right_W_Rock = 0,
            counter = 0,pieceValue, firstValue, secondValue;
    static boolean isMoved, changeLastPos = false, isPromoted = false, isCheckMate = false, changePiece=false;

    static int[] ValidPlacesX = new int[27], ValidPlacesY = new int[27], availablePlacesX = new int[27], availablePlacesY = new int[27];

    public void setPosition(int x, int y) {
        label.setBounds(x, y, 63, 63);
    }

    public void setPosition(Point p) {
        label.setBounds(board.Draw[p.x][p.y].x, board.Draw[p.x][p.y].y, 72, 72);
    }

    public static void Initializing() {
        for (int i = 0; i < 27; i++) {
            ValidPlacesX[i] = -1;
            ValidPlacesY[i] = -1;
        }
    }

    public static void IsCheck(int p1X, int p1Y, int p2X, int p2Y) {
        isMoved = false;
        firstValue = board.piece[p1X][p1Y];
        secondValue = board.piece[p2X][p2Y];

        if (board.piece[p2X][p2Y] != 0) {
            board.killPiece();
            changeLastPos = true;
        }
        //Swap
        //if it is king
        if (firstValue == -13 || firstValue == 13) {
            if (firstValue == -13) {
                Game.B_King_Pos.x = p2X;
                Game.B_King_Pos.y = p2Y;
            } else {
                Game.W_King_Pos.x = p2X;
                Game.W_King_Pos.y = p2Y;
            }
        }

        //Checkmate
        if (Game.p1.x == 20 && !Computer.moving) {
            isCheckMate = true;
        }

        board.piece[p2X][p2Y] = board.piece[p1X][p1Y];
        board.piece[p1X][p1Y] = 0;

        //If White king is checked
        if (board.piece[p2X][p2Y] > 0) {
            if (Check.WhiteChecked()) {
                board.piece[p2X][p2Y] = secondValue;
                board.piece[p1X][p1Y] = firstValue;
                if (firstValue == 13) {
                    Game.W_King_Pos.x = p1X;
                    Game.W_King_Pos.y = p1Y;
                }
            } else {
                isMoved = true;
                //Check Mate
                if (isCheckMate) {
                    board.piece[p2X][p2Y] = secondValue;
                    board.piece[p1X][p1Y] = firstValue;
                    if (firstValue == 13) {
                        Game.W_King_Pos.x = p1X;
                        Game.W_King_Pos.y = p1Y;
                    }
                    isCheckMate = false;
                }
                if (King.isCastled && firstValue == 13) {
                    if (Game.W_King_Pos.y == 5) {
                        King.isRCastled = true;
                    } else {
                        King.isLCastled = true;
                    }
                    Game.W_King_Pos.x = p1X;
                    Game.W_King_Pos.y = p1Y;
                    board.piece[p1X][p1Y] = firstValue;
                    board.piece[p2X][p2Y] = secondValue;
                }
            }
            if (changeLastPos) {
                board.killPiece();
            }
        }
        //If Black king is checked
        else if (board.piece[p2X][p2Y] < 0) {
            if (Check.BlackChecked()) {
                board.piece[p2X][p2Y] = secondValue;
                board.piece[p1X][p1Y] = firstValue;
                if (firstValue == -13) {
                    Game.B_King_Pos.x = p1X;
                    Game.B_King_Pos.y = p1Y;
                }
            } else {
                isMoved = true;
                //Check Mate
                if (isCheckMate) {
                    board.piece[p2X][p2Y] = secondValue;
                    board.piece[p1X][p1Y] = firstValue;
                    if (firstValue == -13) {
                        Game.B_King_Pos.x = p1X;
                        Game.B_King_Pos.y = p1Y;
                    }
                    isCheckMate = false;
                }
                if (King.isCastled && firstValue == -13) {
                    if (Game.B_King_Pos.y == 5) {
                        King.isRCastled = true;
                    } else {
                        King.isLCastled = true;
                    }
                    Game.B_King_Pos.x = p1X;
                    Game.B_King_Pos.y = p1Y;
                    board.piece[p1X][p1Y] = firstValue;
                    board.piece[p2X][p2Y] = secondValue;
                }
            }
            if (changeLastPos) {
                board.killPiece();
            }
        }

    }

    public static void CheckMate() {
        //White king is checked
        if (Game.white_player) {
            if (Check.WhiteChecked()) {
                //Pawn
                for (int i = 8; i < 16; i++) {
                    if (Pawn.lastPosition[i].x < 8) {
                        Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
                        for (int k = 0; k < 4; k++) {
                            availablePlacesX[k] = ValidPlacesX[k];
                            availablePlacesY[k] = ValidPlacesY[k];
                        }
                        for (int j = 0; j < 4; j++) {
                            if (availablePlacesX[j] != -1) {
                                IsCheck((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);

                                if(isMoved){
                                    break;
                                }
                            }
                        }
                        if (isMoved) {
                            break;
                        }
                    }
                }
                //Rock
                if (!isMoved) {
                    changePiece=false;
                    while(!isMoved){
                        if(!changePiece){
                            pieceValue=2;
                            changePiece=true;
                        }
                        else{
                            pieceValue=3;
                        }
                        if(Rock.lastPosition[pieceValue].x<8){
                            Rock.Validation((int) Rock.lastPosition[pieceValue].getX(), (int) Rock.lastPosition[pieceValue].getY(), board.piece[Rock.lastPosition[pieceValue].x][Rock.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 14; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 14; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Rock.lastPosition[pieceValue].getX(), (int) Rock.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if(isMoved){
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==3){
                            break;
                        }
                    }
                    //Promoted Rocks
                    if(Check.isChecked){
                        for (int i = 4; i < 12; i++) {
                            if (Rock.lastPosition[i].x < 8) {
                                Rock.Validation((int) Rock.lastPosition[i].getX(), (int) Rock.lastPosition[i].getY(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y]);
                                for (int k = 0; k < 14; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 14; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Rock.lastPosition[i].getX(), (int) Rock.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if(isMoved){
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }
                //Knight
                if (!isMoved) {
                    changePiece=false;
                    while(!isMoved){
                        if(!changePiece){
                            pieceValue=2;
                            changePiece=true;
                        }
                        else{
                            pieceValue=3;
                        }
                        if(Knight.lastPosition[pieceValue].x<8){
                            Knight.Validation((int) Knight.lastPosition[pieceValue].getX(), (int) Knight.lastPosition[pieceValue].getY(), board.piece[Knight.lastPosition[pieceValue].x][Knight.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 8; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 8; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Knight.lastPosition[pieceValue].getX(), (int) Knight.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if(isMoved){
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==3){
                            break;
                        }
                    }
                    //Promoted Knights
                    if(Check.isChecked){
                        for (int i = 4; i < 12; i++) {
                            if (Knight.lastPosition[i].x < 8) {
                                Knight.Validation((int) Knight.lastPosition[i].getX(), (int) Knight.lastPosition[i].getY(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y]);
                                for (int k = 0; k < 8; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 8; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Knight.lastPosition[i].getX(), (int) Knight.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if(isMoved){
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }
                //Bishop
                if (!isMoved) {
                    changePiece=false;
                    while(!isMoved){
                        if(!changePiece){
                            pieceValue=2;
                            changePiece=true;
                        }
                        else{
                            pieceValue=3;
                        }
                        if(Bishop.lastPosition[pieceValue].x<8){
                            Bishop.Validation((int) Bishop.lastPosition[pieceValue].getX(), (int) Bishop.lastPosition[pieceValue].getY(), board.piece[Bishop.lastPosition[pieceValue].x][Bishop.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 13; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 13; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Bishop.lastPosition[pieceValue].getX(), (int) Bishop.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if(isMoved){
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==3){
                            break;
                        }
                    }
                    //Promoted Bishops
                    if(Check.isChecked){
                        for (int i = 4; i < 12; i++) {
                            if (Bishop.lastPosition[i].x < 8) {
                                Bishop.Validation((int) Bishop.lastPosition[i].getX(), (int) Bishop.lastPosition[i].getY(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y]);
                                for (int k = 0; k < 13; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 13; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Bishop.lastPosition[i].getX(), (int) Bishop.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if(isMoved){
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }
                //Queen
                if (!isMoved) {
                    if(Queen.lastPosition[1].x<8){
                        Queen.Validation((int) Queen.lastPosition[1].getX(), (int) Queen.lastPosition[1].getY(), board.piece[Queen.lastPosition[1].x][Queen.lastPosition[1].y]);
                        for (int k = 0; k < 27; k++) {
                            availablePlacesX[k] = ValidPlacesX[k];
                            availablePlacesY[k] = ValidPlacesY[k];
                        }
                        for (int j = 0; j < 27; j++) {
                            if (availablePlacesX[j] != -1) {
                                IsCheck((int) Queen.lastPosition[1].getX(), (int) Queen.lastPosition[1].getY(), availablePlacesX[j], availablePlacesY[j]);
                                if(isMoved){
                                    break;
                                }
                            }
                        }
                    }
                    //Promoted Queens
                    if(Check.isChecked){
                        for (int i = 2; i < 10; i++) {
                            if (Queen.lastPosition[i].x < 8) {
                                Queen.Validation((int) Queen.lastPosition[i].getX(), (int) Queen.lastPosition[i].getY(), board.piece[Queen.lastPosition[i].x][Queen.lastPosition[i].y]);
                                for (int k = 0; k < 27; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 27; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Queen.lastPosition[i].getX(), (int) Queen.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if(isMoved){
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }
                //King
                if (!isMoved) {
                    King.Validation((int) King.lastPosition[1].getX(), (int) King.lastPosition[1].getY(), board.piece[King.lastPosition[1].x][King.lastPosition[1].y]);
                    for (int k = 0; k < 8; k++) {
                        availablePlacesX[k] = ValidPlacesX[k];
                        availablePlacesY[k] = ValidPlacesY[k];
                    }
                    for (int j = 0; j < 8; j++) {
                        if (availablePlacesX[j] != -1) {
                            IsCheck((int) King.lastPosition[1].getX(), (int) King.lastPosition[1].getY(), availablePlacesX[j], availablePlacesY[j]);
                            if (isMoved) {
                                break;
                            }
                        }
                    }
                }
            }

            //Game is over
            if(!isMoved){
                System.out.println("Black Player wins !");
                System.out.println("Black Counter"+Game.B_scoreCounter+" \nWhite counter"+Game.W_scoreCounter);
                Game.Time1.timer.stop();
                Game.Time2.timer.stop();
                leaderboard.insert(Inputs.player_2.getText(),Game.B_scoreCounter-Game.W_scoreCounter);
                Game.pause=true;
                Game.border_box=false;
            }
            else{
                System.out.println("White Can Move");
            }

            //Black king is checked
        } else {
            if (Check.BlackChecked()) {
                //Black Pawns
                for (int i = 0; i < 8; i++) {
                    if (Pawn.lastPosition[i].x < 8) {
                        Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
                        for (int k = 0; k < 4; k++) {
                            availablePlacesX[k] = ValidPlacesX[k];
                            availablePlacesY[k] = ValidPlacesY[k];
                        }
                        for (int j = 0; j < 4; j++) {
                            if (availablePlacesX[j] != -1) {
                                IsCheck((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                        if (isMoved) {
                            break;
                        }
                    }
                }

                //Rock
                if (!isMoved) {
                    changePiece = false;
                    while (!isMoved) {
                        if (!changePiece) {
                            pieceValue = 0;
                            changePiece = true;
                        } else {
                            pieceValue = 1;
                        }
                        if (Rock.lastPosition[pieceValue].x < 8) {
                            Rock.Validation((int) Rock.lastPosition[pieceValue].getX(), (int) Rock.lastPosition[pieceValue].getY(), board.piece[Rock.lastPosition[pieceValue].x][Rock.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 14; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 14; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Rock.lastPosition[pieceValue].getX(), (int) Rock.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if (isMoved) {
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==1){
                            break;
                        }
                    }
                    //Promoted Rocks
                    if (Check.isChecked) {
                        for (int i = 12; i < 18; i++) {
                            if (Rock.lastPosition[i].x < 8) {
                                Rock.Validation((int) Rock.lastPosition[i].getX(), (int) Rock.lastPosition[i].getY(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y]);
                                for (int k = 0; k < 14; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 14; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Rock.lastPosition[i].getX(), (int) Rock.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if (isMoved) {
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }

                //Knight
                if (!isMoved) {
                    changePiece = false;
                    while (!isMoved) {
                        if (!changePiece) {
                            pieceValue = 0;
                            changePiece = true;
                        } else {
                            pieceValue = 1;
                        }
                        if (Knight.lastPosition[pieceValue].x < 8) {
                            Knight.Validation((int) Knight.lastPosition[pieceValue].getX(), (int) Knight.lastPosition[pieceValue].getY(), board.piece[Knight.lastPosition[pieceValue].x][Knight.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 8; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 8; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Knight.lastPosition[pieceValue].getX(), (int) Knight.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if (isMoved) {
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==1){
                            break;
                        }
                    }
                    //Promoted Knights
                    if (Check.isChecked) {
                        for (int i = 12; i < 18; i++) {
                            if (Knight.lastPosition[i].x < 8) {
                                Knight.Validation((int) Knight.lastPosition[i].getX(), (int) Knight.lastPosition[i].getY(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y]);
                                for (int k = 0; k < 8; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 8; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Knight.lastPosition[i].getX(), (int) Knight.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if (isMoved) {
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }

                //Bishop
                if (!isMoved) {
                    changePiece = false;
                    while (!isMoved) {
                        if (!changePiece) {
                            pieceValue = 0;
                            changePiece = true;
                        } else {
                            pieceValue = 1;
                        }
                        if (Bishop.lastPosition[pieceValue].x < 8) {
                            Bishop.Validation((int) Bishop.lastPosition[pieceValue].getX(), (int) Bishop.lastPosition[pieceValue].getY(), board.piece[Bishop.lastPosition[pieceValue].x][Bishop.lastPosition[pieceValue].y]);
                            for (int k = 0; k < 13; k++) {
                                availablePlacesX[k] = ValidPlacesX[k];
                                availablePlacesY[k] = ValidPlacesY[k];
                            }
                            for (int j = 0; j < 13; j++) {
                                if (availablePlacesX[j] != -1) {
                                    IsCheck((int) Bishop.lastPosition[pieceValue].getX(), (int) Bishop.lastPosition[pieceValue].getY(), availablePlacesX[j], availablePlacesY[j]);
                                    if (isMoved) {
                                        break;
                                    }
                                }
                            }
                        }
                        if(pieceValue==1){
                            break;
                        }
                    }
                    //Promoted Bishops
                    if (Check.isChecked) {
                        for (int i = 12; i < 18; i++) {
                            if (Bishop.lastPosition[i].x < 8) {
                                Bishop.Validation((int) Bishop.lastPosition[i].getX(), (int) Bishop.lastPosition[i].getY(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y]);
                                for (int k = 0; k < 13; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 13; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Bishop.lastPosition[i].getX(), (int) Bishop.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if (isMoved) {
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }

                //Queen
                if (!isMoved) {
                    if (Queen.lastPosition[0].x < 8) {
                        Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
                        for (int k = 0; k < 27; k++) {
                            availablePlacesX[k] = ValidPlacesX[k];
                            availablePlacesY[k] = ValidPlacesY[k];
                        }
                        for (int j = 0; j < 27; j++) {
                            if (availablePlacesX[j] != -1) {
                                IsCheck((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), availablePlacesX[j], availablePlacesY[j]);
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                    //Promoted Queens
                    if (Check.isChecked) {
                        for (int i = 10; i < 18; i++) {
                            if (Queen.lastPosition[i].x < 8) {
                                Queen.Validation((int) Queen.lastPosition[i].getX(), (int) Queen.lastPosition[i].getY(), board.piece[Queen.lastPosition[i].x][Queen.lastPosition[i].y]);
                                for (int k = 0; k < 27; k++) {
                                    availablePlacesX[k] = ValidPlacesX[k];
                                    availablePlacesY[k] = ValidPlacesY[k];
                                }
                                for (int j = 0; j < 27; j++) {
                                    if (availablePlacesX[j] != -1) {
                                        IsCheck((int) Queen.lastPosition[i].getX(), (int) Queen.lastPosition[i].getY(), availablePlacesX[j], availablePlacesY[j]);
                                        if (isMoved) {
                                            break;
                                        }
                                    }
                                }
                                if (isMoved) {
                                    break;
                                }
                            }
                        }
                    }
                }

                //King
                if (!isMoved) {
                    King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
                    for (int k = 0; k < 8; k++) {
                        availablePlacesX[k] = ValidPlacesX[k];
                        availablePlacesY[k] = ValidPlacesY[k];
                    }
                    for (int j = 0; j < 8; j++) {
                        if (availablePlacesX[j] != -1) {
                            IsCheck((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), availablePlacesX[j], availablePlacesY[j]);
                            if (isMoved) {
                                break;
                            }
                        }
                    }
                }
            }
            //Game is over
            if(!isMoved){
                System.out.println("White Player wins !");
                System.out.println("White Counter"+Game.W_scoreCounter+" \nBlack counter"+Game.B_scoreCounter);
                Game.Time1.timer.stop();
                Game.Time2.timer.stop();
                leaderboard.insert(Inputs.player_1.getText(),Game.W_scoreCounter-Game.B_scoreCounter);
                Game.pause=true;
                Game.border_box=false;
            }
            else{
                System.out.println("Black Can Move");
            }
        }
    }
}

