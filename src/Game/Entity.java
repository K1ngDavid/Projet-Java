package Game;

import Univers.Personnage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Entity {
    public int worldX,worldY;
    public boolean isMooving;
    GamePanel gp;
    public int speed;
    public int maxLife;
    public transient BufferedImage image;
    public int life;
    public boolean isDead = false;
    public int actionLockCounter = 0;
    public Rectangle solidArea = new Rectangle(0,0,28,28);
    public int x,y;
    public boolean collisionOn = false;
    public String direction;

    transient public BufferedImage run,stand;

    public Entity(GamePanel gp){
        this.gp = gp;
        this.setDefaultValues();
    }

    public void setDefaultValues(){
        direction = "down";
    }

    public void setAction(){

    }
    public void update(){

        setAction();
        System.out.println("LE CHAT EST BLOQUÉ ?" + collisionOn);
        gp.cChecker.checkTile(this);

        if(!collisionOn) {
            isMooving = true;
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }
        if(collisionOn) isMooving = false;

        gp.cChecker.checkPlayer(this);


    }
    public void draw(Graphics2D g2){
        if(isMooving){
            image = run;
        }else {
            image = stand;
        }
        g2.drawImage(image,x,y, gp.tileSize * 2, gp.tileSize*2,null);

    }



    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
