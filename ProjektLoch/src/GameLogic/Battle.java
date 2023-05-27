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
    private JProgressBar progressBarEnemy;
    private JProgressBar progressBarPlayer;
    private JProgressBar enemyHp;
    private JLabel enemyName;
    private JProgressBar playerHp;
    Timer timer = new Timer();
    int seconds=0,bugfix=0;
    int seconds_p=0;
    BattleLogic battle;
    Room room;
    public Battle(Player p, Enemy enemy, MainView mainView, Room r) {
        room=r;
        enemyName.setText(enemy.getName());
        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,700);
        //Player p=new Player();
        //Enemy enemy=new SkeletonSword(1);

        enemyHp.setMaximum(enemy.getHp());
        playerHp.setMaximum(p.getHp());
        progressBarEnemy.setMaximum(enemy.getSpeed());
        progressBarPlayer.setMaximum(p.getSpeed());
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

    }
    void update(Player p,Enemy e){
        enemyHp.setValue(e.getHp());
        enemyHp.setString(""+e.getHp()+"/"+e.getMaxHP());
        playerHp.setValue(p.getHp());
        playerHp.setString(""+p.getHp()+"/"+p.getMaxHP());
        if(!e.isActive()) {
            progressBarEnemy.setMaximum(e.getSpeed());
            progressBarEnemy.setValue(seconds % e.getSpeed());
        }else {
            progressBarEnemy.setMaximum(e.getSpeed());
            seconds=0;
        }

        if(!battle.isPlayerActive()){
            progressBarPlayer.setValue(seconds_p%p.getSpeed());
        attackButton.setEnabled(false);
            defendButton.setEnabled(false);

            progressBarPlayer.setMaximum(p.getSpeed());
        }else{
            progressBarPlayer.setValue(p.getSpeed());
            attackButton.setEnabled(true);

            seconds_p=-1;
        }
    }

    void win(Enemy e,MainView m,Player p){
        m.setN(m.getN()-1);
        System.out.println(m.getN());
        if (m.getN()==0){m.setVisible(true);
        room.setEnemies(null, 0);}
        room.setEnemy(false);
        m.updateHp(p);
        dispose();

    }
}
