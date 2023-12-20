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

        gp.lapins[1] = new NPC_LAPIN(gp);
        gp.lapins[1].x = 325;
        gp.lapins[1].y = 525;

        gp.lapins[2] = new NPC_LAPIN(gp);
        gp.lapins[2].x = 500;
        gp.lapins[2].y = 200;
    }
}
