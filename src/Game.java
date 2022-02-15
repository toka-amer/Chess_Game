import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends MouseAdapter implements MouseMotionListener {
    static Computer computer = new Computer();
    static Pawn[] pawn = new Pawn[16];
    static Knight[] knight = new Knight[20];
    static Rock[] rock = new Rock[20];
    static Bishop[] bishop = new Bishop[20];
    static Queen[] queen = new Queen[18];
    static King[] king = new King[2];
    static Point W_King_Pos = new Point(7,4);
    static Point B_King_Pos = new Point(0,4);

    ValidationCircle[] validationCircles = new ValidationCircle[27];

    static boolean black;
    static boolean border_box = true;
    static boolean promotionWindow_open = false;

    static CoolDownTimer Time1,Time2;

    ImageIcon box_Border;
    JLabel box_Border_l;

    ImageIcon box_Border2;
    JLabel box_Border_l2;


    static JLabel Name1=new JLabel(),name2=new JLabel();
    Font font= new Font("Algerian",Font.PLAIN,62);

    int pX, pY;

    //counters of the above objects index
    int pwn_cnt = 0, knight_cnt = 0, rck_cnt = 0, bishop_cnt = 0, qn_cnt = 0, kng_cnt = 0;

    //2 points of 2 clicks
    static Point p1 = new Point(20,20);
    static Point p2 = new Point(20,20);

    static Point p3 = new Point(6000,6000);

    static boolean is_point = true, white_player = true,pause=false ;
    Music move=new Music();
    static int W_scoreCounter=0,B_scoreCounter=0,point2X,point2Y;

    //constructor
    public Game() {
        //Draw the pieces
        if(Settings.themecount==1) {
            Loop.Menu.setContentPane(new JLabel(new ImageIcon(Loop.img1)));
        }
        else if(Settings.themecount==2) {
            Loop.Menu.setContentPane(new JLabel(new ImageIcon(Loop.img2)));
        }
        else if(Settings.themecount==3) {
            Loop.Menu.setContentPane(new JLabel(new ImageIcon(Loop.img3)));
        }

        for (int i = 0; i < 8; i++) {
            for (int g = 0; g < 8; g++) {
                //Pawn
                if (board.piece[i][g] == 1 || board.piece[i][g] == -1 || board.piece[i][g] == -2|| board.piece[i][g] == -3|| board.piece[i][g] == -4
                        || board.piece[i][g] == -5|| board.piece[i][g] == -6|| board.piece[i][g] == -7|| board.piece[i][g] == -8|| board.piece[i][g] == 2||
                        board.piece[i][g] == 3 || board.piece[i][g] == 4 || board.piece[i][g] == 5|| board.piece[i][g] == 6|| board.piece[i][g] == 7
                        || board.piece[i][g] == 8) {
                    pawn[pwn_cnt] = new Pawn(board.piece[i][g], g, i);
                    Loop.Menu.add(pawn[pwn_cnt++].label);
                }

                //Rock
                else if (board.piece[i][g] == 9 || board.piece[i][g] == -9 || board.piece[i][g] == 16 || board.piece[i][g] == -16) {
                    rock[rck_cnt] = new Rock(board.piece[i][g], g, i);
                    Loop.Menu.add(rock[rck_cnt++].label);
                }

                //Knight
                else if (board.piece[i][g] == 10 || board.piece[i][g] == 15 || board.piece[i][g] == -15 || board.piece[i][g] == -10) {
                    knight[knight_cnt] = new Knight(board.piece[i][g], g, i);
                    Loop.Menu.add(knight[knight_cnt++].label);
                }
                //bishop
                else if (board.piece[i][g] == 11 || board.piece[i][g] == -11 || board.piece[i][g] == 14 || board.piece[i][g] == -14) {
                    bishop[bishop_cnt] = new Bishop(board.piece[i][g], g, i);
                    Loop.Menu.add(bishop[bishop_cnt++].label);
                }

                //Queen
                else if (board.piece[i][g] == 12 || board.piece[i][g] == -12) {
                    queen[qn_cnt] = new Queen(board.piece[i][g], g, i);
                    Loop.Menu.add(queen[qn_cnt++].label);
                }

                //King
                else if (board.piece[i][g] == 13 || board.piece[i][g] == -13) {
                    king[kng_cnt] = new King(board.piece[i][g], g, i);
                    Loop.Menu.add(king[kng_cnt++].label);
                }
            }
        }
        Time1=new CoolDownTimer(new Point(1062,615));
        Time2=new CoolDownTimer(new Point(113,615));
        if (Settings.count==1){
            Time1.counterLabel.setText("10:00");
            Loop.Menu.add(Time1.counterLabel);
            Time1.minute=10;
            Time1.second=0;
            Time2.counterLabel.setText("10:00");
            Loop.Menu.add(Time2.counterLabel);
            Time2.minute=10;
            Time2.second=0;
        }
        else if (Settings.count==2){
            Time1.counterLabel.setText("15:00");
            Loop.Menu.add(Time1.counterLabel);
            Time1.minute=15;
            Time1.second=0;
            Time2.counterLabel.setText("15:00");
            Loop.Menu.add(Time2.counterLabel);
            Time2.minute=15;
            Time2.second=0;
        }else if (Settings.count==3){
            Time1.counterLabel.setText("20:00");
            Loop.Menu.add(Time1.counterLabel);
            Time1.minute=20;
            Time1.second=0;
            Time2.counterLabel.setText("20:00");
            Loop.Menu.add(Time2.counterLabel);
            Time2.minute=20;
            Time2.second=0;
        }
        Loop.Menu.add(Time1.counterLabel);

        Loop.Menu.add(Time2.counterLabel);

        Time2.timer.stop();

        Name1.setForeground(Color.white);
        name2.setForeground(Color.white);
        Name1.setBounds(730,720,500,65);
        name2.setBounds(84,720,500,65);
        Name1.setHorizontalAlignment(JLabel.LEFT);
        name2.setHorizontalAlignment(JLabel.RIGHT);
        Name1.setFont(font);
        name2.setFont(font);
        Loop.Menu.add(Name1); Loop.Menu.add(name2);

        //deeply.setSize(1289, 758);

        Loop.Menu.addMouseListener(this);
        Loop.Menu.addMouseMotionListener(this);

        box_Border=new ImageIcon(getClass().getResource("\\Pieces\\Untitled-1.png"));
        box_Border_l=new JLabel(box_Border);

        box_Border2=new ImageIcon(getClass().getResource("\\Pieces\\Untitled-1 - Copy.png"));
        box_Border_l2=new JLabel(box_Border2);

    }
    public void mousePressed (MouseEvent e ) {

        p3.x = e.getX() - 353;
        p3.y = e.getY();

        //First Click
        if (is_point && p2.x == 20) {
            p1.x = (e.getX() - 383 - 9) / 72;
            p1.y = (e.getY() - 71 - 38) / 72;

            if (p1.x > -1 && p1.x < 8 && p1.y > -1 && p1.y < 8) {
                box_Border_l2.setVisible(board.piece[p1.y][p1.x] != 0);
                Loop.Menu.add(box_Border_l2);
                box_Border_l2.setBounds(board.Draw[p1.x][p1.y].x, board.Draw[p1.x][p1.y].y, 74, 74);
                is_point = false;
                System.out.println("P1");
                //click on empty box
                if (board.piece[(int) p1.getY()][(int) p1.getX()] == 0) {
                    Reset();
                }
            }
            else {
                Reset();
            }
        }
        //Second Click
        else if (!is_point && p2.x == 20) {
            p2.x = (e.getX() - 383 - 9) / 72;
            p2.y = (e.getY() - 71 - 38) / 72;
            point2X=p2.x;
            point2Y=p2.y;

            box_Border_l2.setVisible(false);

            for (int i = 0; i < Pieces.counter; i++) {
                validationCircles[i].circle_l.setVisible(false);
            }

            System.out.println("P2");
            is_point = true;
        }

        //2 click on 2 pieces
        if ((p1.x != 20) && (p1.y != 20)) {
            //Moves

            //White Pieces
            if (white_player) {

                //White Knight
                if ((board.piece[(int) p1.getY()][(int) p1.getX()] == 10 || board.piece[(int) p1.getY()][(int) p1.getX()] == 15 || (board.piece[(int) p1.getY()][(int) p1.getX()] > 24 && board.piece[(int) p1.getY()][(int) p1.getX()] < 33)) && white_player) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        Knight.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        ValidCircle();
                    } else if ((p2.x != 20) && (p2.y != 20)) {
                        if (Knight.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                            Player1();
                            move.movesound();
                        } else {
                            white_player = true;
                        }
                        Reset();
                    }
                }
                //White Bishop
                else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == 11 || board.piece[(int) p1.getY()][(int) p1.getX()] == 14 || (board.piece[(int) p1.getY()][(int) p1.getX()] > 16 && board.piece[(int) p1.getY()][(int) p1.getX()] < 24)) && white_player) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        Bishop.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        ValidCircle();
                    } else if ((p2.x != 20) && (p2.y != 20)) {
                        if (Bishop.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                            Player1();
                            move.movesound();
                        } else {
                            white_player = true;
                        }
                        Reset();
                    }
                }
                //White Pawn
                else if ((board.piece[(int) p1.getY()][(int) p1.getX()] > 0 && board.piece[(int) p1.getY()][(int) p1.getX()] < 9) && white_player) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        Pawn.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        ValidCircle();
                    }
                    else if ((p2.x != 20) && (p2.y != 20)) {
                        if (Pawn.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX(), board.piece[(int) p1.getY()][(int) p1.getX()])) {
                            //pawn promotion
                            if(Promotion.PawnPromotion((int) p2.getY(), board.piece[(int) p2.getY()][(int) p2.getX()])) {
                                promotionWindow_open = true;
                                border_box = false;
                                Promotion.promotion_options.setVisible(true);
                            }
                            Player1();
                            move.movesound();

                        }
                        else {
                            white_player = true;
                        }
                        Reset();
                    }
                }
                //White Queen
                else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == 12 || (board.piece[(int) p1.getY()][(int) p1.getX()] > 32 && board.piece[(int) p1.getY()][(int) p1.getX()] < 41)) && white_player) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        Queen.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        ValidCircle();
                    } else if ((p2.x != 20) && (p2.y != 20)) {
                        if (Queen.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                            Player1();
                            move.movesound();
                        } else {
                            white_player = true;
                        }
                        Reset();
                    }
                }
                //White Rock
                else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == 9 || board.piece[(int) p1.getY()][(int) p1.getX()] == 16 || (board.piece[(int) p1.getY()][(int) p1.getX()] > 40 && board.piece[(int) p1.getY()][(int) p1.getX()] < 49)) && white_player) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        Rock.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        ValidCircle();
                    } else if ((p2.x != 20) && (p2.y != 20)) {
                        if (Rock.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                            Player1();
                            move.movesound();
                        } else white_player = true;
                        Reset();
                    }
                }
                //White King
                else if (board.piece[(int) p1.getY()][(int) p1.getX()] == 13) {
                    if ((p2.x == 20) && (p2.y == 20)) {
                        if ((King.whiteKingCounter == 0 && King.right_W_Rock == 0) || (King.whiteKingCounter == 0 && King.left_W_Rock == 0)) {
                            King.Castling((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        } else {
                            King.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                        }
                        ValidCircle();
                    } else if ((p2.x != 20) && (p2.y != 20)) {
                        if (King.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                            Player1();
                            move.movesound();
                        } else {
                            white_player = true;
                        }
                        Reset();
                    }
                } else {
                    Reset();
                }
                if(!white_player){
                    Pieces.CheckMate();
                }
            }
            if (!white_player) {
                if (Selection.computer_play) {
                    if(Check.BlackChecked())
                    {
                        ProtectKing.Protecting_Piece();
                        Player2();
                    }
                    else {
                        Computer.Valid_Piece();
                        Computer.Random();
                        Player2();
                    }

                } else if (!Selection.computer_play) {
                    //Black Pieces
                    if (p1.x != 20) {

                        //Black Knight
                        if ((board.piece[(int) p1.getY()][(int) p1.getX()] == -10 || board.piece[(int) p1.getY()][(int) p1.getX()] == -15 || (board.piece[(int) p1.getY()][(int) p1.getX()] < -24 && board.piece[(int) p1.getY()][(int) p1.getX()] > -33)) && !white_player) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                Knight.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (Knight.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                                    Player2();
                                    move.movesound();
                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        }
                        //Black Bishop
                        else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == -11 || board.piece[(int) p1.getY()][(int) p1.getX()] == -14 || (board.piece[(int) p1.getY()][(int) p1.getX()] < -16 && board.piece[(int) p1.getY()][(int) p1.getX()] > -24)) && !white_player) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                Bishop.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (Bishop.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                                    Player2();
                                    move.movesound();
                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        }
                        //Black Pawn
                        else if ((board.piece[(int) p1.getY()][(int) p1.getX()] > -9 && board.piece[(int) p1.getY()][(int) p1.getX()] < 0) && !white_player) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                Pawn.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (Pawn.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX(), board.piece[(int) p1.getY()][(int) p1.getX()])) {
                                    //pawn promotion
                                    if (Promotion.PawnPromotion((int) p2.getY(), board.piece[(int) p2.getY()][(int) p2.getX()])) {
                                        promotionWindow_open = true;
                                        border_box = false;
                                        Promotion.promotion_options.setVisible(true);
                                    }
                                    Player2();
                                    move.movesound();

                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        }
                        //Black Queen
                        else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == -12 || (board.piece[(int) p1.getY()][(int) p1.getX()] < -32 && board.piece[(int) p1.getY()][(int) p1.getX()] > -41)) && !white_player) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                Queen.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (Queen.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                                    Player2();
                                    move.movesound();
                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        }
                        //Black Rock
                        else if ((board.piece[(int) p1.getY()][(int) p1.getX()] == -9 || board.piece[(int) p1.getY()][(int) p1.getX()] == -16 || (board.piece[(int) p1.getY()][(int) p1.getX()] < -40 && board.piece[(int) p1.getY()][(int) p1.getX()] > -49)) && !white_player) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                Rock.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (Rock.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                                    Player2();
                                    move.movesound();
                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        }
                        //Black King
                        else if (board.piece[(int) p1.getY()][(int) p1.getX()] == -13) {
                            if ((p2.x == 20) && (p2.y == 20)) {
                                if ((King.blackKingCounter == 0) && (King.right_B_Rock == 0 || King.left_B_Rock == 0)) {
                                    King.Castling((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                } else {
                                    King.Validation((int) p1.getY(), (int) p1.getX(), board.piece[(int) p1.getY()][(int) p1.getX()]);
                                }
                                ValidCircle();
                            } else if ((p2.x != 20) && (p2.y != 20)) {
                                if (King.Move((int) p1.getY(), (int) p1.getX(), (int) p2.getY(), (int) p2.getX())) {
                                    Player2();
                                    move.movesound();
                                } else {
                                    white_player = false;
                                }
                                Reset();
                            }
                        } else {
                            Reset();
                        }
                    }
                }
                if(white_player){
                    Pieces.CheckMate();
                }
            }
        }

        for(int i=0;i<8;i++){
            for(int k=0;k<8;k++){
                System.out.print(board.piece[i][k]+" ");
            }
            System.out.println("\n");
        }

        //Game is Finished
        if (Time1.minute==0 && Time1.second==0){
            System.out.println("Player 1 Lost");
        }
        else if (Time2.minute==0 && Time2.second==0){
            System.out.println("Player 2 Lost");
        }
    }

    public void Player1(){
        white_player=false;
        Time1.timer.stop();
        Time2.timer.start();
    }

    public void Player2(){
        white_player=true;
        Time2.timer.stop();
        Time1.timer.start();
    }

    public void Reset(){
        if(!promotionWindow_open&&!pause) {
            p1.x = 20;
            p1.y = 20;
            p2.x = 20;
            p2.y = 20;
            is_point = true;
        }
    }

    public void mouseMoved(MouseEvent e) {
        pX =(e.getX()-383-9)/72;
        pY =(e.getY()-71-38)/72;

        if(pX<0 || pY < 0 || pX >7 || pY >7){
            pX=0;
            pY=0;
        }
        else if (border_box){
            box_Border_l.setBounds( board.Draw[pX][pY].x,board.Draw[pX][pY].y, 74,74);
            Loop.Menu.add(box_Border_l);
            e.consume();
        }
    }

    public void ValidCircle(){
        for (int i=0;i<Pieces.counter;i++){
            validationCircles[i] = new ValidationCircle();
            Loop.Menu.add(validationCircles[i].circle_l).setBounds(board.Draw[Pieces.ValidPlacesY[i]][Pieces.ValidPlacesX[i]].x,board.Draw[Pieces.ValidPlacesY[i]][Pieces.ValidPlacesX[i]].y,72,72);
        }
    }
}
