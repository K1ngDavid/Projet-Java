package Game;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_LAPIN extends Entity{

    public NPC_LAPIN(GamePanel gp){
        super(gp);
//        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage(){
        try{
            run = ImageIO.read(getClass().getResourceAsStream("../Images/gif_w_nb.gif"));
            stand = ImageIO.read(getClass().getResourceAsStream("../Images/gif_w_nb.gif"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAction(){
        actionLockCounter++;
        isMooving = false;
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
            actionLockCounter = 0;
            isMooving = true;
        }

    }
}

