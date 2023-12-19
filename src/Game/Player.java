package Game;

import Univers.Personnage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    public boolean isMooving = false;
    GamePanel gamePanel;
    KeyHandler keyH;

    Personnage personnage;
    public String runString = "../Images/Run.gif";
    public String standString = "../Images/Stand.png";

    public void setImages(String runString,String standString) {
        if(!(runString.isEmpty() || standString.isEmpty())){
            System.out.println("RunString -->" +runString);
            System.out.println("StandString -->" +standString);
            this.runString = runString;
            this.standString = standString;
        }
        this.getPlayerImage();
    }


    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Player(GamePanel gamePanel, KeyHandler keyH, String run, String stand){
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 32;
        solidArea.y = 32;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
        this.runString = run ;
        this.standString = stand;
    }

    public void setDefaultValues(){
        worldX = gamePanel.tileSize * 23;
        worldY = gamePanel.tileSize * 21;
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void update(){
        isMooving = false;
        if(keyH.upPressed){
            direction = "up";
            isMooving = true;
        } else if (keyH.downPressed) {
            direction = "down";
            isMooving = true;
        } else if (keyH.leftPressed){
            direction = "left";
            isMooving = true;
        } else if (keyH.rightPressed) {
            direction = "right";
            isMooving = true;
        }

        collisionOn = false;
        gamePanel.cChecker.checkTile(this);
        if(!collisionOn && isMooving){
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }
    }

    public void getPlayerImage(){
        try{
            run = ImageIO.read(getClass().getResourceAsStream(this.runString));
            stand = ImageIO.read(getClass().getResourceAsStream(this.standString));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        BufferedImage image = null;
//        switch (direction){
//            if(spriteCounter == 1){
//                image = up1;
//            }
//            if(spriteNum == 2){
//                image = up1
//            }
//            case "up":
//                image =
//        }
        if(isMooving){
            image = run;
        }else{
            image = stand;
        }
        g2.drawImage(image,x,y, gamePanel.tileSize * 2, gamePanel.tileSize*2,null);
    }
}


