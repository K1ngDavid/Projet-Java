package Game.Tile;

import Game.GamePanel;
import Game.Monster;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int mapTileNum[][];

    public  TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
//        loadMap("../maps/map01.txt");
        loadRandomMap();
    }

    public void getTileImage(){
        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("../../Images/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("../../Images/wall.png"));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("../../Images/water.png"));
            tiles[2].collision = true;

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("../../Images/portal.png"));
            tiles[3].collision = false;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col< gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
                String line = br.readLine();
                while (col < gamePanel.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gamePanel.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setMonster(){
        gamePanel.monster = new Monster(gamePanel,"Méchant");
        gamePanel.monster.worldX = gamePanel.tileSize * 5;
        gamePanel.monster.worldY = gamePanel.tileSize * 5;

    }

    public  void loadRandomMap(){
        // Définir les limites de la carte avec des collisions
        for (int i = 0; i < gamePanel.maxScreenCol; i++) {
            mapTileNum[i][0] = 1; // Bord gauche
            mapTileNum[i][gamePanel.maxScreenRow - 1] = 1; // Bord droit
        }

        for (int j = 0; j < gamePanel.maxScreenRow; j++) {
            mapTileNum[0][j] = 1; // Bord supérieur
            mapTileNum[gamePanel.maxScreenCol - 1][j] = 1; // Bord inférieur
        }

        boolean specialValueAdded = false;

        for (int i = 1; i < gamePanel.maxScreenCol - 1; i++) {
            for (int j = 1; j < gamePanel.maxScreenRow - 1; j++) {
                // Ajouter la valeur 3 une fois et seulement une fois
                if (!specialValueAdded && Math.random() < 0.01) {
                    mapTileNum[i][j] = 3;
                    specialValueAdded = true;
                } else {
                    // Remplir l'intérieur de la carte avec des valeurs aléatoires (0, 1, ou 2)
                    mapTileNum[i][j] = (int) (Math.random() * 3);

                    // Assurer que le joueur peut se déplacer librement
                    if (i % 2 == 0 || j % 2 == 0) {
                        mapTileNum[i][j] = 0; // Emplacements pairs pour permettre au joueur de se déplacer
                    }
                }
            }
        }
    }

    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col< gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tiles[tileNum].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
            col++;
            x+= gamePanel.tileSize;

            if (col == gamePanel.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }
    }
}
