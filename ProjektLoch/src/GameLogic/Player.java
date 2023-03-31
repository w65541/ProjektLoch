package GameLogic;

import java.util.ArrayList;

public class Player extends Entity{
    int view,damage=1;
    ArrayList<Item> inv;
    Direction dir;
    boolean active=true;


    public int getDamage() {
        return damage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
        switch (view){
            case 0: setDir(Direction.S);break;
            case 1: setDir(Direction.W);break;
            case 2: setDir(Direction.N);break;
            case 3: setDir(Direction.E);break;
        }
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }



    public ArrayList<Item> getInv() {
        return inv;
    }

    public void setInv(ArrayList<Item> inv) {
        this.inv = inv;
    }
}
