import javax.swing.*;
import java.awt.*;

public class King extends Pieces {

    static Point[] lastPosition = {new Point(0, 4), new Point(7, 4)};
    static boolean isCastled,isRCastled,isLCastled;



    public King(int type, int x, int y) {
        if (type == 13) {
            this.Color = "\\Pieces\\W_King.png";
        } else if (type == -13) {
            this.Color = "\\Pieces\\B_King.png";
        }
        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 72, 72);
    }

    public static void Validation(int p1X, int p1Y, int type) {
        counter = 0;
        Initializing();
        //Valid Places
        // Left
        if (p1Y - 1 >= 0) {
            // black
            if (type == -13 && board.piece[p1X][p1Y - 1] >= 0) {
                ValidPlacesX[counter] = p1X;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X][p1Y - 1] <= 0) {
                ValidPlacesX[counter] = p1X;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
        }

        // Top Left
        if (p1Y - 1 >= 0 && p1X - 1 >= 0) {
            // black
            if (type == -13 && board.piece[p1X - 1][p1Y - 1] >= 0) {
                ValidPlacesX[counter] = p1X - 1;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X - 1][p1Y - 1] <= 0) {
                ValidPlacesX[counter] = p1X - 1;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
        }

        // Down Left
        if (p1Y - 1 >= 0 && p1X + 1 <= 7) {
            // black
            if (type == -13 && board.piece[p1X + 1][p1Y - 1] >= 0) {
                ValidPlacesX[counter] = p1X + 1;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X + 1][p1Y - 1] <= 0) {
                ValidPlacesX[counter] = p1X + 1;
                ValidPlacesY[counter] = p1Y - 1;
                counter++;
            }
        }
        // Top Right
        if (p1Y + 1 <= 7 && p1X - 1 >= 0) {
            // black
            if (type == -13 && board.piece[p1X - 1][p1Y + 1] >= 0) {
                ValidPlacesX[counter] = p1X - 1;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X - 1][p1Y + 1] <= 0) {
                ValidPlacesX[counter] = p1X - 1;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
        }

        // Right
        if (p1Y + 1 <= 7) {
            // black
            if (type == -13 && board.piece[p1X][p1Y + 1] >= 0) {
                ValidPlacesX[counter] = p1X;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X][p1Y + 1] <= 0) {
                ValidPlacesX[counter] = p1X;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
        }

        // Down Right
        if (p1Y + 1 <= 7 && p1X + 1 <= 7) {
            // black
            if (type == -13 && board.piece[p1X + 1][p1Y + 1] >= 0) {
                ValidPlacesX[counter] = p1X + 1;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
            // white
            else if (type == 13 && board.piece[p1X + 1][p1Y + 1] <= 0) {
                ValidPlacesX[counter] = p1X + 1;
                ValidPlacesY[counter] = p1Y + 1;
                counter++;
            }
        }

        // Up
        // black
        if (type == -13 && p1X - 1 > -1 && board.piece[p1X - 1][p1Y] >= 0) {
            ValidPlacesX[counter] = p1X - 1;
            ValidPlacesY[counter] = p1Y;
            counter++;
        }
        // white
        else if (type == 13 && p1X - 1 >= 0 && board.piece[p1X - 1][p1Y] <= 0) {
            ValidPlacesX[counter] = p1X - 1;
            ValidPlacesY[counter] = p1Y;
            counter++;
        }

        // Down
        // black
        if (type == -13 && p1X + 1 < 8 && board.piece[p1X + 1][p1Y] >= 0) {
            ValidPlacesX[counter] = p1X + 1;
            ValidPlacesY[counter] = p1Y;
            counter++;
        }
        // white
        else if (type == 13 && p1X + 1 <= 7 && board.piece[p1X + 1][p1Y] <= 0) {
            ValidPlacesX[counter] = p1X + 1;
            ValidPlacesY[counter] = p1Y;
            counter++;
        }
    }
    //Castling
    public static void Castling (int p1X, int p1Y, int type) {
        isCastled =false;
        isRCastled =false;
        isLCastled =false;
        if (type == -13) {
            if (!Check.BlackChecked()) {
                //King Castle (Right Black Rock)
                if (right_B_Rock == 0) {
                    if (board.piece[p1X][p1Y + 2] == 0 && board.piece[p1X][p1Y + 1] == 0) {
                        isCastled=true;
                        IsCheck(p1X,p1Y,0,5);
                    }
                }
                //Queen Castle (Left Black Rock)
                if (left_B_Rock == 0) {
                    if (board.piece[p1X][p1Y - 3] == 0 && board.piece[p1X][p1Y - 2] == 0 && board.piece[p1X][p1Y - 1] == 0) {
                        isCastled=true;
                        IsCheck(p1X,p1Y,0,3);
                    }
                }

                if(isRCastled){
                    Validation(p1X, p1Y, type);
                    ValidPlacesX[counter] = p1X;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
                if(isLCastled){
                    if(!isRCastled){
                        Validation(p1X, p1Y, type);
                    }
                    ValidPlacesX[counter] = p1X;
                    ValidPlacesY[counter] = p1Y - 2;
                    counter++;
                }
                if(!isRCastled&&!isLCastled){
                    Validation(p1X, p1Y, type);
                }
            }
            else{
                Validation(p1X, p1Y, type);
            }
        }
        else if (type == 13) {
            if (!Check.WhiteChecked()) {
                //King Castle (Right White Rock)
                if (right_W_Rock == 0) {
                    if (board.piece[p1X][p1Y + 2] == 0 && board.piece[p1X][p1Y + 1] == 0) {
                        isCastled=true;
                        IsCheck(p1X,p1Y,7,5);
                    }
                }
                //Queen Castle(Left White Rock)
                if (left_W_Rock == 0) {
                    if (board.piece[p1X][p1Y - 3] == 0 && board.piece[p1X][p1Y - 2] == 0 && board.piece[p1X][p1Y - 1] == 0) {
                        isCastled=true;
                        IsCheck(p1X,p1Y,7,3);
                    }
                }
                if(isRCastled){
                    Validation(p1X, p1Y, type);
                    ValidPlacesX[counter] = p1X;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
                if(isLCastled){
                    if(!isRCastled){
                        Validation(p1X, p1Y, type);
                    }
                    ValidPlacesX[counter] = p1X;
                    ValidPlacesY[counter] = p1Y - 2;
                    counter++;
                }
                if(!isRCastled&&!isLCastled){
                    Validation(p1X, p1Y, type);
                }
            }
            else {
                Validation(p1X, p1Y, type);
            }
        }
    }
    //Check Point 2
    public static boolean Move(int p1X, int p1Y, int p2X, int p2Y) {
        isMoved = false;
        for (int i = 0; i < 8; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {
                isCastled =false;
                IsCheck(p1X, p1Y, p2X, p2Y);
                if (isMoved) {
                    //Motion of King
                    if(Selection.computer_play) {
                        Point p;
                        if (Computer.moving) {
                            p = new Point(Computer.moveY, Computer.moveX);
                            if (Computer.type == -13) {
                                Game.king[0].setPosition(p);
                                lastPosition[0].x = Computer.moveX;
                                lastPosition[0].y = Computer.moveY;
                            }
                        }
                        else if (ProtectKing.moving)
                        {
                            p = new Point(ProtectKing.moveY, ProtectKing.moveX);
                            if(ProtectKing.type==-13)
                            {
                                Game.king[0].setPosition(p);
                                lastPosition[0].x = ProtectKing.moveX;
                                lastPosition[0].y = ProtectKing.moveY;
                            }

                        }
                    }

                    //Black
                    if (!Selection.computer_play&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -13) {
                        Game.king[0].setPosition(Game.p2);
                        blackKingCounter++;
                        lastPosition[0].x = p2X;
                        lastPosition[0].y = p2Y;
                    }
                    // white
                    else if (!ProtectKing.moving&&!Computer.moving&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 13) {
                        Game.king[1].setPosition(Game.p2);
                        whiteKingCounter++;
                        lastPosition[1].x = p2X;
                        lastPosition[1].y = p2Y;
                    }
                    //Castling
                    //BlackCastling
                    //KingSide
                    if (blackKingCounter == 1 && right_B_Rock == 0) {
                        if (board.piece[0][6] == -13) {
                            Rock.ValidPlacesX[0] = 0;
                            Rock.ValidPlacesY[0] = 5;
                            Rock.Move(0, 7, 0, 5);
                        }
                    }
                    //QueenSide
                    if (blackKingCounter == 1 && left_B_Rock == 0) {
                        if (board.piece[0][2] == -13) {
                            Rock.ValidPlacesX[0] = 0;
                            Rock.ValidPlacesY[0] = 3;
                            Rock.Move(0, 0, 0, 3);
                        }
                    }
                    //WhiteCastling
                    //KingSide
                    if (whiteKingCounter == 1 && right_W_Rock == 0) {
                        if (board.piece[7][6] == 13) {
                            Rock.ValidPlacesX[0] = 7;
                            Rock.ValidPlacesY[0] = 5;
                            Rock.Move(7, 7, 7, 5);
                        }
                    }
                    //QueenSide
                    if (whiteKingCounter == 1 && left_W_Rock == 0) {
                        if (board.piece[7][2] == 13) {
                            Rock.ValidPlacesX[0] = 7;
                            Rock.ValidPlacesY[0] = 3;
                            Rock.Move(7, 0, 7, 3);
                        }
                    }
                    break;
                }
            }
        }
        return isMoved;
    }
}