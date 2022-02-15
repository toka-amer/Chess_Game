import java.awt.*;

public class board {
    // array have the position (x,y) of the box on the board
    static Point[][] Draw =new Point[8][8];

    //counters count the pieces that have killed
    static int black_cnt=0,white_cnt=0;

    static int lastPosX,lastPosY;
    static int[][] piece = {
            {-9,-10,-11,-12,-13,-14,-15,-16},
            {-1,-2,-3,-4,-5,-6,-7,-8},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {1,2,3,4,5,6,7,8},
            {9,10,11,12,13,14,15,16}
    };
    public board() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                Draw[i][j]=new Point(379+((i)*72),68+((j)*72));
            }
        }
    }

    public static void killPiece() {

        //Black Pawn
        if (Pieces.secondValue < 0 && Pieces.secondValue > -9) {
            if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                //Second time if is checked
                if (Pieces.changeLastPos) {
                    Pawn.lastPosition[(Pieces.secondValue * -1) - 1].x = lastPosX;
                    Pawn.lastPosition[(Pieces.secondValue * -1) - 1].y = lastPosY;
                    //First time
                } else {
                    lastPosX = Pawn.lastPosition[(Pieces.secondValue * -1) - 1].x;
                    lastPosY = Pawn.lastPosition[(Pieces.secondValue * -1) - 1].y;
                    Pawn.lastPosition[(Pieces.secondValue * -1) - 1].x = 100;
                    Pawn.lastPosition[(Pieces.secondValue * -1) - 1].y = 100;
                }
            }
            else {//Second time if not checked
                if (black_cnt < 7) {
                    Game.pawn[(Pieces.secondValue * -1) - 1].setPosition(210, 30 + ((black_cnt++) * 72));
                } else {
                    Game.pawn[(Pieces.secondValue * -1) - 1].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                }
                Game.W_scoreCounter++;

            }
        }
        // White Pawn
        else if (Pieces.secondValue > 0 && Pieces.secondValue < 9) {
            if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                if (Pieces.changeLastPos) {
                    Pawn.lastPosition[Pieces.secondValue + 7].x = lastPosX;
                    Pawn.lastPosition[Pieces.secondValue + 7].y = lastPosY;
                } else {
                    lastPosX = Pawn.lastPosition[Pieces.secondValue + 7].x;
                    lastPosY = Pawn.lastPosition[Pieces.secondValue + 7].y;
                    Pawn.lastPosition[Pieces.secondValue + 7].x = 100;
                    Pawn.lastPosition[Pieces.secondValue + 7].y = 100;
                }
            } else {
                if (white_cnt < 7) {
                    Game.pawn[Pieces.secondValue + 7].setPosition(1067, 30 + ((white_cnt++) * 72));
                } else {
                    Game.pawn[Pieces.secondValue + 7].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                }
                Game.B_scoreCounter++;
            }
        }


        //Black Rock
        else if (Pieces.secondValue == -9 || Pieces.secondValue == -16 || (Pieces.secondValue < -40 && Pieces.secondValue > -49)) {
            if (Pieces.secondValue == -9) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Rock.lastPosition[0].x = lastPosX;
                        Rock.lastPosition[0].y = lastPosY;
                    } else {
                        lastPosX = Rock.lastPosition[0].x;
                        lastPosY = Rock.lastPosition[0].y;
                        Rock.lastPosition[0].x = 100;
                        Rock.lastPosition[0].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.rock[0].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.rock[0].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=5;
                }
            } else if (Pieces.secondValue == -16) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Rock.lastPosition[1].x = lastPosX;
                        Rock.lastPosition[1].y = lastPosY;
                    } else {
                        lastPosX = Rock.lastPosition[1].x;
                        lastPosY = Rock.lastPosition[1].y;
                        Rock.lastPosition[1].x = 100;
                        Rock.lastPosition[1].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.rock[1].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.rock[1].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=5;
                }
            } else if (Rock.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == -41 - i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Rock.lastPosition[12 + i].x = lastPosX;
                                Rock.lastPosition[12 + i].y = lastPosY;
                            } else {
                                lastPosX = Rock.lastPosition[12 + i].x;
                                lastPosY = Rock.lastPosition[12 + i].y;
                                Rock.lastPosition[12 + i].x = 100;
                                Rock.lastPosition[12 + i].y = 100;
                            }
                        } else {
                            if (black_cnt < 7) {
                                Game.rock[12+i].setPosition(210, 30 + ((black_cnt++) * 72));
                            } else {
                                Game.rock[12+i].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                            }
                            Game.W_scoreCounter +=5;
                        }
                    }
                }
            }
        }
        //White Rock
        else if (Pieces.secondValue == 9 || Pieces.secondValue == 16 || (Pieces.secondValue > 40 && Pieces.secondValue < 49)) {
            if (Pieces.secondValue == 9) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Rock.lastPosition[2].x = lastPosX;
                        Rock.lastPosition[2].y = lastPosY;
                    } else {
                        lastPosX = Rock.lastPosition[2].x;
                        lastPosY = Rock.lastPosition[2].y;
                        Rock.lastPosition[2].x = 100;
                        Rock.lastPosition[2].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.rock[2].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.rock[2].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=5;
                }
            } else if (Pieces.secondValue == 16) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Rock.lastPosition[3].x = lastPosX;
                        Rock.lastPosition[3].y = lastPosY;
                    } else {
                        lastPosX = Rock.lastPosition[3].x;
                        lastPosY = Rock.lastPosition[3].y;
                        Rock.lastPosition[3].x = 100;
                        Rock.lastPosition[3].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.rock[3].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.rock[3].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=5;
                }
            } else if (Rock.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == 41 + i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Rock.lastPosition[4 + i].x = lastPosX;
                                Rock.lastPosition[4 + i].y = lastPosY;
                            } else {
                                lastPosX = Rock.lastPosition[4 + i].x;
                                lastPosY = Rock.lastPosition[4 + i].y;
                                Rock.lastPosition[4 + i].x = 100;
                                Rock.lastPosition[4 + i].y = 100;
                            }
                        } else {
                            if (white_cnt < 7) {
                                Game.rock[4 + i].setPosition(1067, 30 + ((white_cnt++) * 72));
                            } else {
                                Game.rock[4 + i].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                            }
                            Game.B_scoreCounter +=5;
                        }
                    }
                }
            }
        }


        //Black Knight
        else if (Pieces.secondValue == -10 || Pieces.secondValue == -15 || (Pieces.secondValue < -24 && Pieces.secondValue > -33)) {
            if (Pieces.secondValue == -10) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Knight.lastPosition[0].x = lastPosX;
                        Knight.lastPosition[0].y = lastPosY;
                    } else {
                        lastPosX = Knight.lastPosition[0].x;
                        lastPosY = Knight.lastPosition[0].y;
                        Knight.lastPosition[0].x = 100;
                        Knight.lastPosition[0].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.knight[0].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.knight[0].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=3;
                }
            } else if (Pieces.secondValue == -15) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Knight.lastPosition[1].x = lastPosX;
                        Knight.lastPosition[1].y = lastPosY;
                    } else {
                        lastPosX = Knight.lastPosition[1].x;
                        lastPosY = Knight.lastPosition[1].y;
                        Knight.lastPosition[1].x = 100;
                        Knight.lastPosition[1].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.knight[1].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.knight[1].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=3;
                }
            } else if (Knight.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == -25 - i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Knight.lastPosition[12 + i].x = lastPosX;
                                Knight.lastPosition[12 + i].y = lastPosY;
                            } else {
                                lastPosX = Knight.lastPosition[12 + i].x;
                                lastPosY = Knight.lastPosition[12 + i].y;
                                Knight.lastPosition[12 + i].x = 100;
                                Knight.lastPosition[12 + i].y = 100;
                            }
                        } else {
                            if (black_cnt < 7) {
                                Game.knight[12+i].setPosition(210, 30 + ((black_cnt++) * 72));
                            } else {
                                Game.knight[12+i].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                            }
                            Game.W_scoreCounter +=3;
                        }

                    }
                }
            }
        }
        //White Knight
        else if (Pieces.secondValue == 10 || Pieces.secondValue == 15 || (Pieces.secondValue > 24 && Pieces.secondValue < 33)) {
            if (Pieces.secondValue == 10) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Knight.lastPosition[2].x = lastPosX;
                        Knight.lastPosition[2].y = lastPosY;
                    } else {
                        lastPosX = Knight.lastPosition[2].x;
                        lastPosY = Knight.lastPosition[2].y;
                        Knight.lastPosition[2].x = 100;
                        Knight.lastPosition[2].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.knight[2].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.knight[2].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=3;
                }
            } else if (Pieces.secondValue == 15) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    //2nd time
                    if (Pieces.changeLastPos) {
                        Knight.lastPosition[3].x = lastPosX;
                        Knight.lastPosition[3].y = lastPosY;
                    } else {//1st time
                        lastPosX = Knight.lastPosition[3].x;
                        lastPosY = Knight.lastPosition[3].y;
                        Knight.lastPosition[3].x = 100;
                        Knight.lastPosition[3].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.knight[3].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.knight[3].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=3;
                }
            } else if (Knight.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == 25 + i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Knight.lastPosition[4 + i].x = lastPosX;
                                Knight.lastPosition[4 + i].y = lastPosY;
                            } else {
                                lastPosX = Knight.lastPosition[4 + i].x;
                                lastPosY = Knight.lastPosition[4 + i].y;
                                Knight.lastPosition[4 + i].x = 100;
                                Knight.lastPosition[4 + i].y = 100;
                            }
                        } else {
                            if (white_cnt < 7) {
                                Game.knight[4 + i].setPosition(1067, 30 + ((white_cnt++) * 72));
                            } else {
                                Game.knight[4 + i].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                            }
                            Game.B_scoreCounter +=3;
                        }
                    }
                }
            }
        }

        //Black Bishop
        else if (Pieces.secondValue == -11 || Pieces.secondValue == -14 || (Pieces.secondValue < -16 && Pieces.secondValue > -25)) {
            if (Pieces.secondValue == -11) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Bishop.lastPosition[0].x = lastPosX;
                        Bishop.lastPosition[0].y = lastPosY;
                    } else {
                        lastPosX = Bishop.lastPosition[0].x;
                        lastPosY = Bishop.lastPosition[0].y;
                        Bishop.lastPosition[0].x = 100;
                        Bishop.lastPosition[0].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.bishop[0].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.bishop[0].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=2;
                }
            } else if (Pieces.secondValue == -14) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Bishop.lastPosition[1].x = lastPosX;
                        Bishop.lastPosition[1].y = lastPosY;
                    } else {
                        lastPosX = Bishop.lastPosition[1].x;
                        lastPosY = Bishop.lastPosition[1].y;
                        Bishop.lastPosition[1].x = 100;
                        Bishop.lastPosition[1].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.bishop[1].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.bishop[1].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=2;
                }
            }
            // extra black bishop from promotion
            else if (Bishop.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == -17 - i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Bishop.lastPosition[12 + i].x = lastPosX;
                                Bishop.lastPosition[12 + i].y = lastPosY;
                            } else {
                                lastPosX = Bishop.lastPosition[12 + i].x;
                                lastPosY = Bishop.lastPosition[12 + i].y;
                                Bishop.lastPosition[12 + i].x = 100;
                                Bishop.lastPosition[12 + i].y = 100;
                            }
                        } else {
                            if (black_cnt < 7) {
                                Game.bishop[12+i].setPosition(210, 30 + ((black_cnt++) * 72));
                            } else {
                                Game.bishop[12+i].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                            }
                            Game.W_scoreCounter +=2;
                        }
                    }
                }
            }
        }
        //White Bishop
        else if (Pieces.secondValue == 11 || Pieces.secondValue == 14 || (Pieces.secondValue > 16 && Pieces.secondValue < 25)) {
            if (Pieces.secondValue == 11) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Bishop.lastPosition[2].x = lastPosX;
                        Bishop.lastPosition[2].y = lastPosY;
                    } else {
                        lastPosX = Bishop.lastPosition[2].x;
                        lastPosY = Bishop.lastPosition[2].y;
                        Bishop.lastPosition[2].x = 100;
                        Bishop.lastPosition[2].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.bishop[2].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.bishop[2].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=2;
                }
            } else if (Pieces.secondValue == 14) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Bishop.lastPosition[3].x = lastPosX;
                        Bishop.lastPosition[3].y = lastPosY;
                    } else {
                        lastPosX = Bishop.lastPosition[3].x;
                        lastPosY = Bishop.lastPosition[3].y;
                        Bishop.lastPosition[3].x = 100;
                        Bishop.lastPosition[3].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.bishop[3].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.bishop[3].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=2;
                }
            }
            // extra white bishop from promotion
            else if (Bishop.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == 17 + i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Bishop.lastPosition[4 + i].x = lastPosX;
                                Bishop.lastPosition[4 + i].y = lastPosY;
                            } else {
                                lastPosX = Bishop.lastPosition[4 + i].x;
                                lastPosY = Bishop.lastPosition[4 + i].y;
                                Bishop.lastPosition[4 + i].x = 100;
                                Bishop.lastPosition[4 + i].y = 100;
                            }
                        } else {
                            if (white_cnt < 7) {
                                Game.bishop[4 + i].setPosition(1067, 30 + ((white_cnt++) * 72));
                            } else {
                                Game.bishop[4 + i].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                            }
                            Game.B_scoreCounter +=2;
                        }
                    }
                }
            }
        }

        //Black Queen
        else if (Pieces.secondValue == -12 || (Pieces.secondValue <= -33 && Pieces.secondValue >= -40)) {
            if (Pieces.secondValue == -12) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Queen.lastPosition[0].x = lastPosX;
                        Queen.lastPosition[0].y = lastPosY;
                    } else {
                        lastPosX = Queen.lastPosition[0].x;
                        lastPosY = Queen.lastPosition[0].y;
                        Queen.lastPosition[0].x = 100;
                        Queen.lastPosition[0].y = 100;
                    }
                } else {
                    if (black_cnt < 7) {
                        Game.queen[0].setPosition(210, 30 + ((black_cnt++) * 72));
                    } else {
                        Game.queen[0].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                    }
                    Game.W_scoreCounter +=7;
                }
            }// extra black queen from promotion
            else if (Queen.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == -33 - i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Queen.lastPosition[10 + i].x = lastPosX;
                                Queen.lastPosition[10 + i].y = lastPosY;
                            } else {
                                lastPosX = Queen.lastPosition[10 + i].x;
                                lastPosY = Queen.lastPosition[10 + i].y;
                                Queen.lastPosition[10 + i].x = 100;
                                Queen.lastPosition[10 + i].y = 100;
                            }
                        } else {
                            if (black_cnt < 7) {
                                Game.queen[10+i].setPosition(210, 30 + ((black_cnt++) * 72));
                            } else {
                                Game.queen[10+i].setPosition(110, 30 + ((black_cnt++ - 7) * 72));
                            }
                            Game.W_scoreCounter +=7;
                        }
                    }
                }
            }
        }
        //White Queen
        else if (Pieces.secondValue == 12 || (Pieces.secondValue >= 33 && Pieces.secondValue <= 40)) {
            if (Pieces.secondValue == 12) {
                if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                    if (Pieces.changeLastPos) {
                        Queen.lastPosition[1].x = lastPosX;
                        Queen.lastPosition[1].y = lastPosY;
                    } else {
                        lastPosX = Queen.lastPosition[1].x;
                        lastPosY = Queen.lastPosition[1].y;
                        Queen.lastPosition[1].x = 100;
                        Queen.lastPosition[1].y = 100;
                    }
                } else {
                    if (white_cnt < 7) {
                        Game.queen[1].setPosition(1067, 30 + ((white_cnt++) * 72));
                    } else {
                        Game.queen[1].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                    }
                    Game.B_scoreCounter +=7;
                }
            }// extra white queen from promotion
            else if (Queen.isPromoted) {
                for (int i = 0; i < 8; i++) {
                    if (Pieces.secondValue == 33 + i) {
                        if ((Computer.moving && !Pieces.isMoved )||(!Computer.moving )&&( !Pieces.isMoved || Game.p1.x == 20)) {
                            if (Pieces.changeLastPos) {
                                Queen.lastPosition[2 + i].x = lastPosX;
                                Queen.lastPosition[2 + i].y = lastPosY;
                            } else {
                                lastPosX = Queen.lastPosition[2 + i].x;
                                lastPosY = Queen.lastPosition[2 + i].y;
                                Queen.lastPosition[2 + i].x = 100;
                                Queen.lastPosition[2 + i].y = 100;
                            }
                        } else {
                            if (white_cnt < 7) {
                                Game.queen[2 + i].setPosition(1067, 30 + ((white_cnt++) * 72));
                            } else {
                                Game.queen[2 + i].setPosition(1165, 30 + ((white_cnt++ - 7) * 72));
                            }
                            Game.B_scoreCounter +=7;
                        }
                    }
                }
            }
        }
        if (Pieces.changeLastPos) {
            lastPosX = 0;
            lastPosY = 0;
            Pieces.changeLastPos = false;
        }
    }

}