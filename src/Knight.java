import javax.swing.*;
import java.awt.*;

public class Knight extends Pieces {

    static Point[] lastPosition = {
            new Point(0, 1), new Point(0, 6), new Point(7, 1), new Point(7, 6),
            new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8),
            new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8),
            new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8),
            new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8)
    };
    static int promotion_counter_W = 0;
    static int promotion_counter_B = 0;

    public Knight(int type, int x, int y) {
        if (type == 10 || type == 15 || (type > 24 && type < 33) ) {
            this.Color = "\\Pieces\\W_horse.png";
        } else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
            this.Color = "\\Pieces\\B_horse.png";
        }

        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 63, 63);

    }

    public static void Validation(int p1X, int p1Y, int type) {
        counter = 0;
        Initializing();

        //Valid Places

        // (x+=2) OR (x-=2) && (y+=1) OR (y-=1)
        //1st Possible Place
        if ((p1X + 2 < 8) && (p1Y + 1 < 8)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X + 2][p1Y + 1] < 1) {
                    ValidPlacesX[counter] = p1X + 2;
                    ValidPlacesY[counter] = p1Y + 1;
                    counter++;
                }
            }
            //Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X + 2][p1Y + 1] > -1) {
                    ValidPlacesX[counter] = p1X + 2;
                    ValidPlacesY[counter] = p1Y + 1;
                    counter++;
                }
            }
        }

        //2nd Possible Place
        if ((p1X + 2 < 8) && (p1Y - 1 > -1)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X + 2][p1Y - 1] < 1) {
                    ValidPlacesX[counter] = p1X + 2;
                    ValidPlacesY[counter] = p1Y - 1;
                    counter++;
                }
            }
            //Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X + 2][p1Y - 1] > -1) {
                    ValidPlacesX[counter] = p1X + 2;
                    ValidPlacesY[counter] = p1Y - 1;
                    counter++;
                }
            }
        }

        //3rd Possible Place
        if ((p1X - 2 > -1) && (p1Y + 1 < 8)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X - 2][p1Y + 1] < 1) {
                    ValidPlacesX[counter] = p1X - 2;
                    ValidPlacesY[counter] = p1Y + 1;
                    counter++;
                }
            }
            //Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X - 2][p1Y + 1] > -1) {
                    ValidPlacesX[counter] = p1X - 2;
                    ValidPlacesY[counter] = p1Y + 1;
                    counter++;
                }
            }
        }

        //4th possible Place
        if ((p1X - 2 > -1) && (p1Y - 1 > -1)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X - 2][p1Y - 1] < 1) {
                    ValidPlacesX[counter] = p1X - 2;
                    ValidPlacesY[counter] = p1Y - 1;
                    counter++;
                }
            }
            //Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X - 2][p1Y - 1] > -1) {
                    ValidPlacesX[counter] = p1X - 2;
                    ValidPlacesY[counter] = p1Y - 1;
                    counter++;
                }
            }
        }

        /* (y+=2) OR (y-=2) && (x+=1) OR (x-=1) */
        //5th Possible Place
        if ((p1Y + 2 < 8) && (p1X + 1 < 8)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X + 1][p1Y + 2] < 1) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
            }//Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X + 1][p1Y + 2] > -1) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
            }
        }

        //6th Possible Place
        if ((p1Y + 2 < 8) && (p1X - 1 > -1)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X - 1][p1Y + 2] < 1) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
            }//Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X - 1][p1Y + 2] > -1) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y + 2;
                    counter++;
                }
            }
        }

        //7th Possible Place
        if ((p1Y - 2 > -1) && (p1X + 1 < 8)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X + 1][p1Y - 2] < 1) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y - 2;
                    counter++;
                }
            }//Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X + 1][p1Y - 2] > -1) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y - 2;
                    counter++;
                }
            }
        }

        //8th Possible Place
        if ((p1Y - 2 > -1) && (p1X - 1 > -1)) {
            //White
            if (type == 10 || type == 15 || (type > 24 && type < 33)) {
                if (board.piece[p1X - 1][p1Y - 2] < 1) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y - 2;
                    counter++;
                }
            }//Black
            else if (type == -10 || type == -15 || (type < -24 && type > -33)) {
                if (board.piece[p1X - 1][p1Y - 2] > -1) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y - 2;

                    counter++;
                }
            }
        }
    }

    //Check Point 2
    public static boolean Move(int p1X, int p1Y, int p2X, int p2Y) {
        isMoved = false;
        for (int i = 0; i < 8; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {
                IsCheck(p1X, p1Y, p2X, p2Y);
                if (isMoved) {
                    //Motion
                    if(Selection.computer_play)
                    {
                        Point p ;
                        if(Computer.moving) {
                            p = new Point(Computer.moveY, Computer.moveX);
                            if (Computer.type == -10) {
                                Game.knight[0].setPosition(p);
                                lastPosition[0].x = Computer.moveX;
                                lastPosition[0].y = Computer.moveY;
                            } else if (Computer.type == -15) {
                                Game.knight[1].setPosition(p);
                                lastPosition[1].x = Computer.moveX;
                                lastPosition[1].y = Computer.moveY;
                            }
                        }
                        else if(ProtectKing.moving)
                        {
                            p = new Point(ProtectKing.moveY, ProtectKing.moveX);
                            if (ProtectKing.type==-10) {
                                Game.knight[0].setPosition(p);
                                lastPosition[0].x = ProtectKing.moveX;
                                lastPosition[0].y = ProtectKing.moveY;
                            } else if (ProtectKing.type==-15) {
                                Game.knight[1].setPosition(p);
                                lastPosition[1].x = ProtectKing.moveX;
                                lastPosition[1].y = ProtectKing.moveY;
                            }
                        }
                    }

                    //Black Knight
                     if (!Selection.computer_play&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -10) {
                         Game.knight[0].setPosition(Game.p2);
                        lastPosition[0].x = p2X;
                        lastPosition[0].y = p2Y;
                    } else if (!Selection.computer_play&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -15) {
                         Game.knight[1].setPosition(Game.p2);
                        lastPosition[1].x = p2X;
                        lastPosition[1].y = p2Y;
                    }
                    //White Knight
                    else if (!ProtectKing.moving&&!Computer.moving&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 10) {
                         Game.knight[2].setPosition(Game.p2);
                        lastPosition[2].x = p2X;
                        lastPosition[2].y = p2Y;
                    } else if (!ProtectKing.moving&&!Computer.moving&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 15) {
                         Game.knight[3].setPosition(Game.p2);
                        lastPosition[3].x = p2X;
                        lastPosition[3].y = p2Y;
                    }
                    // moves extra knight from promotion
                    else if (isPromoted) {
                        for (int j = 0; j < 8; j++) {
                            if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 25 + j) {
                                Game.knight[4 + j].setPosition(Game.p2);
                                lastPosition[4 + j].x = p2X;
                                lastPosition[4 + j].y = p2Y;
                                break;
                            } else if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -25 - j) {
                                Game.knight[12 + j].setPosition(Game.p2);
                                lastPosition[12 + j].x = p2X;
                                lastPosition[12 + j].y = p2Y;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return isMoved;
    }
}