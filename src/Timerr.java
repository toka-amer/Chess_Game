import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Timerr{

    JLabel counterLabel;
    Font font= new Font("Arial",Font.PLAIN,50);
    Timer timer;
    int second,minute;
    String dSecond, dMinute;
    DecimalFormat dFormat = new DecimalFormat("00");

    public Timerr(){

        counterLabel=new JLabel();
        counterLabel.setBounds(200,20,200,100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font);
        second=0;
        minute=0;
        counterLabel.setText("00:00");

        setTimer();
        timer.start();
    }

    public void setTimer(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                dSecond=dFormat.format(second);
                dMinute=dFormat.format(minute);

                counterLabel.setText(dMinute+":"+dSecond);

                if(second==60){
                    second=0;
                    minute++;
                    dSecond=dFormat.format(second);
                    dMinute=dFormat.format(minute);
                    counterLabel.setText(dMinute+":"+dSecond);
                }
                if(second==0 && minute ==0){
                    timer.stop();
                }
            }
        });
    }
}
