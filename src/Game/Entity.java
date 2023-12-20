package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    public boolean isMooving;
    GamePanel gp;
    public int speed;
    public int maxLife;
    public transient BufferedImage image;
    public int life;
    public int actionLockCounter = 0;
    public Rectangle solidArea = new Rectangle(0,0,28,28);
    public int x,y;
    public boolean collisionOn = false;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
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

        collisionOn = false;
        gp.cChecker.checkTile(this);
//        gp.cChecker.checkPlayer(this);


    }
    public void draw(Graphics2D g2){
        x = x - gp.player.x + gp.player.gamePanel.tileSize * 2;
        y = y - gp.player.y + gp.player.gamePanel.tileSize * 2;

        if(x + gp.tileSize > gp.player.x - gp.player.gamePanel.tileSize * 2 &&
        x - gp.tileSize < gp.player.worldX + gp.player.gamePanel.tileSize * 2 &&
        y + gp.tileSize > gp.player.y - gp.player.gamePanel.tileSize * 2 &&
        y - gp.tileSize < gp.player.x + gp.player.gamePanel.tileSize * 2){
            g2.setColor(Color.WHITE);
            image = null;

            if(isMooving){
                image = run;
            }else{
                image = stand;
            }
            g2.drawImage(image,x,y, gp.tileSize * 2, gp.tileSize*2,null);
        }

    }



    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
