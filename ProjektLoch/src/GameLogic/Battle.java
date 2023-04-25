package GameLogic;

import GameLogic.Enemies.Enemy;

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
    BattleLogic battle;
    public Battle(Player p, Enemy enemy, MainView mainView) {

        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,700);
        //Player p=new Player();
        //Enemy enemy=new SkeletonSword(1);

        enemyHp.setMaximum(enemy.getHp());
        progressBar1.setMaximum(enemy.getSpeed());
        progressBar2.setMaximum(p.getSpeed());
        battle=new BattleLogic(p,enemy);
System.out.println(battle.toString());


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
                if(enemy.getHp()<1) {
                    win(enemy, mainView,p);
                    timer.cancel();
                }}
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
        escapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    void update(Player p,Enemy e){
        enemyHp.setValue(e.getHp());
        enemyHp.setString(""+e.getHp()+"/"+e.getMaxHP());

        if(!e.isActive()) {
            progressBar1.setMaximum(e.getSpeed());
            progressBar1.setValue(seconds % e.getSpeed());
        }else {
            progressBar1.setMaximum(e.getSpeed());
            seconds=0;
        }
        if(!battle.isPlayerActive()){
            progressBar2.setValue(seconds_p%p.getSpeed());
        attackButton.setEnabled(false);
            defendButton.setEnabled(false);
            escapeButton.setEnabled(false);
            progressBar2.setMaximum(p.getSpeed());
        }else{
            progressBar2.setValue(p.getSpeed());
            attackButton.setEnabled(true);
            defendButton.setEnabled(true);
            escapeButton.setEnabled(true);
            seconds_p=-1;
        }
    }

    void win(Enemy e,MainView m,Player p){
        m.setN(m.getN()-1);
        System.out.println(m.getN());
        if (m.getN()==0)m.setVisible(true);
        m.updateHp(p);
        dispose();

    }
}
