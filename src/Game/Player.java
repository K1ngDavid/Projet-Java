package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    public int x,y;
    public boolean isMooving = false;
    GamePanel gamePanel;
    KeyHandler keyH;
    public BufferedImage run, stand;

    public Player(GamePanel gamePanel, KeyHandler keyH){
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        isMooving = false;
        if(keyH.upPressed){
            y -= speed;
            isMooving = true;
        } else if (keyH.downPressed) {
            y  += speed;
            isMooving = true;
        } else if (keyH.leftPressed){
            x -= speed;
            isMooving = true;
        } else if (keyH.rightPressed) {
            x += speed;
            isMooving = true;
        }
    }

    public void getPlayerImage(){
        try{
            run = ImageIO.read(getClass().getResourceAsStream("../Images/Run.gif"));
            stand = ImageIO.read(getClass().getResourceAsStream("../Images/Stand.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        BufferedImage image = null;
        if(isMooving){
            image = run;
        }else{
            image = stand;
        }
        g2.drawImage(image,x,y, gamePanel.tileSize * 2, gamePanel.tileSize*2,null);
    }
}

