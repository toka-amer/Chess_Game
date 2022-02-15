import javax.swing.*;
import java.awt.*;

public class Queen extends Pieces {

    static Point[] lastPosition = {
            new Point(0, 3), new Point(7, 3), new Point(8, 8), new Point(8, 8)
            , new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8)
            , new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8), new Point(8, 8)
            , new Point(8, 8), new Point(8, 8), new Point(8,8), new Point(8,8)
    };

    static int promotion_counter_W = 0;
    static int promotion_counter_B = 0;

    public Queen(int type, int x, int y) {
        if (type == 12 || (type > 32 && type < 41)) {
            this.Color = "\\Pieces\\W_queen.png";
        } else if (type == -12 || (type < -32 && type > -41)) {
            this.Color = "\\Pieces\\B_queen.png";
        }
        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 72, 72);
    }

    public static void Validation(int p1X, int p1Y, int type) {
        counter = 0;
        Initializing();

        // Left
        for (int i = 0; i < 8; i++) {
            if (p1Y - i - 1 > -1) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
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
                else if (type == 12 || (type > 32 && type < 41)) {
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
        //Top Left
        for (int i = 0; i < 8; i++) {
            if (p1Y - i - 1 > -1 && p1X - i - 1 > -1) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
                    if (board.piece[p1X - i - 1][p1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y - i - 1] > 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 12 || (type > 32 && type < 41)) {
                    if (board.piece[p1X - i - 1][p1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y - i - 1] < 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
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
            if (p1Y - i - 1 > -1 && p1X + i + 1 < 8) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
                    if (board.piece[p1X + i + 1][p1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y - i - 1] > 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 12 || (type > 32 && type < 41)) {
                    if (board.piece[p1X + i + 1][p1Y - i - 1] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y - i - 1;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y - i - 1] < 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
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
        for (int i = 0; i < 8; i++) {
            if (p1Y + i + 1 < 8) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
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
                else if (type == 12 || (type > 32 && type < 41)) {
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

        //Top
        for (int i = 0; i < 8; i++) {
            if (p1X - i - 1 > -1) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
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
                else if (type == 12 || (type > 32 && type < 41)) {
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

        //Top Right
        for (int i = 0; i < 8; i++) {
            if (p1X - i - 1 > -1 && p1Y + i + 1 < 8) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
                    if (board.piece[p1X - i - 1][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y + i + 1] > 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 12 || (type > 32 && type < 41)) {
                    if (board.piece[p1X][p1Y] > 0){
                    if (board.piece[p1X - i - 1][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X - i - 1][p1Y + i + 1] < 0) {
                        ValidPlacesX[counter] = p1X - i - 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                }
            }
        }

        //bottom
        for (int i = 0; i < 8; i++) {
            if (p1X + i + 1 < 8) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
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
                else if (type == 12 || (type > 32 && type < 41)) {
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

        //Bottom Right
        for (int i = 0; i < 8; i++) {
            if (p1X + i + 1 < 8 && p1Y + i + 1 < 8) {
                // black
                if (type == -12 || (type < -32 && type > -41)) {
                    if (board.piece[p1X + i + 1][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y + i + 1] > 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                        break;
                    } else {
                        break;
                    }
                }
                // white
                else if (type == 12 || (type > 32 && type < 41)) {
                    if (board.piece[p1X + i + 1][p1Y + i + 1] == 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
                        counter++;
                    } else if (board.piece[p1X + i + 1][p1Y + i + 1] < 0) {
                        ValidPlacesX[counter] = p1X + i + 1;
                        ValidPlacesY[counter] = p1Y + i + 1;
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
        isMoved = false;
        for (int i = 0; i < 27; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {
                IsCheck(p1X, p1Y, p2X, p2Y);
                if (isMoved) {
                    //Motion
                    if(Selection.computer_play)
                    {
                        Point p;
                        if(Computer.moving) {
                            p = new Point(Computer.moveY, Computer.moveX);
                            if (Computer.type == -12) {
                                Game.queen[0].setPosition(p);
                                lastPosition[0].x = Computer.moveX;
                                lastPosition[0].y = Computer.moveY;
                            }
                        }
                        else if(ProtectKing.moving)
                        {
                            p = new Point(ProtectKing.moveY, ProtectKing.moveX);
                            if (ProtectKing.type == -12) {
                                Game.queen[0].setPosition(p);
                                lastPosition[0].x = ProtectKing.moveX;
                                lastPosition[0].y = ProtectKing.moveY;
                            }
                        }
                    }
                    //Black
                    if (!Selection.computer_play&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -12) {
                        Game.queen[0].setPosition(Game.p2);
                        lastPosition[0].x = p2X;
                        lastPosition[0].y = p2Y;
                    }
                    // white
                    else if (!ProtectKing.moving&&!Computer.moving&&board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 12) {
                        Game.queen[1].setPosition(Game.p2);
                        lastPosition[1].x = p2X;
                        lastPosition[1].y = p2Y;
                    }
                    // moves extra queen from promotion
                    else if (isPromoted) {
                        for (int j = 0; j < 8; j++) {
                            if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == 33 + j) {
                                Game.queen[2 + j].setPosition(Game.p2);
                                lastPosition[2 + j].x = p2X;
                                lastPosition[2 + j].y = p2Y;
                                break;
                            } else if (board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] == -33 - j) {
                                Game.queen[10 + j].setPosition(Game.p2);
                                lastPosition[10 + j].x = p2X;
                                lastPosition[10 + j].y = p2Y;
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
