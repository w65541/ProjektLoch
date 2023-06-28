package GameLogic.Enemies;

import GameLogic.Player;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Mało życia i atakuje tylko raz ale mocno
 */
public class Kaboom extends Enemy{
    public Kaboom() {
        setHp(20+random.nextInt(dif)+(dif/2));
        setSpeed(25);setMaxHP(getHp());
        setDef(0);
        setDamage(10+dif);
        enemyId=6;
        name="Kaboom";
    }

    @Override
    public void attack(Player player, Timer timer) {
       if(getHp()>0) player.getHit(getDamage());
        if(getDamage()>0)kill();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed()-1)*1000);
    }
}
