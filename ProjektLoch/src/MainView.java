import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameLogic.*;
public class MainView extends JFrame{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JPanel panel;
    private JLabel roomView;

    public MainView() {
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        Logic logic=new Logic();

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Player test=new Player();
            test.setDir(Direction.S);
            Room room=new Room(RoomType.DEADEND_WEST,0,0);
            logic.roomRender(roomView,room,test);
            }
        });
    }
}
