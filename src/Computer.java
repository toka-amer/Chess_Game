import java.util.Random;

public class Computer {

    static int[] computer_pieces = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
    static int[] valid_pieces = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
    static int[] piece_moves = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] valid_moves = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static Random random = new Random();

    static int last_pX,last_pY,last_pT;
    static int moveX, moveY;
    static int random_Pieces;
    static int random_Moves;
    static int chosen;
    static int type;

    static boolean moving = false;

    public static void Initialization() {
        for (int i = 0; i < 16; i++) {
            computer_pieces[i] = 0;
        }
    }

    public static void Valid_Piece() {
        Initialization();
        // Pawn
        for (int i = 0; i < 8; i++) {
            if (Pawn.lastPosition[i].x != 100) {
                Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
                More_effect(i, false);
            }
        }
        // Knight
        for (int i = 8; i < 10; i++) {
            if (Knight.lastPosition[i - 8].x != 100) {
                Knight.Validation((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y]);
                More_effect(i, false);
            }
        }
        // Rock
        for (int i = 10; i < 12; i++) {
            if (Rock.lastPosition[i - 10].x != 100) {
                Rock.Validation((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y]);
                More_effect(i, false);
            }
        }
        // Bishop
        for (int i = 12; i < 14; i++) {
            if (Bishop.lastPosition[i - 12].x != 100) {
                Bishop.Validation((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y]);
                More_effect(i, false);
            }
        }
        // Queen
        if (Queen.lastPosition[0].x != 100) {
            Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
            More_effect(14, false);
        }

        // King
        King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
        More_effect(15, false);
    }

    public static boolean Swap(int last_positionX,int last_positionY,int validplaceX,int validplaceY,int i ,int k, boolean function) {
        boolean effect = false;
        last_pX = last_positionX;
        last_pY = last_positionY;
        last_pT = board.piece[last_pX][last_pY];
        int validX = validplaceX;
        int validY = validplaceY;
        int validT = board.piece[validX][validY];
        board.piece[validX][validY] = last_pT;
        board.piece[last_pX][last_pY] = 0;
        // Pawn
        if (i < 8) {
            Pawn.lastPosition[i].x = validX;
            Pawn.lastPosition[i].y = validY;
            if (Check.Pawn_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), (i * -1) - 1, i)) {
                ArrayOf(function, 5, i, k);
                effect = true;
            }
            Pawn.lastPosition[i].x = last_pX;
            Pawn.lastPosition[i].y = last_pY;
            Swap_Back(last_positionX, last_positionY, last_pT, validX, validY, validT);
            Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
        }
        // Knight
        else if (i > 7 && i < 10) {
            Knight.lastPosition[i - 8].x = validX;
            Knight.lastPosition[i - 8].y = validY;
            if (Check.Knight_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y], i - 8)) {
                ArrayOf(function, 5, i, k);
                effect = true;
            }
            Knight.lastPosition[i - 8].x = last_pX;
            Knight.lastPosition[i - 8].y = last_pY;
            Swap_Back(last_positionX, last_positionY, last_pT, validX, validY, validT);
            Knight.Validation((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y]);
        }
        // Rock
        else if (i > 9 && i < 12) {
            Rock.lastPosition[i - 10].x = validX;
            Rock.lastPosition[i - 10].y = validY;
            if (Check.Rock_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y], i - 10)) {
                ArrayOf(function, 5, i, k);
                effect = true;
            }
            Rock.lastPosition[i - 10].x = last_pX;
            Rock.lastPosition[i - 10].y = last_pY;
            Swap_Back(last_positionX, last_positionY, last_pT, validX, validY, validT);
            Rock.Validation((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y]);
        }
        // Bishop
        else if (i > 11 && i < 14) {
            Bishop.lastPosition[i - 12].x = validX;
            Bishop.lastPosition[i - 12].y = validY;
            if (Check.Bishop_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y], i - 12)) {
                ArrayOf(function, 5, i, k);
                effect = true;
            }
            Bishop.lastPosition[i - 12].x = last_pX;
            Bishop.lastPosition[i - 12].y = last_pY;
            Swap_Back(last_positionX, last_positionY, last_pT, validX, validY, validT);
            Bishop.Validation((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y]);
        }
        // Queen
        else if (i == 14) {
            Queen.lastPosition[0].x = validX;
            Queen.lastPosition[0].y = validY;
            if (Check.Queen_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y], 0)) {
                ArrayOf(function, 5, i, k);
                effect = true;
            }
            Queen.lastPosition[0].x = last_pX;
            Queen.lastPosition[0].y = last_pY;
            Swap_Back(last_positionX, last_positionY, last_pT, validX, validY, validT);
            Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
        }
        return effect;
    }

    public static void Swap_Back(int last_positionX,int last_positionY ,int last_pT,int validX,int validY,int validT) {
        board.piece[last_positionX][last_positionY] = last_pT;
        board.piece[validX][validY] = validT;
    }

    public static void More_effect(int i, boolean function  ) {
        // Pawn
        if (i < 8) {
            if (Pawn.counter != 0) {
                for (int k = 0; k < Pawn.counter; k++) {
                    if (Pawn.ValidPlacesX[k] != -1 && Pawn.ValidPlacesY[k] != -1) {
                        Swap(Pawn.lastPosition[i].x, Pawn.lastPosition[i].y, Pawn.ValidPlacesX[k], Pawn.ValidPlacesY[k], i, k, function);
                        if (board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 12) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 9 || board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 10 || board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 11 || board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 14 || board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 15 || board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]] < 9 && board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[Pawn.ValidPlacesX[k]][Pawn.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }
                    }
                }
            }
        }
        // Knight
        else if (i > 7 && i < 10) {
            if (Knight.counter != 0) {
                for (int k = 0; k < Knight.counter; k++) {
                    if (Knight.ValidPlacesX[k] != -1 && Knight.ValidPlacesY[k] != -1) {
                        if (Swap(Knight.lastPosition[i - 8].x, Knight.lastPosition[i - 8].y, Knight.ValidPlacesX[k], Knight.ValidPlacesY[k], i, k, function)) {
                            ArrayOf(function, 5, i, k);
                        }
                        else if (board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 12) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 9 || board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 10 || board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 11 || board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 14 || board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 15 || board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]] < 9 && board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }
                    }
                }
            }
        }
        // Rock
        else if (i > 9 && i < 12) {
            if (Rock.counter != 0) {
                for (int k = 0; k < Rock.counter; k++) {
                    if (Rock.ValidPlacesX[k] != -1 && Rock.ValidPlacesY[k] != -1) {
                        Swap(Rock.lastPosition[i - 10].x, Rock.lastPosition[i - 10].y, Rock.ValidPlacesX[k], Rock.ValidPlacesY[k], i, k, function);
                        if (board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 12) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 9 || board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 10 || board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 11 || board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 14 || board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 15 || board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]] < 9 && board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[Rock.ValidPlacesX[k]][Rock.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }
                    }
                }
            }
        }
        // Bishop
        else if (i > 11 && i < 14) {
            if (Bishop.counter != 0) {
                for (int k = 0; k < Bishop.counter; k++) {
                    if (Bishop.ValidPlacesX[k] != -1 && Bishop.ValidPlacesY[k] != -1) {
                        Swap(Bishop.lastPosition[i - 12].x, Bishop.lastPosition[i - 12].y, Bishop.ValidPlacesX[k], Bishop.ValidPlacesY[k], i, k, function);
                        if (board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 12 ) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 9 || board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 10 || board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 11 || board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 14 || board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 15 || board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]] < 9 && board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[Bishop.ValidPlacesX[k]][Bishop.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }
                    }

                }
            }
        }
        // Queen
        else if (i == 14) {
            if (Queen.counter != 0) {
                for (int k = 0; k < Queen.counter; k++) {
                    if (Queen.ValidPlacesX[k] != -1 && Queen.ValidPlacesY[k] != -1) {
                        Swap(Queen.lastPosition[0].x, Queen.lastPosition[0].y, Queen.ValidPlacesX[k], Queen.ValidPlacesY[k], i, k, function);
                        if (board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 12) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 9 || board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 10 || board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 11 || board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 14 || board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 15 || board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]] < 9 && board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[Queen.ValidPlacesX[k]][Queen.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }
                    }
                }
            }
        }
        else if (i == 15) {
            if (King.counter != 0) {
                for (int k = 0; k < King.counter; k++) {
                    if (King.ValidPlacesX[k] != -1 && King.ValidPlacesY[k] != -1) {
                          if (board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 12) {
                            ArrayOf(function, 4, i, k);
                        }
                        else if (board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 9 || board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 10 || board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 11 || board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 14 || board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 15 || board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] == 16) {
                            ArrayOf(function, 3, i, k);
                        }
                        else if (board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]] < 9 && board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]]!=0) {
                            ArrayOf(function, 2, i, k);
                        }
                        else if(board.piece[King.ValidPlacesX[k]][King.ValidPlacesY[k]]==0)
                        {
                            ArrayOf(function, 1, i, k);
                        }

                    }

                }
            }
        }
        if (function) {
            Best_move(i);
        }
    }

    public static void ArrayOf (boolean function , int effect,int i ,int k)
    {
        if(!function) {
            if(effect>computer_pieces[i])
            {
                computer_pieces[i] = effect;
            }
        }
        else if(function)
        {
                piece_moves[k] = effect;
        }
    }

    public static void Best_move(int rand_Pieces) {
        int max_Move = -1;
        int j = 0;
        for (int b = 0; b < Pieces.counter; b++) {
            if (piece_moves[b] >= max_Move) {
                max_Move = piece_moves[b];
            }
        }

        for (int s = 0; s < Pieces.counter; s++) {
            if (piece_moves[s] == max_Move) {
                valid_moves[j] = s;
                j++;
            }
        }
        random_Moves = random.nextInt(j);
        chosen = valid_moves[random_Moves];
    }

    public static void Random() {
        int max_Piece = -1;
        int j = 0;
        boolean is_exist = false;
        random_Pieces = random.nextInt(16);

        for (int s = 0; s < 16; s++) {
            if (computer_pieces[s] >= max_Piece) {
                max_Piece = computer_pieces[s];
            }
        }

        for (int ss = 0; ss < 16; ss++) {
            if (computer_pieces[ss] == max_Piece) {
                valid_pieces[j] = ss;
                j++;
            }
        }

        for (int a = 0; a < 16; a++) {
            if (random_Pieces == valid_pieces[a] && computer_pieces[valid_pieces[a]] == max_Piece) {
                is_exist = true;

                // Pawn
                if (random_Pieces < 8) {
                    Pawn.Validation((int) Pawn.lastPosition[random_Pieces].getX(), (int) Pawn.lastPosition[random_Pieces].getY(), (random_Pieces*-1)-1);
                    More_effect(random_Pieces,true);
                    moving=true;
                    moveX = Pawn.ValidPlacesX[chosen];
                    moveY = Pawn.ValidPlacesY[chosen];
                    Pawn.Move((int) Pawn.lastPosition[random_Pieces].getX(), (int) Pawn.lastPosition[random_Pieces].getY(), Pawn.ValidPlacesX[chosen], Pawn.ValidPlacesY[chosen], (random_Pieces * -1) - 1);
                }
                // Knight
                else if (random_Pieces > 7 && random_Pieces < 10) {
                    Knight.Validation((int) Knight.lastPosition[random_Pieces - 8].getX(), (int) Knight.lastPosition[random_Pieces - 8].getY(), board.piece[Knight.lastPosition[random_Pieces - 8].x][Knight.lastPosition[random_Pieces - 8].y]);
                    moving = true;
                    More_effect(random_Pieces,true);
                    moveX = Knight.ValidPlacesX[chosen];
                    moveY = Knight.ValidPlacesY[chosen];
                    type = board.piece[(int) Knight.lastPosition[random_Pieces - 8].getX()][(int) Knight.lastPosition[random_Pieces - 8].getY()];
                    Knight.Move((int) Knight.lastPosition[random_Pieces - 8].getX(), (int) Knight.lastPosition[random_Pieces - 8].getY(), Knight.ValidPlacesX[chosen], Knight.ValidPlacesY[chosen]);
                }
                // Rock
                else if (random_Pieces > 9 && random_Pieces < 12) {
                    Rock.Validation((int) Rock.lastPosition[random_Pieces - 10].getX(), (int) Rock.lastPosition[random_Pieces - 10].getY(), board.piece[Rock.lastPosition[random_Pieces - 10].x][Rock.lastPosition[random_Pieces - 10].y]);
                    moving = true;
                    More_effect(random_Pieces,true);
                    moveX = Rock.ValidPlacesX[chosen];
                    moveY = Rock.ValidPlacesY[chosen];
                    type = board.piece[(int) Rock.lastPosition[random_Pieces - 10].getX()][(int) Rock.lastPosition[random_Pieces - 10].getY()];
                    Rock.Move((int) Rock.lastPosition[random_Pieces - 10].getX(), (int) Rock.lastPosition[random_Pieces - 10].getY(), Rock.ValidPlacesX[chosen], Rock.ValidPlacesY[chosen]);
                }
                // Bishop
                else if (random_Pieces > 11 && random_Pieces < 14) {
                    Bishop.Validation((int) Bishop.lastPosition[random_Pieces - 12].getX(), (int) Bishop.lastPosition[random_Pieces - 12].getY(), board.piece[Bishop.lastPosition[random_Pieces - 12].x][Bishop.lastPosition[random_Pieces - 12].y]);
                    moving = true;
                    More_effect(random_Pieces,true);
                    moveX = Bishop.ValidPlacesX[chosen];
                    moveY = Bishop.ValidPlacesY[chosen];
                    type = board.piece[(int) Bishop.lastPosition[random_Pieces - 12].getX()][(int) Bishop.lastPosition[random_Pieces - 12].getY()];
                    Bishop.Move((int) Bishop.lastPosition[random_Pieces - 12].getX(), (int) Bishop.lastPosition[random_Pieces - 12].getY(), Bishop.ValidPlacesX[chosen], Bishop.ValidPlacesY[chosen]);
                }
                // Queen
                else if (random_Pieces == 14) {
                    Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
                    moving = true;
                    More_effect(random_Pieces,true);
                    moveX = Queen.ValidPlacesX[chosen];
                    moveY = Queen.ValidPlacesY[chosen];
                    type = board.piece[(int) Queen.lastPosition[0].getX()][(int) Queen.lastPosition[0].getY()];
                    Queen.Move((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), Queen.ValidPlacesX[chosen], Bishop.ValidPlacesY[chosen]);
                }
                // King
                else if (random_Pieces == 15) {
                    King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
                    moving = true;
                    More_effect(random_Pieces,true);
                    moveX = King.ValidPlacesX[chosen];
                    moveY = King.ValidPlacesY[chosen];
                    type = board.piece[(int) King.lastPosition[0].getX()][(int) King.lastPosition[0].getY()];
                    King.Move((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), King.ValidPlacesX[chosen], King.ValidPlacesY[chosen]);
                }
                moving = false;
                break;
            }
        }
        if (!is_exist) {
            Random();
        }
    }
}