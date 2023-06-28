package GameLogic.Enemies;

import GameLogic.Player;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Szkielet z ładowanym silnym atakiem
 */
public class SkeletonMace extends Enemy{
    boolean ready=true;

    public SkeletonMace() {
        setHp(13+random.nextInt(dif)+(dif/2));setMaxHP(getHp());
        setSpeed(10);
        setDef((int) (dif*1.5));
        setDamage(5+random.nextInt(dif)+(dif/2));
        setNumOfAttacks(2);
        enemyId=3;name="Skeleton";
    }

    @Override
    public void attack(Player player, Timer timer) {
        setActive(false);
        if(ready){
            switch (random.nextInt(getNumOfAttacks())){
                case 0:if(getHp()>0) player.getHit(getDamage());break; //zwykły atak
                case 1://
                    ready=false;
                    setSpeed(20);
                    break;}
        }else {
            if(getHp()>0) player.getHit(getDamage()*3);
            ready=true;
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed()-1)*1000);
    }
}
