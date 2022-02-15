import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class leaderboard extends MouseAdapter implements MouseListener{
    private static  Connection conn ;
    private static  PreparedStatement pst=null;
    private static  Statement stmt ;
    static JFrame Leader = new JFrame("Leader Board");
    Image background=Toolkit.getDefaultToolkit().getImage("src\\Backgrounds\\Leader board back.png");
    JLabel Names[]=new JLabel[10];
    JLabel Score[]=new JLabel[10];
    Font font = new Font("Algerian",Font.PLAIN,50);
    ImageIcon back = new ImageIcon(getClass().getResource("Settings\\Back Button.png"));
    JLabel back_l = new JLabel(back);
    /*






    Just Server a MY sql database server on your PC and put your User name and Password in line 62








     */
    public leaderboard() {
        Leader.setVisible(false);
        Leader.setResizable(true);
        Leader.setSize(1280,720);
        Leader.setLocation(Leader.getSize().width/4,Leader.getSize().height/4);
        Leader.setContentPane(new JLabel(new ImageIcon(background)));
        Leader.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        for(int i=0;i<8;i++){
            Names[i]=new JLabel();
            Names[i].setBounds(193,137+(i*57),495,51);
            Names[i].setHorizontalAlignment(JLabel.LEFT);
            Names[i].setFont(font);
            Score[i]=new JLabel();
            Score[i].setBounds(687,137+(i*57),495,51);
            Score[i].setHorizontalAlignment(JLabel.CENTER);
            Score[i].setFont(font);
        }
        back_l.setBounds(225,600,180,55);
        Leader.add(back_l);
        back_l.addMouseListener(this);

        try{
            //stmt.executeQuery("")
            // bt3ml load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //bt3aml b2a connection l JDBC driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboared","root","112000@Pp");
            // 8albn awl parameter dh constant fo kolo

            // b3d kda bt3ml statement 34an t execute el query
            stmt = conn.createStatement();
            // di b2a bttkrr 3la hasb 3dd el query elly 3ndk
            ResultSet rs = stmt.executeQuery("select * from leaderboared.leader order by score desc limit 8");
            // rs.next() dh tol ma fi lsa result rag3a mn el query b true
            for (int i=0;i<8&& rs.next();i++) {
                // 34an tgeb el value el query hyrg3o getString(datatype bta3t el column)(asm el column)
                System.out.println(rs.getString("user_name")+" "+rs.getString("score"));
                Names[i].setText(rs.getString("user_name"));
                Score[i].setText(rs.getString("score"));
            }
            for(int i=0;i<8;i++){
            Leader.add(Names[i]);
            Leader.add(Score[i]);
            }
            // close el conection object
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    static public void insert(String name , int score){
        try {
            String temp = "INSERT INTO leaderboared.leader VALUES( ? ,?)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboared","root","112000@Pp");
            pst=conn.prepareStatement(temp);
            pst.setString(1,name);
            pst.setString(2,Integer.toString(score));
            pst.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
