package Game;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + entity.solidArea.x;
        int entityRightWorldX = entity.getWorldX() + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.getWorldY() + entity.solidArea.y;
        int entityBottomWorldY = entity.getWorldY() + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

//        switch (entity.direction) {
//            case "up" -> {
//                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
//
//                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
//                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
//
//                if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision) {
//                    entity.collisionOn = true;
//                }
//            }
//            case "down" -> {
//
//            }
//            case "left" -> {
//
//            }
//            case "right" -> {
//
//            }
//        }
    }

}
