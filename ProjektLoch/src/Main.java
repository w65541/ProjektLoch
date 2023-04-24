import GameLogic.*;
import GameLogic.Player;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //JFrame a=new MainView();
        //JFrame a=new Battle();
        //JFrame a=new Szlam();
        Player p=new Player();
        p.setHelmet(new Item(0,0,0,2,"Hełm","helmet"));
        p.setArmor(new Item(0,0,0,2,"a","armor"));
        p.setBoots(new Item(0,0,0,2,"b","boots"));
        p.setWeapon(new Item(0,0,1,0,"v","weapon"));
        p.setShield(new Item(0,0,0,2,"c","shield"));
        p.getInv().add(new Item(0,0,0,3,"Hełm żelazny","helmet"));
        JFrame a=new Backpack(p);
        a.setVisible(true);
    }
}