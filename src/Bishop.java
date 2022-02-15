import javax.swing.*;
import java.awt.*;

public class Bishop extends Pieces {
    static Point[] lastPosition = {new Point(0, 2), new Point(0, 5), new Point(7, 2), new Point(7, 5), new Point(8, 8), new Point(8, 8)
            , new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8)};

    static int promotion_counter_W = 0;
    static int promotion_counter_B = 0;

    public Bishop(int type, int x, int y) {
        if (type == 11 || type == 14 || (type > 16 && type < 25)) {
            this.Color = "\\Pieces\\W_Bishop.png";
        } else if (type == -11 || type == -14 || (type < -16 && type > -25)) {
            this.Color = "\\Pieces\\B_Bishop.png";
        }
        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 72, 72);
    }

    public static void Validation(int P1X, int P1Y, int type) {
        counter = 0;
        Initializing();

        //Valid Places
        //Top Left
        for (int i = 0; i < 8; i++) {
            if (P1Y - i - 1 > -1 && P1X - i - 1 > -1) {
                //Black
                if (type == -11 || type == -14 || (type < -16 && type > -25)) {
                    if (board.piece[P1X - i - 1][P1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                    } else if (board.piece[P1X - i - 1][P1Y - i - 1] > 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 11 || type == 14 || (type > 16 && type < 25)) {
                    if (board.piece[P1X - i - 1][P1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;


                    } else if (board.piece[P1X - i - 1][P1Y - i - 1] < 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
            }

        }

        // Bottom Left
        for (int i = 0; i < 8; i++) {
            if (P1Y - i - 1 > -1 && P1X + i + 1 < 8) {
                // black
                if (type == -11 || type == -14 || (type < -16 && type > -25)) {
                    if (board.piece[P1X + i + 1][P1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                    } else if (board.piece[P1X + i + 1][P1Y - i - 1] > 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 11 || type == 14 || (type > 16 && type < 25)) {
                    if (board.piece[P1X + i + 1][P1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                    } else if (board.piece[P1X + i + 1][P1Y - i - 1] < 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        //Top Right
        for (int i = 0; i < 8; i++) {
            if (P1X - i - 1 > -1 && P1Y + i + 1 < 8) {
                // black
                if (type == -11 || type == -14 || (type < -16 && type > -25)) {
                    if (board.piece[P1X - i - 1][P1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;
                    } else if (board.piece[P1X - i - 1][P1Y + i + 1] > 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;

                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 11 || type == 14 || (type > 16 && type < 25)) {
                    if (board.piece[P1X - i - 1][P1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;

                    } else if (board.piece[P1X - i - 1][P1Y + i + 1] < 0) {
                        ValidPlacesX[counter] = P1X - i - 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;

                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        //Bottom Right
        for (int i = 0; i < 8; i++) {
            if (P1X + i + 1 < 8 && P1Y + i + 1 < 8) {
                // black
                if (type == -11 || type == -14 || (type < -16 && type > -25)) {
                    if (board.piece[P1X + i + 1][P1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;
                    } else if (board.piece[P1X + i + 1][P1Y + i + 1] > 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 11 || type == 14 || (type > 16 && type < 25)) {
                    if (board.piece[P1X + i + 1][P1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;

                    } else if (board.piece[P1X + i + 1][P1Y + i + 1] < 0) {
                        ValidPlacesX[counter] = P1X + i + 1;
                        ValidPlacesY[counter] = P1Y + i + 1;
                        counter++;

                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    //Check Point 2
    public static boolean Move(int p1X, int p1Y, int p2X, int p2Y) {
        isMoved = false;
        for (int i = 0; i < 13; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {

                IsCheck(p1X, p1Y, p2X, p2Y);

                if (isMoved) {
                    //Motion
                    if(Selection.computer_play)
                    {
                        Point p;
                        if(Computer.moving)
                        {
                            p = new Point(Computer.moveY, Computer.moveX);
                            if (Computer.type == -11) {
                                Game.bishop[0].setPosition(p);
                                lastPosition[0].x = Computer.moveX;
                                lastPosition[0].y = Computer.moveY;
                            } else if (Computer.type == -14) {
                                Game.bishop[1].setPosition(p);
                                lastPosition[1].x = Computer.moveX;
                                lastPosition[1].y = Computer.moveY;
                            }
                        }
                        else if(ProtectKing.moving)
                        {
                            p = new Point(ProtectKing.moveY, ProtectKing.moveX);
                            if (ProtectKing.type==-11) {
                                Game.bishop[0].setPosition(p);
                                lastPosition[0].x = ProtectKing.moveX;
                                lastPosition[0].y = ProtectKing.moveY;
                            } else if (ProtectKing.type==-14) {
                                Game.bishop[1].setPosition(p);
                                lastPosition[1].x = ProtectKing.moveX;
                                lastPosition[1].y = ProtectKing.moveY;
                            }
                        }
                    }

                    //Black Bishop
                    if (!Selection.computer_play && board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -11) {
                        Game.bishop[0].setPosition(Game.p2);
                        lastPosition[0].x = p2X;
                        lastPosition[0].y = p2Y;
                    } else if (!Selection.computer_play && board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -14) {
                        Game.bishop[1].setPosition(Game.p2);
                        lastPosition[1].x = p2X;
                        lastPosition[1].y = p2Y;
                    }
                    //White Bishop
                    else if (!ProtectKing.moving&&!Computer.moving&& board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 11) {
                        Game.bishop[2].setPosition(Game.p2);
                        lastPosition[2].x = p2X;
                        lastPosition[2].y = p2Y;
                    } else if (!ProtectKing.moving&&!Computer.moving&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 14) {
                        Game.bishop[3].setPosition(Game.p2);
                        lastPosition[3].x = p2X;
                        lastPosition[3].y = p2Y;
                    }
                    // moves extra bishop from promotion
                    else if (isPromoted) {
                        for (int j = 0; j < 8; j++) {
                            if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 17 + j) {
                                Game.bishop[4 + j].setPosition(Game.p2);
                                lastPosition[4 + j].x = p2X;
                                lastPosition[4 + j].y = p2Y;
                                break;
                            } else if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -17 - j) {
                                Game.bishop[12 + j].setPosition(Game.p2);
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