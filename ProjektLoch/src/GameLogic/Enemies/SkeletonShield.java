package GameLogic.Enemies;

import GameLogic.Player;

import java.util.Timer;
import java.util.TimerTask;

public class SkeletonShield extends Enemy{
    public SkeletonShield() {
        setHp(10+random.nextInt(dif)+(dif/2));
        setSpeed(8);
        setDef(dif*2);
        setDamage(2+random.nextInt(dif)+(dif/2));
        setNumOfAttacks(2);
    }

    @Override
    public void attack(Player player, Timer timer) {
        setActive(false);
        int i=random.nextInt(getNumOfAttacks());
        System.out.println(i);
        switch (i){
            case 0:
                setDef(getDef()/2);
                setSpeed(8);
                player.getHit(getDamage());
                break;
            case 1:
                setDef(getDef()*2);
                setSpeed(4);
            ;break;
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed())*1000);
    }
}
