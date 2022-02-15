import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Promotion extends MouseAdapter implements MouseMotionListener {
    static JFrame promotion_options = new JFrame("Pawn Promotion");
    static Image promotionbackGround = Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\promotion_options.jpg");
    static Image promotionbackGround1 = Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\Promotion black.png");

    // pawn promotion
    public  static boolean PawnPromotion(int p2X, int type) {
        // white pawn
        if(type > 0 && type < 9 && p2X == 0)  {
            promotion_options.setContentPane(new JLabel(new ImageIcon(promotionbackGround)));
            Game.black = false;
            Game.pawn[type + 7].setPosition(1000,1000);
            Pawn.lastPosition[type + 7].x = 100;
            Pawn.lastPosition[type + 7].y = 100;
            return true;
        }
        // black pawn
        else if(type < 0 && type > -9 && p2X == 7) {
            promotion_options.setContentPane(new JLabel(new ImageIcon(promotionbackGround1)));
            Game.black = true;
            Game.pawn[(type * -1) - 1].setPosition(1000,1000);
            Pawn.lastPosition[(type * -1) - 1].x = 100;
            Pawn.lastPosition[(type * -1) - 1].y = 100;
            return true;
        }
        return false;
    }

    public Promotion()
    {
        promotion_options.setResizable(true);
        promotion_options.setSize(600, 148);
        promotion_options.setVisible(false);
        promotion_options.setLocation(700,510);
        promotion_options.setUndecorated(true);
        promotion_options.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        promotion_options.addMouseListener(this);

    }



    public static void PromotionToKnight(int p2X, int p2Y, int type) {
        Knight.isPromoted = true;
        // promotion white knight
        if(type > 0 && type < 9) {
            // lw fi knight fi el kills
            if(Knight.lastPosition[2].x == 100 && Knight.lastPosition[2].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 10;
                Knight.lastPosition[2].x = p2X;
                Knight.lastPosition[2].y = p2Y;
                Game.knight[2].label.setBounds(board.Draw[p2Y][p2X].x,board.Draw[p2Y][p2X].y,72,72);
                Loop.Menu.add(Game.knight[2].label);
            }
            else if (Knight.lastPosition[3].x == 100 && Knight.lastPosition[3].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 15;
                Knight.lastPosition[3].x = p2X;
                Knight.lastPosition[3].y = p2Y;
                Game.knight[3].label.setBounds(board.Draw[p2Y][p2X].x,board.Draw[p2Y][p2X].y,72,72);
                Loop.Menu.add(Game.knight[3].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 25 + Knight.promotion_counter_W;
                Game.knight[4 + Knight.promotion_counter_W] = new Knight(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Knight.lastPosition[4 + Knight.promotion_counter_W].x = p2X;
                Knight.lastPosition[4 + Knight.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.knight[4 + Knight.promotion_counter_W].label);
                Knight.promotion_counter_W++;
            }
        }
        //promotion black knight
        else if(type < 0 && type > -9) {
            // lw fi knight fi el kills
            if(Knight.lastPosition[0].x == 100 && Knight.lastPosition[0].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -10;
                Knight.lastPosition[0].x = p2X;
                Knight.lastPosition[0].y = p2Y;
                Game.knight[0].label.setBounds(board.Draw[p2Y][p2X].x,board.Draw[p2Y][p2X].y,72,72);
                Loop.Menu.add(Game.knight[0].label);
            }
            else if (Knight.lastPosition[1].x == 100 && Knight.lastPosition[1].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -15;
                Knight.lastPosition[1].x = p2X;
                Knight.lastPosition[1].y = p2Y;
                Game.knight[1].label.setBounds(board.Draw[p2Y][p2X].x,board.Draw[p2Y][p2X].y,72,72);
                Loop.Menu.add(Game.knight[1].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -25 - Knight.promotion_counter_B;
                Game.knight[12 + Knight.promotion_counter_B] = new Knight(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Knight.lastPosition[12 + Knight.promotion_counter_B].x = p2X;
                Knight.lastPosition[12 + Knight.promotion_counter_B].y = p2Y;
                Loop.Menu.add(Game.knight[12 + Knight.promotion_counter_B].label);
                Knight.promotion_counter_B++;
            }
        }
    }

    public static void PromotionToBishop(int p2X, int p2Y, int type) {
        Bishop.isPromoted = true;
        // promotion white bishop
        if (type > 0 && type < 9) {
            // lw fi bishop fi el kills
            if (Bishop.lastPosition[2].x == 100 && Bishop.lastPosition[2].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 11;
                Bishop.lastPosition[2].x = p2X;
                Bishop.lastPosition[2].y = p2Y;
                Game.bishop[2].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.bishop[2].label);
            } else if (Bishop.lastPosition[3].x == 100 && Bishop.lastPosition[3].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 14;
                Bishop.lastPosition[3].x = p2X;
                Bishop.lastPosition[3].y = p2Y;
                Game.bishop[3].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.bishop[3].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 17 + Bishop.promotion_counter_W;
                Game.bishop[4 + Bishop.promotion_counter_W] = new Bishop(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Bishop.lastPosition[4 + Bishop.promotion_counter_W].x = p2X;
                Bishop.lastPosition[4 + Bishop.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.bishop[4 + Bishop.promotion_counter_W].label);
                Bishop.promotion_counter_W++;
            }
        }
        //promotion black bishop
        else if (type < 0 && type > -9) {
            // lw fi bishop fi el kills
            if (Bishop.lastPosition[0].x == 100 && Bishop.lastPosition[0].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -11;
                Bishop.lastPosition[0].x = p2X;
                Bishop.lastPosition[0].y = p2Y;
                Game.bishop[0].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.bishop[0].label);
            } else if (Bishop.lastPosition[1].x == 100 && Bishop.lastPosition[1].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -14;
                Bishop.lastPosition[1].x = p2X;
                Bishop.lastPosition[1].y = p2Y;
                Game.bishop[1].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.bishop[1].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -17 - Bishop.promotion_counter_B;
                Game.bishop[12 + Bishop.promotion_counter_B] = new Bishop(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Bishop.lastPosition[12 + Bishop.promotion_counter_W].x = p2X;
                Bishop.lastPosition[12 + Bishop.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.bishop[12 + Bishop.promotion_counter_B].label);
                Bishop.promotion_counter_B++;
            }
        }
    }

    public static void PromotionToQueen(int p2X, int p2Y, int type) {
        Queen.isPromoted = true;
        // promotion white bishop
        if (type > 0 && type < 9) {
            // lw fi queen fi el kills
            if (Queen.lastPosition[1].x == 100 && Queen.lastPosition[1].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 12;
                Queen.lastPosition[1].x = p2X;
                Queen.lastPosition[1].y = p2Y;
                Game.queen[1].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.queen[1].label);
            } else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 33 + Queen.promotion_counter_W;
                Game.queen[2 + Queen.promotion_counter_W] = new Queen(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Queen.lastPosition[2 + Queen.promotion_counter_W].x = p2X;
                Queen.lastPosition[2 + Queen.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.queen[2 + Queen.promotion_counter_W].label);
                Queen.promotion_counter_W++;
            }
        }
        //promotion black bishop
        else if (type < 0 && type > -9) {
            // lw fi queen fi el kills
            if (Queen.lastPosition[0].x == 100 && Queen.lastPosition[0].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -12;
                Queen.lastPosition[0].x = p2X;
                Queen.lastPosition[0].y = p2Y;
                Game.queen[0].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.queen[0].label);
            } else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -33 - Queen.promotion_counter_B;
                Game.queen[10 + Queen.promotion_counter_B] = new Queen(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Queen.lastPosition[10 + Queen.promotion_counter_W].x = p2X;
                Queen.lastPosition[10 + Queen.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.queen[10 + Queen.promotion_counter_B].label);
                Queen.promotion_counter_B++;
            }
        }
    }

    public static void PromotionToRock(int p2X, int p2Y, int type) {
        Rock.isPromoted = true;
        // promotion white bishop
        if (type > 0 && type < 9) {
            // lw fi rock fi el kills
            if (Rock.lastPosition[2].x == 100 && Rock.lastPosition[2].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 9;
                Rock.lastPosition[2].x = p2X;
                Rock.lastPosition[2].y = p2Y;
                Game.rock[2].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.rock[2].label);
            } else if (Rock.lastPosition[3].x == 100 && Rock.lastPosition[3].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 16;
                Rock.lastPosition[3].x = p2X;
                Rock.lastPosition[3].y = p2Y;
                Game.rock[3].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.rock[3].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = 41 + Rock.promotion_counter_W;
                Game.rock[4 + Rock.promotion_counter_W] = new Rock(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Rock.lastPosition[4 + Rock.promotion_counter_W].x = p2X;
                Rock.lastPosition[4 + Rock.promotion_counter_W].y = p2Y;
                Loop.Menu.add(Game.rock[4 + Rock.promotion_counter_W].label);
                Rock.promotion_counter_W++;
            }
        }
        //promotion black bishop
        else if (type < 0 && type > -9) {
            // lw fi rock fi el kills
            if (Rock.lastPosition[0].x == 100 && Rock.lastPosition[0].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -9;
                Rock.lastPosition[0].x = p2X;
                Rock.lastPosition[0].y = p2Y;
                Game.rock[0].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.rock[0].label);
            } else if (Rock.lastPosition[1].x == 100 && Rock.lastPosition[1].y == 100) {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -16;
                Rock.lastPosition[1].x = p2X;
                Rock.lastPosition[1].y = p2Y;
                Game.rock[1].label.setBounds(board.Draw[p2Y][p2X].x, board.Draw[p2Y][p2X].y, 72, 72);
                Loop.Menu.add(Game.rock[1].label);
            }
            // If not
            else {
                board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()] = -41 - Rock.promotion_counter_B;
                Game.rock[12 + Rock.promotion_counter_B] = new Rock(board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()], p2Y, p2X);
                Rock.lastPosition[12 + Rock.promotion_counter_B].x = p2X;
                Rock.lastPosition[12 + Rock.promotion_counter_B].y = p2Y;
                Loop.Menu.add(Game.rock[12 + Rock.promotion_counter_B].label);
                Rock.promotion_counter_B++;
            }
        }
    }

    public void mousePressed (MouseEvent e ) {
        if(Game.promotionWindow_open && !Game.black) {
            // promotion window
            if(e.getX() > 0 && e.getX() < 150 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToQueen((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 150 && e.getX() < 300 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToKnight((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 300 && e.getX() < 450 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToBishop((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 450 && e.getX() < 600 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToRock((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
        }
        else if(Game.promotionWindow_open && Game.black) {
            // promotion window

            if(e.getX() > 0 && e.getX() < 150 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToQueen((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 150 && e.getX() < 300 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToKnight((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 300 && e.getX() < 450 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToBishop((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
            else if (e.getX() > 450 && e.getX() < 600 && e.getY() > 38 && e.getY() < 148+38) {
                promotion_options.setVisible(false);
                PromotionToRock((int) Game.p2.getY(), (int) Game.p2.getX(), board.piece[(int) Game.p2.getY()][(int) Game.p2.getX()]);
                Game.border_box = true;
                Game.promotionWindow_open = false;
            }
        }
    }

}

