package Game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_LAPIN extends Entity{

    public NPC_LAPIN(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage(){
        try{
            run = ImageIO.read(getClass().getResourceAsStream("../Images/Run.gif"));
            stand = ImageIO.read(getClass().getResourceAsStream("../Images/Stand.png"));
        }catch (IOException e){
            e.printStackTrace();
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

