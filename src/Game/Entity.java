package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    GamePanel gp;
    public int speed;
    public int maxLife;
    public int life;
    public int actionLockCounter = 0;

    public int x,y;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public BufferedImage run,stand;

    public Entity(GamePanel gp){
        this.gp = gp;
    }



    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
