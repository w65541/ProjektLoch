package GameLogic.Enemies;

import GameLogic.Player;

import java.util.Timer;

/**
 * Mało życia i atakuje tylko raz ale mocno
 */
public class Kaboom extends Enemy{
    public Kaboom() {
        setHp(20+random.nextInt(dif)+(dif/2));
        setSpeed(30);
        setDef(0);
        setDamage(10+dif);
    }

    @Override
    public void attack(Player player, Timer timer) {
        player.getHit(getDamage());
        kill();
    }
}
