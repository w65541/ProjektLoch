package GameLogic;

import java.util.ArrayList;

public class Player extends Entity{
    int view;
     int bHp=10,bSpeed=5,bDamage=1,level=0,lastLevel;
    ArrayList<Item> inv=new ArrayList<>();
    Direction dir;
    Item helmet,armor,boots, weapon,shield;
    Potion potion=new Potion();
boolean key=false;
    public Player() {
        setHp(bHp);
        setMaxHP(bHp);
        setDamage(bDamage);
        setDef(0);
        setSpeed(5);

    }



    boolean active=true;

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public Item getHelmet() {
        return helmet;
    }

    public void setHelmet(Item helmet) {
        if(helmet.type.equals("helmet") || helmet.getId()==0) this.helmet = helmet;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        if(armor.type.equals("armor")|| armor.getId()==0) this.armor = armor;
    }

    public Item getBoots() {
        return boots;
    }

    public void setBoots(Item boots) {
        if(boots.type.equals("boots")|| boots.getId()==0)this.boots = boots;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        if(weapon.type.equals("weapon")|| weapon.getId()==0) this.weapon = weapon;
    }

    public Item getShield() {
        return shield;
    }

    public void setShield(Item shield) {
        if(shield.type.equals("shield")|| shield.getId()==0) this.shield = shield;
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
public void nextLevel(){level++;}
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
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

    public Item equip(Item item){
        Item temp;
        switch (item.type){
            case "helmet":
                temp=new Item(getHelmet());
            setHelmet(new Item(item));
            updateStats();
            return temp;
            case "armor":
                temp=new Item(getArmor());
                setArmor(new Item(item));
                updateStats();
                return temp;
            case "boots":
                temp=new Item(getBoots());
                setBoots(new Item(item));
                updateStats();
                return temp;
                case "weapon":
                temp=new Item(getWeapon());
                setWeapon(new Item(item));
                updateStats();
                return temp;
                case "shield":
                temp=new Item(getShield());
                setShield(new Item(item));
                updateStats();
                return temp;
        }
        return null;
    }
    void updateStats(){
        setDef(helmet.getDef()+armor.getDef()+boots.getDef()+weapon.getDef()+shield.getDef());
        setMaxHP(bHp+helmet.getHp()+armor.getHp()+boots.getHp()+weapon.getHp()+shield.getHp());
        setSpeed(bSpeed+helmet.getSpeed()+armor.getSpeed()+boots.getSpeed()+weapon.getSpeed()+shield.getSpeed());
        setDamage(bDamage+helmet.getDamage()+armor.getDamage()+boots.getDamage()+weapon.getDamage()+shield.getDamage());
    }
    public ArrayList<Item> getInv() {
        return inv;
    }

    public void setInv(ArrayList<Item> inv) {
        this.inv = inv;
    }

    public Potion getPotion() {
        return potion;
    }
}
