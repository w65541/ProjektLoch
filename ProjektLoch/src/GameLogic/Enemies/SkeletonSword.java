package GameLogic.Enemies;

import GameLogic.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Standardowy przeciwnik
 */
public class SkeletonSword extends Enemy{
    public SkeletonSword() {
        setHp(5+random.nextInt(dif)+(dif/2));
        setSpeed(7);
        setDef(dif);
        setDamage(3+random.nextInt(dif)+(dif/2));
        name="Skeleton";
    }

    @Override
    public void attack(Player player, Timer timer) {
        player.getHit(getDamage());setActive(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed()-1)*1000);
    }
}
