package GameLogic;
import java.util.Random;

/**
 * Klasa bazowa dla gracza i [rzeciwników
 */
public class Entity {
    int x,y,hp=10,speed=2,def=0,damage=1,maxHP=10;
    boolean active=true;

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHp) {
        this.maxHP = maxHp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public int getSpeed() {
        return speed;
    }
    public void kill(){hp=0;}
    public int getDef() {
        return def;
    }
    public Random random=new Random();


    public void setDef(int def) {
        this.def = def;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Byt traci życie równe obrażenia-obrona
     * @param damage obrażenia
     */
    public void getHit(int damage){
        this.setHp(this.getHp()+def-damage);
        if(damage>0)this.setHp(this.getHp()-1);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Leczy byt
     * @param i ilość życia do uleczenia
     */
    public void heal(int i){
        setHp(getHp()+i);
        if(getHp()>getMaxHP()) setHp(getMaxHP());
    }
}
