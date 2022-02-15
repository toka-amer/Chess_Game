import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pawn extends Pieces {
    static Point[] lastPosition = {
            new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(1, 6), new Point(1, 7),
            new Point(6, 0), new Point(6, 1), new Point(6, 2), new Point(6, 3), new Point(6, 4), new Point(6, 5), new Point(6, 6), new Point(6, 7)
    };

    public Pawn(int type, int x, int y) {
        if (type == 1 || type == 2 || type == 3 || type == 4 || type == 5 || type == 6 || type == 7 || type == 8) {

            this.Color = "\\Pieces\\W_Pawn.png";
        } else if (type == -1 || type == -2 || type == -3 || type == -4 || type == -5 || type == -6 || type == -7 || type == -8) {
            this.Color = "\\Pieces\\B_Pawn.png";

        }
        image = new ImageIcon(getClass().getResource(Color));
        label = new JLabel(image);
        label.setBounds(board.Draw[x][y].x, board.Draw[x][y].y, 72, 72);
    }


    public static void Validation(int p1X, int p1Y, int type) {
        counter = 0;
        Initializing();

        // Valid Places
        // Black
        if (type < 0) {
            // One step
            if (p1X + 1 <= 7) {
                if (board.piece[p1X + 1][p1Y] == 0) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y;
                    counter++;
                }
            }
            // Two steps at the beginning
            if (p1X == 1 && board.piece[3][p1Y] == 0 && board.piece[2][p1Y] == 0) {
                ValidPlacesX[counter] = 3;
                ValidPlacesY[counter] = p1Y;
                counter++;
            }
            // Kill Down Left
            if (p1Y - 1 >= 0 && p1X + 1 <= 7) {
                if (board.piece[p1X + 1][p1Y - 1] > 0) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y - 1;
                    counter++;
                }
            }
            // Kill Down Right
            if (p1X + 1 <= 7 && p1Y + 1 <= 7) {
                if (board.piece[p1X + 1][p1Y + 1] > 0) {
                    ValidPlacesX[counter] = p1X + 1;
                    ValidPlacesY[counter] = p1Y + 1;
                    counter++;
                }
            }
        }

        // White
        else if (type > 0) {
            // One step
            if (p1X - 1 >= 0) {
                if (board.piece[p1X - 1][p1Y] == 0) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y;
                    counter++;
                }
            }
            // Two steps at the beginning
            if (p1X == 6 && board.piece[4][p1Y] == 0 && board.piece[5][p1Y] == 0) {
                ValidPlacesX[counter] = 4;
                ValidPlacesY[counter] = p1Y;
                counter++;
            }
            // Kill Up Left
            if (p1X - 1 >= 0 && p1Y - 1 >= 0) {
                if (board.piece[p1X - 1][p1Y - 1] < 0) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y - 1;

                    counter++;
                }
            }
            // Kill Up Right
            /*for (int o=0;o<8;o++){
                for (int p=0;p<8;p++){
                    System.out.print(board.piece[o][p]+" ");
                }
                System.out.println("\n");
            }*/
            if (p1X - 1 >= 0 && p1Y + 1 <= 7) {
                if (board.piece[p1X - 1][p1Y + 1] < 0) {
                    ValidPlacesX[counter] = p1X - 1;
                    ValidPlacesY[counter] = p1Y + 1;

                    counter++;
                }
                for (int o=0;o<4;o++){
                    System.out.println(ValidPlacesX[o]+" "+ValidPlacesY[o]);
                }
            }
        }
    }

    //Check Point 2
    public static boolean Move(int p1X, int p1Y, int p2X, int p2Y, int type) {
        isMoved = false;

        for (int i = 0; i < 4; i++) {
            if (p2X == ValidPlacesX[i] && p2Y == ValidPlacesY[i]) {
                IsCheck(p1X, p1Y, p2X, p2Y);
                if (isMoved) {
                    //Motion
                    // black
                    if (type < 0) {
                        if(Selection.computer_play)
                        {
                            Point p;
                            if(Computer.moving)
                            {
                                p =new Point(Computer.moveY,Computer.moveX);
                                Game.pawn[Computer.random_Pieces].setPosition(p);
                                lastPosition[Computer.random_Pieces].x =Computer.moveX;
                                lastPosition[Computer.random_Pieces].y = Computer.moveY;
                            }
                            else if(ProtectKing.moving)
                            {
                                p =new Point(ProtectKing.moveY,ProtectKing.moveX);
                                Game.pawn[(ProtectKing.type+1)/-1].setPosition(p);
                                lastPosition[(ProtectKing.type+1)/-1].x =ProtectKing.moveX;
                                lastPosition[(ProtectKing.type+1)/-1].y = ProtectKing.moveY;
                            }

                        }
                        else {
                            Game.pawn[(type * -1) - 1].setPosition(Game.p2);
                            lastPosition[(type * -1) - 1].x = p2X;
                            lastPosition[(type * -1) - 1].y = p2Y;
                        }
                    }
                    // white
                    else if (type > 0) {
                        Game.pawn[type + 7].setPosition(Game.p2);
                        lastPosition[type + 7].x = p2X;
                        lastPosition[type + 7].y = p2Y;
                    }
                    break;
                }
            }
        }
        return isMoved;
    }
}
