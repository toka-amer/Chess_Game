import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inputs extends MouseAdapter implements MouseListener {
    Image inputsBackground =Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\Player 2.png");
    ImageIcon ready1 = new ImageIcon(getClass().getResource("Buttons/Ready.png"));
    JLabel ready1_l = new JLabel(ready1);
    ImageIcon ready2 = new ImageIcon(getClass().getResource("Buttons/Ready.png"));
    JLabel ready2_l = new JLabel(ready2);
    ImageIcon play = new ImageIcon(getClass().getResource("Settings/Button.png"));
    JLabel play_l = new JLabel(play);
    ImageIcon back = new ImageIcon(getClass().getResource("Settings/Back Button.png"));
    JLabel back_l = new JLabel(back);
    static JTextField player_1 = new JTextField("Player 1");
    static JTextField player_2 = new JTextField("Player 2");
    boolean ready_1 = false;
    boolean ready_2 = false;

    public Inputs() {
        Loop.Menu.setContentPane(new JLabel(new ImageIcon(inputsBackground)));
        Loop.Menu.addMouseListener(this);
        player_1.setBounds(430,205,250,35);
        player_1.setFont(new Font("Comic Sans",Font.BOLD,20));
        Loop.Menu.add(player_1);
        player_2.setBounds(430,350,250,35);
        player_2.setFont(new Font("Comic Sans",Font.BOLD,20));
        Loop.Menu.add(player_2);
        ready1_l.setBounds(812,200,176,45);
        ready1_l.addMouseListener(this);
        Loop.Menu.add(ready1_l);
        ready2_l.setBounds(809,347,176,45);
        ready2_l.addMouseListener(this);
        Loop.Menu.add(ready2_l);
        play_l.setBounds(570,605,177,50);
        play_l.addMouseListener(this);
        Loop.Menu.add(play_l);
        back_l.setBounds(55,606,180,55);
        Loop.Menu.add(back_l);
        back_l.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() == ready1_l) {
            ready_1 = true;
        }
        else if (mouseEvent.getSource() == ready2_l) {
             ready_2 = true;
        }
        else if (mouseEvent.getSource() == back_l) {
           // twoInputs.setVisible(false);
            Selection s=new Selection();
            //s.selection.setVisible(true);
        }
        else if (mouseEvent.getSource() == play_l && ready_2 && ready_1) {
            //twoInputs.setVisible(false);
            Game g=new Game();
            Promotion P =new Promotion();
            //Display.Game.setVisible(true);
            Game.Name1.setText(player_1.getText());
            Game.name2.setText(player_2.getText());
            Music.c.close();
        }
    }
}
