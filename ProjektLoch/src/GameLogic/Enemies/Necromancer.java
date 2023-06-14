package GameLogic.Enemies;

import GameLogic.Player;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * powolny i leczy sojuszników
 */
public class Necromancer extends Enemy{


    public Necromancer(ArrayList<Enemy> t) {
        setHp(5+random.nextInt(dif)+(dif/2));
        setSpeed(10);
        setDef(dif);
        setDamage(5+random.nextInt(dif)+(dif/2));
        team=t;
        setNumOfAttacks(2);
        name="Necromancer";
    }
    @Override
    public void attack(Player player, Timer timer) {
        if(team.size()>1){
            switch (random.nextInt(getNumOfAttacks())){
                case 0:player.getHit(getDamage());break; //zwykły atak
                case 1://leczenie innych
                    while (true){
                    Enemy temp =team.get(random.nextInt(team.size()));
                    if(temp.getHp()>0) {
                        temp.heal(getDamage());
                    break;
                    }
                    }
                    break;}
        }else {
            player.getHit(getDamage());
        }
        setActive(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setActive(true);
            }
        },(getSpeed()-1)*1000);
    }


}
