package GameLogic.Enemies;

import GameLogic.Player;
import GameLogic.Szlam;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Słaby przeciwnik ale potrafi zasłaniać innych przeciwników
 */
public class Slime extends Enemy{
    public Slime(){
        setHp(15+random.nextInt(dif)+(dif/2));
        setMaxHP(getHp());
        setSpeed(10);
        setDef(dif);
        setDamage(2+random.nextInt(dif)+(dif/2));
        setNumOfAttacks(2);
        enemyId=5;
        name="Slime";
    }
    @Override
    public void attack(Player player, Timer timer) {
        setActive(false);
        int i=random.nextInt(getNumOfAttacks());
        switch (i){
            case 0:
                if(getHp()>0) player.getHit(getDamage());
                break;
            case 1:
                if(getDamage()>0){
                JFrame a=new Szlam();
                a.setLocationRelativeTo(null);
                a.setVisible(true);}
                break;
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed())*1000);
    }
}
