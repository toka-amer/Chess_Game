import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Settings extends MouseAdapter implements MouseListener{
    static JLabel radioButton1,radioButton2,radioButton3,radioButton1Selected,radioButton2Selected,radioButton3Selected,musicOn,musicOff,theme1,theme2,theme3,theme1Button,theme2Button,theme3Button,theme1ButtonSelected,theme2ButtonSelected,theme3ButtonSelected,backButton;
    Image backGround1=Toolkit.getDefaultToolkit().getImage("src\\Settings\\Settings Background.png");
    ImageIcon time1Img,time2Img,time3Img,time1ImgSelected,time2ImgSelected,time3ImgSelected,MusicOn,MusicOff,Theme1,Theme2,Theme3,themeButton,themeButtonSelected,BackImg;
    static int count=1,themecount=2;
    public Settings() {
        //Choose the time of game
        //First RadioButton Selected
        time1ImgSelected = new ImageIcon(getClass().getResource("Settings\\time1ImgSelected.png"));
        radioButton1Selected = new JLabel(time1ImgSelected);
        radioButton1Selected.setBounds(500, 155, 110, 24);
        radioButton1Selected.addMouseListener(this);
        //First RadioButton Unselected
        time1Img = new ImageIcon(getClass().getResource("Settings\\time1Img.png"));
        radioButton1 = new JLabel(time1Img);
        radioButton1.setBounds(500, 155, 110, 24);
        radioButton1.addMouseListener(this);
        radioButton1.setVisible(false);
        //Second RadioButton Unselected
        time2Img = new ImageIcon(getClass().getResource("Settings\\time2Img.png"));
        radioButton2 = new JLabel(time2Img);
        radioButton2.setBounds(700, 155, 108, 24);
        radioButton2.addMouseListener(this);
        //Second RadioButton Selected
        time2ImgSelected = new ImageIcon(getClass().getResource("Settings\\time2ImgSelected.png"));
        radioButton2Selected = new JLabel(time2ImgSelected);
        radioButton2Selected.setBounds(700, 155, 108, 24);
        radioButton2Selected.addMouseListener(this);
        radioButton2Selected.setVisible(false);
        //Third RadioButton Unselected
        time3Img = new ImageIcon(getClass().getResource("Settings\\time3Img.png"));
        radioButton3 = new JLabel(time3Img);
        radioButton3.setBounds(900, 155, 112, 24);
        radioButton3.addMouseListener(this);
        //Third RadioButton Selected
        time3ImgSelected = new ImageIcon(getClass().getResource("Settings\\time3ImgSelected.png"));
        radioButton3Selected = new JLabel(time3ImgSelected);
        radioButton3Selected.setBounds(900, 155, 112, 24);
        radioButton3Selected.addMouseListener(this);
        radioButton3Selected.setVisible(false);
        //Music Off
        MusicOff = new ImageIcon(getClass().getResource("Settings\\Music off.png"));
        musicOff = new JLabel(MusicOff);
        musicOff.setBounds(600, 200, 74, 75);
        musicOff.setVisible(false);
        musicOff.addMouseListener(this);
        //Music On
        MusicOn = new ImageIcon(getClass().getResource("Settings\\music on.png"));
        musicOn = new JLabel(MusicOn);
        musicOn.setBounds(600, 200, 74, 75);
        musicOn.addMouseListener(this);

        //Game Themes
        //Theme1
        Theme1 = new ImageIcon(getClass().getResource("Settings\\Board1.png"));
        theme1 = new JLabel(Theme1);
        theme1.setBounds(180, 380, 224, 133);

        //Theme2
        Theme2 = new ImageIcon(getClass().getResource("Settings\\Board2.png"));
        theme2 = new JLabel(Theme2);
        theme2.setBounds(530, 380, 226, 133);

        //Theme3
        Theme3 = new ImageIcon(getClass().getResource("Settings\\Board3.png"));
        theme3 = new JLabel(Theme3);
        theme3.setBounds(880, 380, 224, 133);

        //Themes RadioButton
        themeButton = new ImageIcon(getClass().getResource("Settings\\R3.png"));
        themeButtonSelected = new ImageIcon(getClass().getResource("Settings\\R4.png"));

        //Theme1 RadioButton
        theme1Button = new JLabel(themeButton);
        theme1Button.setBounds(280, 350, 20, 21);
        theme1Button.setVisible(true);
        theme1Button.addMouseListener(this);
        //Theme2 RadioButton
        theme2Button = new JLabel(themeButton);
        theme2Button.setBounds(640, 350, 20, 21);
        theme2Button.setVisible(false);
        theme2Button.addMouseListener(this);
        //Theme3 RadioButton
        theme3Button = new JLabel(themeButton);
        theme3Button.setBounds(990, 350, 20, 21);
        theme3Button.setVisible(true);
        theme3Button.addMouseListener(this);

        //Theme1 RadioButton Selected
        theme1ButtonSelected = new JLabel(themeButtonSelected);
        theme1ButtonSelected.setBounds(280, 350, 20, 22);
        theme1ButtonSelected.setVisible(false);
        theme1ButtonSelected.addMouseListener(this);
        //Theme2 RadioButton Selected
        theme2ButtonSelected = new JLabel(themeButtonSelected);
        theme2ButtonSelected.setBounds(640, 350, 20, 22);
        theme2ButtonSelected.setVisible(true);
        theme2ButtonSelected.addMouseListener(this);
        //Theme3 RadioButton Selected
        theme3ButtonSelected = new JLabel(themeButtonSelected);
        theme3ButtonSelected.setBounds(990, 350, 20, 22);
        theme3ButtonSelected.setVisible(false);
        theme3ButtonSelected.addMouseListener(this);

        //BackButton
        BackImg = new ImageIcon(getClass().getResource("Settings\\Back Button.png"));
        backButton = new JLabel(BackImg);
        backButton.setBounds(80, 580, 180, 55);
        backButton.addMouseListener(this);

        Loop.Menu.setContentPane(new JLabel(new ImageIcon(backGround1)));
        Loop.Menu.add(radioButton1);
        Loop.Menu.add(radioButton2);
        Loop.Menu.add(radioButton3);
        Loop.Menu.add(radioButton1Selected);
        Loop.Menu.add(radioButton2Selected);
        Loop.Menu.add(radioButton3Selected);
        Loop.Menu.add(musicOff);
        Loop.Menu.add(musicOn);
        Loop.Menu.add(theme1);
        Loop.Menu.add(theme2);
        Loop.Menu.add(theme3);
        Loop.Menu.add(theme1Button);
        Loop.Menu.add(theme2Button);
        Loop.Menu.add(theme3Button);
        Loop.Menu.add(theme1ButtonSelected);
        Loop.Menu.add(theme2ButtonSelected);
        Loop.Menu.add(theme3ButtonSelected);
        Loop.Menu.add(backButton);
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == radioButton1) {
            radioButton1.setVisible(false);
            radioButton1Selected.setVisible(true);
            radioButton2.setVisible(true);
            radioButton2Selected.setVisible(false);
            radioButton3.setVisible(true);
            radioButton3Selected.setVisible(false);
            System.out.println("Game Time is 10");
            count=1;
            System.out.println("the count = "+count);
        }
        else if(mouseEvent.getSource()==radioButton1Selected||mouseEvent.getSource()==radioButton2Selected||mouseEvent.getSource()==radioButton3Selected){
            System.out.println("Click!!");
        }
        else if (mouseEvent.getSource() == radioButton2) {
            radioButton2.setVisible(false);
            radioButton2Selected.setVisible(true);
            radioButton1Selected.setVisible(false);
            radioButton1.setVisible(true);
            radioButton3Selected.setVisible(false);
            radioButton3.setVisible(true);
            System.out.println("Game Time is 15");
            count=2;
            System.out.println("the count = "+count);
        }

        else if (mouseEvent.getSource() == radioButton3) {
            radioButton3.setVisible(false);
            radioButton3Selected.setVisible(true);
            radioButton1Selected.setVisible(false);
            radioButton1.setVisible(true);
            radioButton2Selected.setVisible(false);
            radioButton2.setVisible(true);
            System.out.println("Game Time is 20");
            count=3;
            System.out.println("the count = "+count);
        }

        else if(mouseEvent.getSource()==musicOn){
            Music.c.stop();
            System.out.println("Music Off");
            musicOff.setVisible(true);
            musicOn.setVisible(false);
        }
        else if(mouseEvent.getSource()==musicOff){
            Music.c.start();
            System.out.println("Music On");
            musicOff.setVisible(false);
            musicOn.setVisible(true);
        }
        else if(mouseEvent.getSource()==theme1Button){
            System.out.println("Theme1...");
            theme1Button.setVisible(false);
            theme1ButtonSelected.setVisible(true);
            theme2Button.setVisible(true);
            theme2ButtonSelected.setVisible(false);
            theme3Button.setVisible(true);
            theme3ButtonSelected.setVisible(false);
            themecount=1;

        }

        else if(mouseEvent.getSource()==theme2Button){
            System.out.println("Theme2...");
            theme1Button.setVisible(true);
            theme1ButtonSelected.setVisible(false);
            theme2Button.setVisible(false);
            theme2ButtonSelected.setVisible(true);
            theme3Button.setVisible(true);
            theme3ButtonSelected.setVisible(false);
            themecount=2;

        }
        else if(mouseEvent.getSource()==theme3Button){
            System.out.println("Theme3...");
            theme1Button.setVisible(true);
            theme1ButtonSelected.setVisible(false);
            theme2Button.setVisible(true);
            theme2ButtonSelected.setVisible(false);
            theme3Button.setVisible(false);
            theme3ButtonSelected.setVisible(true);
            themecount=3;
        }
        else if(mouseEvent.getSource()==backButton){
            Loop.setWindow();
        }
    }
}

