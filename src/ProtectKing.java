public class ProtectKing {
    static boolean moving = false;
    static int type;
    static int moveX,moveY;

    public static void Protecting_Piece() {
        boolean no_Protection = true;

        // Pawn
        if(no_Protection) {
            for (int i = 0; i < 8; i++) {
                if (Pawn.lastPosition[i].x != 100) {
                    Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
                    if (More_effect(i)) {
                        no_Protection = false;
                        break;
                    }
                }
            }
        }
        // Knight
        if(no_Protection) {
            for (int i = 8; i < 10; i++) {
                if (Knight.lastPosition[i - 8].x != 100) {
                    Knight.Validation((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y]);
                    if (More_effect(i)) {
                        no_Protection=false;
                        break;
                    }
                }
            }
        }
        // Rock
        if(no_Protection) {
            for (int i = 10; i < 12; i++) {
                if (Rock.lastPosition[i - 10].x != 100) {
                    Rock.Validation((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y]);
                    if (More_effect(i)) {
                        no_Protection=false;
                        break;
                    }
                }
            }
        }
        // Bishop
        if(no_Protection) {
            for (int i = 12; i < 14; i++) {
                if (Bishop.lastPosition[i - 12].x != 100) {
                    Bishop.Validation((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y]);
                    if (More_effect(i)) {
                        no_Protection=false;
                        break;
                    }
                }
            }
        }
        // Queen
        if(no_Protection) {
            if (Queen.lastPosition[0].x != 100) {
                Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
                if (More_effect(14)) {
                    no_Protection=false;
                }
            }
        }

        // King
        if(no_Protection) {
            if (King.lastPosition[0].x != 100) {
                King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
                if (More_effect(15)) {
                    no_Protection=false;
                }
            }
        }


    }

    public static boolean More_effect(int i ) {
        boolean protection= false;
        // Pawn
        if (i < 8) {
            if (Pawn.counter != 0) {
                for (int k = 0; k < Pawn.counter; k++) {
                    if (Pawn.ValidPlacesX[k] != -1 && Pawn.ValidPlacesY[k] != -1) {
                        if(Protect_B_King(Pawn.lastPosition[i].x, Pawn.lastPosition[i].y, Pawn.ValidPlacesX[k], Pawn.ValidPlacesY[k], i, k))
                        {
                            protection=true;
                            break;
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
                        System.out.println(Knight.ValidPlacesX[k]+" , "+Knight.ValidPlacesY[k]);
                        System.out.println(board.piece[Knight.ValidPlacesX[k]][Knight.ValidPlacesY[k]]);
                       if(Protect_B_King(Knight.lastPosition[i - 8].x, Knight.lastPosition[i - 8].y, Knight.ValidPlacesX[k], Knight.ValidPlacesY[k], i, k))
                       {
                           protection=true;
                           break;
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
                        if(Protect_B_King(Rock.lastPosition[i - 10].x, Rock.lastPosition[i - 10].y, Rock.ValidPlacesX[k], Rock.ValidPlacesY[k], i, k))
                        {
                            protection=true;
                            break;
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
                        if(Protect_B_King(Bishop.lastPosition[i - 12].x, Bishop.lastPosition[i - 12].y, Bishop.ValidPlacesX[k], Bishop.ValidPlacesY[k], i, k))
                        {
                            protection=true;
                            break;
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
                        if(Protect_B_King(Queen.lastPosition[0].x, Queen.lastPosition[0].y, Queen.ValidPlacesX[k], Queen.ValidPlacesY[k], i, k))
                        {
                            protection=true;
                            break;
                        }
                    }
                }
            }
        }
        // King
        else if (i == 15) {
            if (King.counter != 0) {
                for (int k = 0; k < King.counter; k++) {
                    if (King.ValidPlacesX[k] != -1 && King.ValidPlacesY[k] != -1) {
                        if(Protect_B_King(King.lastPosition[0].x, King.lastPosition[0].y, King.ValidPlacesX[k], King.ValidPlacesY[k], i, k))
                        {
                            protection=true;
                            break;
                        }
                    }
                }
            }
        }
        return protection;
    }
    public static boolean Protect_B_King(int last_positionX,int last_positionY,int validplaceX,int validplaceY,int i ,int k)
    {


        boolean kingProtected = false;

        int lastX = last_positionX;
        int lastY =last_positionY;
        int lastT = board.piece[lastX][lastY];

        int validX = validplaceX;
        int validY = validplaceY;
        int validT = board.piece[validX][validY];

        board.piece[validX][validY] = lastT;
        board.piece[lastX][lastY] = 0;

        if(i<8) {
            Pawn.lastPosition[i].x = validX;
            Pawn.lastPosition[i].y = validY;

            if (!Check.BlackChecked()) {
                kingProtected=true;
                Pawn.lastPosition[i].x = lastX;
                Pawn.lastPosition[i].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) Pawn.lastPosition[i].getX()][(int) Pawn.lastPosition[i].getY()];
                Pawn.Move((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(),validX,validY,(i*-1)-1);

            }
            else {
                Pawn.lastPosition[i].x = lastX;
                Pawn.lastPosition[i].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Pawn.Validation((int) Pawn.lastPosition[i].getX(), (int) Pawn.lastPosition[i].getY(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y]);
            }

        }
        // Knight
        else if (i > 7 && i < 10) {
            Knight.lastPosition[i - 8].x = validX;
            Knight.lastPosition[i - 8].y = validY;
            if (!Check.BlackChecked()) {
                kingProtected=true;
                System.out.println(kingProtected);
                Knight.lastPosition[i - 8].x = lastX;
                Knight.lastPosition[i - 8].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Knight.Validation((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) Knight.lastPosition[i - 8].getX()][(int) Knight.lastPosition[i - 8].getY()];
               Knight.Move((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(),validX,validY);

            }
            else {
                Knight.lastPosition[i - 8].x = lastX;
                Knight.lastPosition[i - 8].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Knight.Validation((int) Knight.lastPosition[i - 8].getX(), (int) Knight.lastPosition[i - 8].getY(), board.piece[Knight.lastPosition[i - 8].x][Knight.lastPosition[i - 8].y]);
            }
        }
        // Rock
        else if (i > 9 && i < 12) {
            Rock.lastPosition[i - 10].x = validX;
            Rock.lastPosition[i - 10].y = validY;
            if (!Check.BlackChecked()) {
                kingProtected=true;
                Rock.lastPosition[i - 10].x = lastX;
                Rock.lastPosition[i - 10].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Rock.Validation((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) Rock.lastPosition[i - 10].getX()][(int) Rock.lastPosition[i - 10].getY()];
                Rock.Move((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(),validX,validY);

            }
            else{Rock.lastPosition[i - 10].x = lastX;
            Rock.lastPosition[i - 10].y = lastY;
            Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
            Rock.Validation((int) Rock.lastPosition[i - 10].getX(), (int) Rock.lastPosition[i - 10].getY(), board.piece[Rock.lastPosition[i - 10].x][Rock.lastPosition[i - 10].y]);}

        }
        // Bishop
        else if (i > 11 && i < 14) {
            Bishop.lastPosition[i - 12].x = validX;
            Bishop.lastPosition[i - 12].y = validY;
            if (!Check.BlackChecked()) {
                kingProtected=true;
                Bishop.lastPosition[i - 12].x = lastX;
                Bishop.lastPosition[i - 12].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Bishop.Validation((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) Bishop.lastPosition[i - 12].getX()][(int) Bishop.lastPosition[i - 12].getY()];
                Bishop.Move((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(),validX,validY);
            }
            else {
                Bishop.lastPosition[i - 12].x = lastX;
                Bishop.lastPosition[i - 12].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Bishop.Validation((int) Bishop.lastPosition[i - 12].getX(), (int) Bishop.lastPosition[i - 12].getY(), board.piece[Bishop.lastPosition[i - 12].x][Bishop.lastPosition[i - 12].y]);
            }
        }

        // Queen
        else if (i == 14) {
            Queen.lastPosition[0].x = validX;
            Queen.lastPosition[0].y = validY;
            if (!Check.BlackChecked()) {
                kingProtected=true;
                Queen.lastPosition[0].x = lastX;
                Queen.lastPosition[0].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) Queen.lastPosition[0].getX()][(int)Queen.lastPosition[0].getY()];
                Queen.Move((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(),validX,validY);
            }
            else {
                Queen.lastPosition[0].x = lastX;
                Queen.lastPosition[0].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                Queen.Validation((int) Queen.lastPosition[0].getX(), (int) Queen.lastPosition[0].getY(), board.piece[Queen.lastPosition[0].x][Queen.lastPosition[0].y]);
            }
        }

        // King
        else if (i == 15) {
            King.lastPosition[0].x = validX;
            King.lastPosition[0].y = validY;
            if (!Check.BlackChecked()) {
                kingProtected=true;
                King.lastPosition[0].x = lastX;
                King.lastPosition[0].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
                moving=true;
                moveX=validX;
                moveY=validY;
                type = board.piece[(int) King.lastPosition[0].getX()][(int)King.lastPosition[0].getY()];
                King.Move((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(),validX,validY);
            }
            else {
                King.lastPosition[0].x = lastX;
                King.lastPosition[0].y = lastY;
                Swap_Back(last_positionX, last_positionY, lastT, validX, validY, validT);
                King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(), board.piece[King.lastPosition[0].x][King.lastPosition[0].y]);
            }
        }
        moving=false;
        return kingProtected;
    }
    public static void Swap_Back(int last_positionX,int last_positionY ,int last_pT,int validX,int validY,int validT) {
        board.piece[last_positionX][last_positionY] = last_pT;
        board.piece[validX][validY] = validT;
    }
}
