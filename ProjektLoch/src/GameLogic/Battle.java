package GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Battle extends JFrame{
    private JLabel enemyView;
    private JPanel panel;
    private JButton attackButton;
    private JButton defendButton;
    private JButton escapeButton;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar enemyHp;
    Timer timer = new Timer();
    int seconds=0;
    int seconds_p=0;
    public Battle() {

        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,700);
        Player p=new Player();
        Enemy enemy=new Enemy();
        enemy.setSpeed(10);
p.setDef(1);
enemy.setDamage(2);
        enemyHp.setMaximum(enemy.getHp());
        progressBar1.setMaximum(enemy.getSpeed());
        progressBar2.setMaximum(p.getSpeed());
        BattleLogic battle=new BattleLogic(p,enemy);



        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                seconds_p++;
            }
        },1000,1000); //zegar

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update(p,enemy);
            }
            },1,1); //update



        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            battle.playerAttack();
            }
        });

        defendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battle.playerDefend();
            }
        });
    }
    void update(Player p,Enemy e){
        enemyHp.setValue(e.getHp());
        enemyView.setText(""+p.getHp());
        progressBar1.setValue(seconds%e.getSpeed());
        if(!p.isActive()){progressBar2.setValue(seconds_p%p.getSpeed());
        attackButton.setEnabled(false);
            defendButton.setEnabled(false);
            escapeButton.setEnabled(false);

        }else{
            progressBar2.setValue(p.getSpeed());
            attackButton.setEnabled(true);
            defendButton.setEnabled(true);
            escapeButton.setEnabled(true);
            seconds_p=-1;
        }
    }
}
