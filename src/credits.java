import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class credits extends MouseAdapter implements MouseListener {
    //JFrame frame =new JFrame("Credits");
    Image creditsBackground=Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\cridets.png");
    ImageIcon back=new ImageIcon(getClass().getResource("Settings/Back Button.png"));
    JLabel Back_l=new JLabel(back);
    public  credits(){
       /* frame.setResizable(true);
        frame.setSize(1280,720);
        frame.setVisible(false);
        frame.setLocation(frame.getSize().width/4,frame.getSize().height/4);*/
        Loop.Menu.setContentPane(new JLabel(new ImageIcon(creditsBackground)));
        Back_l.setBounds(450,600,402,94);
        Loop.Menu.add(Back_l);
        Back_l.addMouseListener(this);
    }
    public void mousePressed(MouseEvent mouseEvent){
        if (mouseEvent.getSource()==Back_l){
            /*frame.setVisible(false);
            Loop.Menu.setVisible(true);*/
            Loop.setWindow();
        }
    }

}
