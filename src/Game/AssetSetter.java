package Game;

public class AssetSetter {

    GamePanel gp;

    AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setNPC(){
        gp.lapins[0] = new NPC_LAPIN(gp);
        gp.lapins[0].x = 125;
        gp.lapins[0].y = 125;
    }
}
