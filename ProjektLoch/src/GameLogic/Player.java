package GameLogic;

import java.util.ArrayList;

public class Player {
    int x,y,hp,view;
    ArrayList<Item> inv;
    Direction dir;

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

    public ArrayList<Item> getInv() {
        return inv;
    }

    public void setInv(ArrayList<Item> inv) {
        this.inv = inv;
    }
}
