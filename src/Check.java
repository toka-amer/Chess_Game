public class Check {
    static Music m =new Music();
    static boolean isChecked = false;

    //Black Pawn
    public static boolean Pawn_WhiteChecked(int x, int y, int type, int num) {
        Pawn.Validation((int) Pawn.lastPosition[num].getX(), (int) Pawn.lastPosition[num].getY(), type);
        WhiteKingChecked(x, y);
        return isChecked;
    }
    //White Pawn

    public static boolean Pawn_BlackChecked(int x, int y, int type, int num) {
        if(board.piece [(int)Pawn.lastPosition[num].getX()] [(int)Pawn.lastPosition[num].getY()]>0&&board.piece [(int)Pawn.lastPosition[num].getX()] [(int)Pawn.lastPosition[num].getY()]<9) {
            Pawn.Validation((int) Pawn.lastPosition[num].getX(), (int) Pawn.lastPosition[num].getY(), type);
            BlackKingChecked(x, y);
        }
        return isChecked;
    }
    //Black Rock
    public static boolean Rock_WhiteChecked(int x, int y, int type, int num) {
        Rock.Validation((int) Rock.lastPosition[num].getX(), (int) Rock.lastPosition[num].getY(), type);
        WhiteKingChecked(x, y);
        return isChecked;
    }
    //White Rock

    public static boolean Rock_BlackChecked(int x, int y, int type, int num) {
        if(board.piece [(int)Rock.lastPosition[num].getX()] [(int)Rock.lastPosition[num].getY()]==9||board.piece [(int)Rock.lastPosition[num].getX()] [(int)Rock.lastPosition[num].getY()]==16) {
            Rock.Validation((int) Rock.lastPosition[num].getX(), (int) Rock.lastPosition[num].getY(), type);
            BlackKingChecked(x, y);
        }
        return isChecked;
    }
    //Black Knight
    public static boolean Knight_WhiteChecked(int x, int y, int type, int num) {
        Knight.Validation((int) Knight.lastPosition[num].getX(), (int) Knight.lastPosition[num].getY(), type);
        WhiteKingChecked(x, y);
        return isChecked;
    }
    //White Knight

    public static boolean Knight_BlackChecked(int x, int y, int type, int num) {
        if(board.piece [(int)Knight.lastPosition[num].getX()] [(int)Knight.lastPosition[num].getY()]==10||board.piece [(int)Knight.lastPosition[num].getX()] [(int)Knight.lastPosition[num].getY()]==15) {
            Knight.Validation((int) Knight.lastPosition[num].getX(), (int) Knight.lastPosition[num].getY(), type);
            BlackKingChecked(x, y);
        }
        return isChecked;
    }
    //Black Bishop
    public static boolean Bishop_WhiteChecked(int x, int y, int type, int num) {
        Bishop.Validation((int) Bishop.lastPosition[num].getX(), (int) Bishop.lastPosition[num].getY(), type);
        WhiteKingChecked(x, y);
        return isChecked;
    }
    //White Bishop

    public static boolean Bishop_BlackChecked(int x, int y, int type, int num) {
        if(board.piece [(int)Bishop.lastPosition[num].getX()] [(int)Bishop.lastPosition[num].getY()]==11||board.piece [(int)Bishop.lastPosition[num].getX()] [(int)Bishop.lastPosition[num].getY()]==14) {
            Bishop.Validation((int) Bishop.lastPosition[num].getX(), (int) Bishop.lastPosition[num].getY(), type);
            BlackKingChecked(x, y);
        }
        return isChecked;
    }
    //Black Queen
    public static boolean Queen_WhiteChecked(int x, int y, int type, int num) {
        Queen.Validation((int) Queen.lastPosition[num].getX(), (int) Queen.lastPosition[num].getY(), type);
        WhiteKingChecked(x, y);
        return isChecked;
    }
    //White Queen

    public static boolean Queen_BlackChecked(int x, int y, int type, int num) {
        if(board.piece [(int)Queen.lastPosition[num].getX()] [(int)Queen.lastPosition[num].getY()]==12) {
            Queen.Validation((int) Queen.lastPosition[num].getX(), (int) Queen.lastPosition[num].getY(), type);
            BlackKingChecked(x, y);
        }
        return isChecked;
    }
    //Black King
    public static void King_WhiteChecked(int x, int y) {
        King.Validation((int) King.lastPosition[0].getX(), (int) King.lastPosition[0].getY(),-13);
        WhiteKingChecked(x, y);
    }
    //White King

    public static void King_BlackChecked(int x, int y) {
        if (board.piece[(int) King.lastPosition[1].getX()][(int) King.lastPosition[1].getY()] == 13) {
            King.Validation((int) King.lastPosition[1].getX(), (int) King.lastPosition[1].getY(), 13);
            BlackKingChecked(x, y);
        }
    }
    public static void WhiteKingChecked(int x, int y) {
        isChecked = false;
        for (int i = 0; i < 27; i++) {
            if (y == Pieces.ValidPlacesX[i] && x == Pieces.ValidPlacesY[i]) {
                if((board.piece[Game.point2Y][Game.point2X]<0)&&(!King.isCastled)){
                    m.checksound();
                }
                isChecked = true;
                break;
            }
        }
    }

    public static void BlackKingChecked(int x, int y) {
        isChecked = false;
        for (int i = 0; i < 27; i++) {
            if (y == Pieces.ValidPlacesX[i] && x == Pieces.ValidPlacesY[i]) {
                if ((board.piece[Game.point2Y][Game.point2X] > 0)&&(!King.isCastled)) {
                    m.checksound();
                }
                isChecked = true;
                break;

            }
        }
    }

    // Black king in danger
    public static boolean BlackChecked() {
        //White Pawn
        for (int i = 8; i < 16; i++) {
            if (Pawn.lastPosition[i].x < 8) {
                if(Pawn_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y], i)){
                    break;
                }
            }
        }
        //White Rock
        if(!isChecked){
            for (int i = 2; i < 4; i++) {
                if (Rock.lastPosition[i].x < 8) {
                    if (Rock_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y], i)) {
                        break;
                    }
                }
            }
            if(Rock.isPromoted) {
                for (int i = 4; i < 12; i++) {
                    if (Rock.lastPosition[i].x < 8) {
                        if (Rock_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //White Knight
        if(!isChecked){
            for (int i = 2; i < 4; i++) {
                if (Knight.lastPosition[i].x < 8) {
                    if (Knight_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y], i)) {
                        break;
                    }
                }
            }
            if(Knight.isPromoted) {
                for (int i = 4; i < 12; i++) {
                    if (Knight.lastPosition[i].x < 8) {
                        if (Knight_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //White Bishop
        if(!isChecked){
            for (int i = 2; i < 4; i++) {
                if (Bishop.lastPosition[i].x <8) {
                    if (Bishop_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y], i)) {
                        break;
                    }
                }
            }
            if(Bishop.isPromoted){
                for (int i = 4; i < 12; i++) {
                    if (Bishop.lastPosition[i].x < 8) {
                        if (Bishop_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //White Queen
        if(!isChecked) {
            if (Queen.lastPosition[1].x < 8) {
                Queen_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), 12,1);
            }
            if (Queen.isPromoted) {
                for (int i = 2; i < 10; i++) {
                    if (Queen.lastPosition[i].x < 8) {
                        if(Queen_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX(), 33 + Queen.promotion_counter_W-1,i))
                            break;
                    }
                }
            }
        }
        //White King
        if(!isChecked){
            King_BlackChecked((int) Game.B_King_Pos.getY(), (int) Game.B_King_Pos.getX());
        }
        return isChecked;
    }

    public static boolean WhiteChecked() {
        //Black Pawn
        for (int i = 0; i < 8; i++) {
            if (Pawn.lastPosition[i].x < 8) {
                if (Pawn_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Pawn.lastPosition[i].x][Pawn.lastPosition[i].y], i)) {
                    break;
                }
            }
        }
        //Black Rock
        if(!isChecked){
            for (int i = 0; i < 2; i++) {
                if (Rock.lastPosition[i].x < 8) {
                    if (Rock_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y], i)) {
                        break;
                    }
                }
            }
            if(Rock.isPromoted) {
                for (int i = 12; i < 20; i++) {
                    if (Rock.lastPosition[i].x < 8) {
                        if (Rock_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Rock.lastPosition[i].x][Rock.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //Black Knight
        if(!isChecked){
            for (int i = 0; i < 2; i++) {
                if (Knight.lastPosition[i].x < 8) {
                    if (Knight_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y], i)) {
                        break;
                    }
                }
            }
            if(Knight.isPromoted){
                for(int i=12; i<20;i++){
                    if (Knight.lastPosition[i].x < 8) {
                        if (Knight_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Knight.lastPosition[i].x][Knight.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //Black Bishop
        if(!isChecked){
            for (int i = 0; i < 2; i++) {
                if (Bishop.lastPosition[i].x < 8 ) {
                    if (Bishop_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y], i)) {
                        break;
                    }
                }

            }
            if(Bishop.isPromoted){
                for (int i = 12; i < 20; i++) {
                    if (Bishop.lastPosition[i].x <8) {
                        if (Bishop_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), board.piece[Bishop.lastPosition[i].x][Bishop.lastPosition[i].y], i)) {
                            break;
                        }
                    }
                }
            }
        }
        //Black Queen
        if(!isChecked){
            if (Queen.lastPosition[0].x <8) {
                Queen_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(),-12,0);
            }
            if(Queen.isPromoted){
                for(int i=10;i<18;i++){
                    if (Queen.lastPosition[i].x <8) {
                        Queen_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX(), -33 -Queen.promotion_counter_B+1,i);
                    }
                }
            }
        }
        if(!isChecked){
            King_WhiteChecked((int) Game.W_King_Pos.getY(), (int) Game.W_King_Pos.getX());
        }
        return isChecked;
    }
}
