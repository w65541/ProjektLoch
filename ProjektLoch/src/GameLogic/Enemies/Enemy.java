package GameLogic.Enemies;

import GameLogic.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;

public abstract class Enemy extends Entity {
BufferedImage image;//= ImageIO.read(new File("C:\\Users\\HP\\Documents\\JAWA\\szkolenietechniczne1\\Projekt-szkolenie-techniczne\\ProjektLoch\\src\\images\\deadend.png")));
int enemyId,numOfAttacks=1;
int[] attackType;
int dif=1;

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(int enemyId) {
        this.enemyId = enemyId;
    }

    public int getNumOfAttacks() {
        return numOfAttacks;
    }

    public void setNumOfAttacks(int numOfAttacks) {
        this.numOfAttacks = numOfAttacks;
    }

    public int[] getAttackType() {
        return attackType;
    }

    public void setAttackType(int[] attackType) {
        this.attackType = attackType;
    }
    public abstract void attack(Player player, Timer timer);
}
