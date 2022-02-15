import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Selection extends MouseAdapter implements MouseListener {
    static boolean computer_play = false;
    Image selectionBackground = Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\Main menu1.png");
    ImageIcon twoPlayers = new ImageIcon(getClass().getResource("Buttons/Two Players.png"));
    JLabel twoPlayers_l = new JLabel(twoPlayers);
    ImageIcon onePlayer = new ImageIcon(getClass().getResource("Buttons/One Player.png"));
    JLabel onePlayer_l = new JLabel(onePlayer);
    ImageIcon back = new ImageIcon(getClass().getResource("Buttons/Back.png"));
    JLabel back_l = new JLabel(back);

    public Selection() {

            Loop.Menu.setContentPane(new JLabel(new ImageIcon(selectionBackground)));
            onePlayer_l.setBounds(450, 200, 402, 94);
            onePlayer_l.addMouseListener(this);
            Loop.Menu.add(onePlayer_l);
            twoPlayers_l.setBounds(450, 350, 402, 94);
            twoPlayers_l.addMouseListener(this);
            Loop.Menu.add(twoPlayers_l);
            back_l.setBounds(450, 550, 402, 94);
            Loop.Menu.add(back_l);
            back_l.addMouseListener(this);

        }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == onePlayer_l) {
            computer_play = true;
            Input input = new Input();
        } else if (mouseEvent.getSource() == twoPlayers_l) {
            computer_play = false;
            Inputs inputs = new Inputs();
        } else if (mouseEvent.getSource() == back_l) {
            Loop.setWindow();
        }
    }
}
