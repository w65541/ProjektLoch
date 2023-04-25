package GameLogic;

public class Potion{

    int count=3;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void heal(Player p){
        p.heal((int) (p.getMaxHP()*0.4));
        count--;
    }
    public void add(){count++;}
}
