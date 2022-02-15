import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input extends MouseAdapter implements MouseListener {
    Image inputBackground =Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\Player 1.png");
    ImageIcon ready = new ImageIcon(getClass().getResource("Buttons/Ready.png"));
    JLabel ready_l = new JLabel(ready);
    ImageIcon play = new ImageIcon(getClass().getResource("Settings/Button.png"));
    JLabel play_l = new JLabel(play);
    ImageIcon back = new ImageIcon(getClass().getResource("Settings/Back Button.png"));
    JLabel back_l = new JLabel(back);
    JTextField player_1 = new JTextField("Player 1");
    boolean ready_1 = false;

    public Input() {
        Loop.Menu.setContentPane(new JLabel(new ImageIcon(inputBackground)));
        player_1.setBounds(430, 205, 250, 35);
        player_1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        player_1.addMouseListener(this);
        Loop.Menu.add(player_1);
        ready_l.setBounds(812,200,176,45);
        ready_l.addMouseListener(this);
        Loop.Menu.add(ready_l);
        play_l.setBounds(570,605,177,50);
        play_l.addMouseListener(this);
        Loop.Menu.add(play_l);
        back_l.setBounds(55,606,180,55);
        back_l.addMouseListener(this);
        Loop.Menu.add(back_l);

    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() == ready_l) {
            ready_1 = true;
        }
        else if (mouseEvent.getSource() == back_l) {
            Selection s=new Selection();
        }
        else if (mouseEvent.getSource() == play_l  && ready_1) {
            Game g=new Game();
            Game.Name1.setText(player_1.getText());
            Game.name2.setText("Computer");
            Music.c.close();
        }
    }
}
