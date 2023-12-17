package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    public int speed;

    public int x,y;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public BufferedImage run,stand;


    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}