import javax.swing.*;

public class ValidationCircle {
    ImageIcon circle;
    JLabel circle_l;

    public  ValidationCircle()
    {
        circle=new ImageIcon(getClass().getResource("\\Pieces\\indexcopy.png"));
        circle_l=new JLabel(circle);
        circle_l.setBounds(100,100,200 , 200);

    }

}
