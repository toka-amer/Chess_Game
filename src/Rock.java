import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class Rock extends Pieces {
    //!!!????
    board Board = new board();

    static Point[] lastPosition = {new Point(0, 0), new Point(0, 7), new Point(7, 0), new Point(7, 7), new Point(8, 8), new Point(8, 8)
            , new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8)
    };
    static int promotion_counter_W = 0;
    static int promotion_counter_B = 0;

    public Rock(int type, int x, int y) {
        if (type == 9 || type == 16 || (type > 40 && type < 49)) {
            this.Color = "\\Pieces\\W_rock.png";
        } else if (type == -9 || type == -16 || (type < -40 && type > -49)) {
            this.Color = "\\Pieces\\B_rock.png";
        }
        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 72, 72);


    }

    public static void Validation(int p1X, int p1Y, int type) {

        counter = 0;
        Initializing();

        // Valid Places
        // Left
        for (int i = 0; i < 14; i++) {
            if (p1Y - i - 1 > -1) {
                //Black
                if (type == -9 || type == -16 || (type < -40 && type > -49)) {
                    if (board.piece[p1X][p1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                    } else if (board.piece[p1X][p1Y - i - 1] > 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 9 || type == 16 || (type > 40 && type < 49)) {


                        if (board.piece[p1X][p1Y - i - 1] == 0) {
                            ValidPlacesX[counter] = p1X;
                            ValidPlacesY[counter] = p1Y - i - 1;
                            counter++;
                        } else if (board.piece[p1X][p1Y - i - 1] < 0) {
                            ValidPlacesX[counter] = p1X;
                            ValidPlacesY[counter] = p1Y - i - 1;
                            counter++;
                            break;
                        } else {
                            break;
                        }
                }
            }
        }

        // Right
        for (int i = 0; i < 14; i++) {
            if (p1Y + i + 1 < 8) {
                //Black
                if (type == -9 || type == -16 || (type < -40 && type > -49)) {
                    if (board.piece[p1X][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X][p1Y + i + 1] > 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 9 || type == 16 || (type > 40 && type < 49)) {
                    if (board.piece[p1X][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X][p1Y + i + 1] < 0) {
                        ValidPlacesX[counter] = p1X;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        // Bottom
        for (int i = 0; i < 14; i++) {
            if (p1X + i + 1 < 8) {
                //Black
                if (type == -9 || type == -16 || (type < -40 && type > -49)) {
                    if (board.piece[p1X + i + 1][p1Y] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y] > 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 9 || type == 16 || (type > 40 && type < 49)) {
                    if (board.piece[p1X + i + 1][p1Y] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y] < 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        // Top
        for (int i = 0; i < 14; i++) {
            if (p1X - i - 1 > -1) {
                //Black
                if (type == -9 || type == -16 || (type < -40 && type > -49)) {
                    if (board.piece[p1X - i - 1][p1Y] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y] > 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 9 || type == 16 || (type > 40 && type < 49)) {
                    if (board.piece[p1X - i - 1][p1Y] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y] < 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // Check Point 2
    public static boolean Move(int p1X, int p1Y, int p2X, int p2Y) {
        if ((blackKingCounter == 1 || whiteKingCounter == 1) && (right_B_Rock == 0 || left_B_Rock == 0 || right_W_Rock == 0 || left_W_Rock == 0)) {
            Game.p2.x = p2Y;
            Game.p2.y = p2X;
        }
        isMoved = false;
        for (int i = 0; i < 14; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {

                IsCheck(p1X, p1Y, p2X, p2Y);
                if (isMoved) {
                    //Motion
                    if ((Selection.computer_play&&Computer.moving) || (Selection.computer_play&&ProtectKing.moving)) {
                        Point p=new Point(100,100);
                        if(Computer.moving) {
                            p = new Point(Computer.moveY, Computer.moveX);
                        }
                        else if(ProtectKing.moving)
                        {
                            p = new Point(ProtectKing.moveY, ProtectKing.moveX);

                        }
                        if (Computer.type == -9||ProtectKing.type==-9) {
                            Game.rock[0].setPosition(p);
                            lastPosition[0].x = Computer.moveX;
                            lastPosition[0].y = Computer.moveY;
                        } else if (Computer.type == -16||ProtectKing.type==-16) {
                            Game.rock[1].setPosition(p);
                            lastPosition[1].x = Computer.moveX;
                            lastPosition[1].y = Computer.moveY;
                        }
                    }

                    //black
                    if (!Selection.computer_play && board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -9) {
                        Game.rock[0].setPosition(Game.p2);
                        left_B_Rock++;
                        lastPosition[0].x = p2X;
                        lastPosition[0].y = p2Y;
                    } else if (!Selection.computer_play && board.piece[p2X][p2Y] == -16) {
                        Game.rock[1].setPosition(Game.p2);
                        right_B_Rock++;
                        lastPosition[1].x = p2X;
                        lastPosition[1].y = p2Y;
                    }
                    // white
                    else if (!ProtectKing.moving&&!Computer.moving&& board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 9) {
                        Game.rock[2].setPosition(Game.p2);
                        left_W_Rock++;
                        lastPosition[2].x = p2X;
                        lastPosition[2].y = p2Y;
                    } else if (!ProtectKing.moving&&!Computer.moving&& board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 16) {
                        Game.rock[3].setPosition(Game.p2);
                        right_W_Rock++;
                        lastPosition[3].x = p2X;
                        lastPosition[3].y = p2Y;
                    }
                    // moves extra rock from promotion
                    else if (isPromoted) {
                        for (int j = 0; j < 8; j++) {
                            if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 41 + j) {
                                Game.rock[4 + j].setPosition(Game.p2);
                                lastPosition[4 + j].x = p2X;
                                lastPosition[4 + j].y = p2Y;
                                break;
                            } else if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -41 - j) {
                                Game.rock[12 + j].setPosition(Game.p2);
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