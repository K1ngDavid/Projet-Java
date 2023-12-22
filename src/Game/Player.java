package Game;

import Univers.Personnage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Classe du joueur
 * @author David Roufé
 */
public class Player extends Entity{
    transient GamePanel gamePanel;
    transient KeyHandler keyH;
    public Personnage personnage;
    public String runString = "../Images/Run.gif";
    public String standString = "../Images/Stand.png";
    private boolean isDialoging = false;
    private String dialogue = "Te revoila ! Pour passer cette épreuve, tu dois atteindre la boite noire sans \n toucher aux morceaux de volcan";

    public boolean getIsDialoging(){
        return this.isDialoging;
    }

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
        maxLife = personnage.getPointDeVie();
        getPlayerImage();
    }

    public Player(GamePanel gamePanel, KeyHandler keyH, String run, String stand){
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        isMooving = false;
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

        int index = gp.cChecker.checkEntity(this,gp.lapins);
        interactNPC(index);

        if(!isDialoging){
            gamePanel.cChecker.setNoCollisionToNPC(gamePanel.lapins);
        }

        if(!collisionOn && isMooving){
            switch (direction) {
                case "up" -> y -= speed;
                case "down" -> y += speed;
                case "left" -> x -= speed;
                case "right" -> x += speed;
            }
        }
    }

    public void getPlayerImage() {
        try {
            if (this.personnage != null) {
                String imagePath = personnage.getImagePersonnage();
                System.out.println("L'image path -->" + imagePath);
                URL imageURL = Paths.get(imagePath).toUri().toURL();
                System.out.println(imageURL);

                run = ImageIO.read(imageURL);
                stand = ImageIO.read(imageURL);
            } else {
                run = ImageIO.read(getClass().getResourceAsStream(runString));
                stand = ImageIO.read(getClass().getResourceAsStream(standString));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void interactNPC(int i){
        if(i != 999){
            isDialoging = true;
        }else {
            isDialoging = false;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        image = null;
        if(isMooving){
            image = run;
        }else{
            image = stand;
        }
        g2.drawImage(image,x,y, gamePanel.tileSize * 2, gamePanel.tileSize*2,null);
        if(isDialoging){
            Color c = new Color(0,0,0);
            g2.setColor(c);
            g2.fillRoundRect(gp.tileSize *2,gp.tileSize/2,gp.screenWidth -(gp.tileSize*4),gp.tileSize*2,35,35);
            g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.WHITE);
            int y = 5;
            for(String line : dialogue.split("\n")){
                g2.drawString(line,gp.tileSize *2,gp.tileSize + y);
                y +=40;
            }
        }
    }
}


