package GameLogic;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa Reprezentująca przedmioty, przechowuje ich atrybuty
 */
public class Item {
    int hp,speed,damage,def,num,id;
    Map<Integer, String > types;
    String name,type,desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(int hp, int speed, int damage, int def, String name, String type) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.def = def;
        this.name = name;
        this.type = type;
    }
    public Item(String name, String type,int hp, int speed, int damage, int def,int id) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.def = def;
        this.name = name;
        this.type = type;
        this.id=id;
    }
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Item(Item i) {
        this.hp = i.hp;
        this.speed = i.speed;
        this.damage = i.damage;
        this.def = i.def;
        this.name = i.name;
        this.type = i.type;
        id=i.id;
    }
    public Item(Item i,Item i2) {
        this.hp = i.hp;
        this.speed = i.speed;
        this.damage = i.damage;
        this.def = i.def;
        this.name = i.name;
        this.type = i2.type;
    }

    public Item(int id) {
        this.id = id;
    }

    /**
     *
     * @return sformatowane atrybuty
     */
    String opis(){
        String opis="";
        opis+=name+"\n"+type+"\n";
        if (hp!=0) opis+="Health: +"+hp+" ";
        if (def!=0) opis+="Defense: +"+def+" ";
        if (speed!=0) opis+="Speed: +"+speed+" ";
        if (damage!=0) opis+="Damage: +"+damage+" ";
        return opis;
    }

    @Override
    public String toString() {
        return ""+ name + " " + type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
