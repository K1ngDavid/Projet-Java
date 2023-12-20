package Game;

import Game.Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 21;
    public final int maxScreenRow = 15;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    public boolean isFinished = false;
    transient KeyHandler keyH = new KeyHandler();
    public transient Thread gameThread;
    public transient Monster monster = new Monster(this,"monster");
    public transient Entity lapins[] = new Entity[5];
    transient CollisionChecker cChecker = new CollisionChecker(this);
    public transient Player player = new Player(this,keyH,"../Images/Run.gif","../Images/Stand.png");

    public final int maxWorldCol = 50;
    transient AssetSetter aSetter = new AssetSetter(this);
    public final int maxWorldRow = 50;
    public final int worldWith = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    // Set player's default position
    int playerX = 100;
    int playerY = 500;
    int playerSpeed = 4;
    int FPS = 60;
    transient TileManager tileManager = new TileManager(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGameThread(){
        gameThread.interrupt();
        gameThread = null;
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){
            System.out.println(drawInterval);
            update();

            repaint();
            if(this.gameThread !=null){
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }
        }
    }

    public void setUpGame(){
        aSetter.setNPC();
    }

    public void update(){
        player.update();
        for(int i = 0; i < lapins.length;i++){
            if(lapins[i] != null){
                lapins[i].update();
            }
        }
        monster.update();
        if(isFinished){
            System.out.println("FINIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            JOptionPane.showMessageDialog(null,"Vous pouvez desormais passer à la suite en cliquant sur 'Suivant'","BRAVO !",JOptionPane.INFORMATION_MESSAGE);
            this.stopGameThread();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
//        for(int i = 0;i< lapins.length;i++){
//            if(lapins[i] != null){
//                lapins[i].draw(g2);
//            }
//        }

        player.draw(g2);

        g2.dispose();
    }
}
