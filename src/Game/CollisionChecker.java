package Game;

public class CollisionChecker {
    GamePanel gp;
    int tmp1x,tmp1y;
    int tmp2x,tmp2y;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX =entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;
        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
//                System.out.println("Tile Num --> " + tileNum1);

                if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                if(tileNum1 == 3 || tileNum2 == 3){
                    if(entity instanceof Player)    gp.isFinished = true;

                }
                if(gp.tileManager.tiles[tileNum1].mortel || gp.tileManager.tiles[tileNum2].mortel){
                    if(entity instanceof Player){
                        ((Player) entity).personnage.mourir();
                        gp.isFinished = true;
                    }
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                System.out.println(entityLeftCol);
                System.out.println(entityBottomRow);
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
//                System.out.println("Tile Num --> " + tileNum1);

                if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
//                    System.out.println("IL Y A COLLISION");
                }
                if(gp.tileManager.tiles[tileNum1].mortel || gp.tileManager.tiles[tileNum2].mortel){
                    if(entity instanceof Player){
                        ((Player) entity).personnage.mourir();
                        gp.isFinished = true;
                    }
                }
                if(tileNum1 == 3 || tileNum2 == 3){
                    if(entity instanceof Player)    gp.isFinished = true;

                }

            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                if(tileNum1 == 3 || tileNum2 == 3){
                    if(entity instanceof Player)    gp.isFinished = true;
                }
                if(gp.tileManager.tiles[tileNum1].mortel || gp.tileManager.tiles[tileNum2].mortel){
                    if(entity instanceof Player){
                        ((Player) entity).personnage.mourir();
                        gp.isFinished = true;
                    }
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                if(tileNum1 == 3 || tileNum2 == 3){
                    if(entity instanceof Player)    gp.isFinished = true;
                }
                if(gp.tileManager.tiles[tileNum1].mortel || gp.tileManager.tiles[tileNum2].mortel){
                    if(entity instanceof Player){
                        ((Player) entity).personnage.mourir();
                        gp.isFinished = true;
                    }
                }
            }
        }
    }

    public void setNoCollisionToNPC(Entity[] target){
        for (Entity entity : target) {
            if(entity != null){
                entity.collisionOn = false;
            }
        }
    }

    //
    public int checkEntity(Entity entity,Entity[] target) {
        int index = 999;
        for(int i = 0;i < target.length;i++) {

            if (target[i] != null) {
                tmp1x = entity.solidArea.x;
                tmp1y = entity.solidArea.y;

                tmp2x = target[i].solidArea.x;
                tmp2y = target[i].solidArea.y;

                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                target[i].solidArea.x = target[i].x + target[i].solidArea.x;
                target[i].solidArea.y = target[i].y + target[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
                            target[i].collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
                            target[i].collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
                            target[i].collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        if (entity.solidArea.intersects(target[i].solidArea)) {
//                            entity.collisionOn = true;
                            target[i].collisionOn = true;
                            index = i;
                        }
                        break;
                    }
                    entity.solidArea.x = tmp1x;
                    entity.solidArea.y = tmp1y;

                    target[i].solidArea.x = tmp2x;
                    target[i].solidArea.y = tmp2y;
                    if(entity instanceof Player){
                        if (((Player) entity).getIsDialoging()) target[i].collisionOn = true;
                    }
            }
            }
        return index;
    }

    public void checkPlayer(Entity entity){
        tmp1x = gp.player.solidArea.x;
        tmp1y = gp.player.solidArea.y;

        tmp2x = entity.solidArea.x;
        tmp2y = entity.solidArea.y;

        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.x + entity.solidArea.y;

        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;

        switch (entity.direction) {
            case "up" -> {
                entity.solidArea.y -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entity.solidArea.y += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entity.solidArea.x -= entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entity.solidArea.x += entity.speed;
                if (entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
            }
        }
        gp.player.solidArea.x = tmp1x;
        gp.player.solidArea.y = tmp1y;

        entity.solidArea.x = tmp2x;
        entity.solidArea.y = tmp2y;

    }
}
