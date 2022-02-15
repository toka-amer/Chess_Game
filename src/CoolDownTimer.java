import javax.swing.*;
import java.awt.*;

import java.text.DecimalFormat;

public class CoolDownTimer {
    //Timer
    JLabel counterLabel;
    Font font= new Font("Algerian",Font.PLAIN,62);
    Timer timer;
    int second,minute;
    String dSecond, dMinute;
    DecimalFormat dFormat = new DecimalFormat("00");

    public CoolDownTimer(Point p){
        //Timer
        counterLabel=new JLabel();
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font);
        second=0;
        minute=10;
        counterLabel.setText("10:00");
        counterLabel.setBounds(p.x,p.y, 170,70);
        CoolDown();
        timer.start();

    }

    public void CoolDown(){
        timer = new Timer(1000, e -> {
            second--;
            dSecond=dFormat.format(second);
            dMinute=dFormat.format(minute);

            counterLabel.setText(dMinute+":"+dSecond);

            if(second==-1){
                second=59;
                minute--;
                dSecond=dFormat.format(second);
                dMinute=dFormat.format(minute);
                counterLabel.setText(dMinute+":"+dSecond);
            }
            if(second==0 && minute ==0){
                timer.stop();
            }
        });
    }
}
