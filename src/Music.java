
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Music  {
    static Clip c,move,check;
      String filePath1,filePath2,filePath3;
    //public  Music() {
        public void sound(){
            try {
                filePath1 = "src\\Soft-electronic-ambient-background-music.wav";
                File musicPath1 = new File(filePath1);

                if (musicPath1.exists()) {
                    //bring music from file
                    AudioInputStream Au = AudioSystem.getAudioInputStream(musicPath1);

                    //clip class plays music
                    c = AudioSystem.getClip();
                    c.open(Au);
                    c.start();
                    c.loop(Clip.LOOP_CONTINUOUSLY);

                    //an interrupt to stop clip from killing itself
                    //  JOptionPane.showMessageDialog(null,"Press OK to stop playing");
                } else {
                    System.out.println("Music File is not exists...");
                }
            } catch (Exception e) {

                //prints the actual error message in debugging ( To make debugging easier )
                e.printStackTrace();
            }
        }

    public void movesound(){
        try {
            filePath2 = "src\\movesound.wav";
            File musicpath2 = new File(filePath2);
            if (musicpath2.exists()) {
                AudioInputStream input = AudioSystem.getAudioInputStream(musicpath2);
                move = AudioSystem.getClip();
                move.open(input);
                move.start();
            } else {
                System.out.println("Music File is not exist.....");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void checksound(){
        try {
            filePath3 = "src\\check sound.wav";
            File musicpath3 = new File(filePath3);
            if (musicpath3.exists()) {
                AudioInputStream input = AudioSystem.getAudioInputStream(musicpath3);
                check = AudioSystem.getClip();
                check.open(input);
                check.start();
            } else {
                System.out.println("Music File is not exist.....");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
