package GameLogic;

public class Entity {
    int x,y,hp=10,speed=5,def=0;

    public int getSpeed() {
        return speed;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    void getHit(int damage){
        this.setHp(this.getHp()+def-damage);
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
}
