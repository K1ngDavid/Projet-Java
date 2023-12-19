package Game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Monster extends Entity{
    public String name;

    public Monster(GamePanel gp,String name){
        super(gp);
        this.gp = gp;
        this.name=name;
        speed = 1;
        maxLife = 4;
        life = maxLife;
        getImage();
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
    }
    public void getImage()  {
        try {
            run = ImageIO.read(getClass().getResourceAsStream("../Images/Run.gif"));
            stand = ImageIO.read(getClass().getResourceAsStream("../Images/Stand.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction= "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75){
                direction = "right";
            }
        }
        actionLockCounter = 0;

    }
}

