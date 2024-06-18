package gameScreens;

import items.*;
import levels.level;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JPanel {
    private int collectedCoins = 0;
    public static final ImageIcon backgroundImage = new ImageIcon("src/gameResources/sky2.jpg");
    private int imageX = 0;
    private int startPoint;
    private int endPoint;
    private ArrayList<enemyAble> enemyAbles = new ArrayList<>();
    private ArrayList<groundAble> groundAbles = new ArrayList<>();
    private ArrayList<needLandAble> needLandAbles = new ArrayList<>();
    private ArrayList<mushroom> mushrooms =  new ArrayList<>();
    private List<Coin> coins = new ArrayList<>();
    private List<bigTube> bigTubes = new ArrayList<>();
    private List<BillBlaster> billBlasters = new ArrayList<>();
    private List<Cube> cubes = new ArrayList<>();
    private List<goomba> goombas = new ArrayList<>();
    private List<luckyCube> luckyCubes = new ArrayList<>();
    private List<brokenCube> brokenCubes = new ArrayList<>();
    private List<PenGoalPole> penGoalPoles = new ArrayList<>();
    private List<castle> castles = new ArrayList<>();
    private Person mario;
    private Controller controller;
    private final level levelX;
    private final window window;
    private boolean stop = false;
    private PauseMenuScreen pauseMenu;
    public GameFrame(level level, window window) {
        SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC,-10.0f);
        //this.setFocusable(true);
        this.levelX = level;
        this.window = window;
        setupGameObjects();

        int delay = 50;
        Timer timer = new Timer(delay, e -> {
            imageX++;
            if (imageX >= getWidth()) {
                imageX = 0;
            }
        });
        timer.start();
        this.controller = new Controller(mario,this);
        this.addKeyListener(controller);
        this.mainGameLoop();
        //this.add(new PauseMenuScreen(levelX,window));
        this.setLayout(null);
        JButton pauseButton = new JButton("Pause");
        pauseButton.setBounds(500,90,50,50);
        pauseButton.addActionListener(e ->{
            this.setLayout(new BorderLayout());
            pauseMenu = new PauseMenuScreen(levelX,window);
            stop = true;
            this.add(pauseMenu);
            this.revalidate();
            this.repaint();
            this.remove(pauseButton);
        });
        this.add(pauseButton);


    }
    private void setupGameObjects(){
        this.mario = levelX.getMario();
        this.penGoalPoles = levelX.getPenGoalPoles();
        this.cubes = levelX.getCubes();
        this.coins = levelX.getCoins();
        this.goombas = levelX.getGoombas();
        this.brokenCubes = levelX.getBrokenCubes();
        this.luckyCubes = levelX.getLuckyCubes();
        this.billBlasters = levelX.getBillBlasters();
        this.bigTubes = levelX.getBigTubes();
        this.castles = levelX.getCastles();

        groundAbles.addAll(cubes);
        groundAbles.addAll(brokenCubes);
        groundAbles.addAll(luckyCubes);
        groundAbles.addAll(bigTubes);
        groundAbles.addAll(billBlasters);

        needLandAbles.addAll(billBlasters);
        needLandAbles.addAll(goombas);
        needLandAbles.addAll(penGoalPoles);
        needLandAbles.addAll(castles);

        enemyAbles.addAll(goombas);
        for (BillBlaster b : billBlasters)
            enemyAbles.add(b.getBullet());
        for (bigTube b : bigTubes)
            if (b.getStatus() == bigTube.type.enemy)
                enemyAbles.add(b.getCarnivorousPlant());

        needLandAbles.add(mario);
        startPoint = levelX.getStartPointX();
        endPoint = levelX.getEndPointX();

    }
    public void mainGameLoop(){
        new Thread(() -> {
            while (!mario.isOutOfFrame() &&  mario.getX() < (endPoint-mario.getWidth())) {
                if (!stop) {
                    updateGameObjects();
                    this.repaint();
                }
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.controller.setActive(false);
            SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC);
            window.switchPanel(new endLevelScreen((mario.isAlive() && collectedCoins >= levelX.getCoinsRequired() ? endLevelScreen.Status.PASS : endLevelScreen.Status.FAIL),levelX,window));
        }).start();
    }
    public synchronized void updateGameObjects() {
        boolean canJump = true;
        boolean canGoLeft = true;
        boolean canGoRight = true;

        for (int i = 0 ; i < groundAbles.size(); i++) {
            if (canJump && collision(mario.ceilingArea(), groundAbles.get(i).body())) {
                canJump = false;
            }
            if (canGoLeft && collision(mario.leftField(), groundAbles.get(i).body())) {
                canGoLeft = false;
            }
            if (canGoRight && collision(mario.rightField(), groundAbles.get(i).body())) {
                canGoRight = false;
            }
        }
        mario.setCanGoRight(canGoRight);
        mario.setCanGoLeft(canGoLeft);
        mario.setCanJump(canJump);



        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).isFinishedCollecting()) {
                collectedCoins++;
                coins.remove(i--);
            } else if (!coins.get(i).isStartCollected() && collision(mario.body(), coins.get(i).body())) {
                coins.get(i).collected();
            }
        }


        for (luckyCube l : luckyCubes){
            if (!l.isTaken() && collision(mario.ceilingArea(), l.floorSpace())) {
                Object c = l.hasTaken();
                if (c instanceof Coin) {
                    coins.add((Coin) c);
                    ((Coin) c).collected();
                } else if (c instanceof mushroom m) {
                    needLandAbles.add(m);
                    mushrooms.add(m);
                }
            }
        }

        for (mushroom m : mushrooms) {
            for (groundAble groundAble : groundAbles) {
                if (collision(m.body(), groundAble.body())) {
                    m.ChangeDirection();
                }
            }
        }

        for (mushroom m : mushrooms){
            if (collision(mario.body(), m.body())) {
                SoundManager.playSound(SoundManager.SoundName.MARIO_EAT_MUSHROOM);
                mario.bodyGrows();
                needLandAbles.remove(m);
                mushrooms.remove(m);
                break;
            }
        }

        for (int i = 0; i < goombas.size() ; i++) {
            if (!goombas.get(i).isAlive()){
                needLandAbles.remove(goombas.get(i));
                enemyAbles.remove(goombas.get(i));
                goombas.remove(i--);
            }else if (collision(mario.floorSpace(), goombas.get(i).ceilingArea())) {
                mario.setHeJumps(false);
                mario.setTouchGround(true);
                mario.jump();
                goombas.get(i).die();
            }
        }
        for (goomba goomba : goombas) {
            for (groundAble groundAble : groundAbles) {
                if (collision(goomba.body(), groundAble.body())) {
                    goomba.ChangeDirection();
                }
            }
        }

        for (BillBlaster b : billBlasters){
            if (collision(mario.floorSpace(), b.getBullet().ceilingArea())) {
                b.StopsBullet();
                mario.setHeJumps(false);
                mario.setTouchGround(true);
                mario.jump();
            }
        }

        for (int i = 0; i < enemyAbles.size(); i++) {
            if (collision(enemyAbles.get(i).body(), mario.body())) {
                if (mario.getStatus() == Person.options.NORMAL) {
                    mario.die(getHeight());
                    this.controller.setActive(false);
                } else {
                    mario.normalBody();
                    if (enemyAbles.get(i) instanceof goomba) {
                        goombas.remove((goomba) enemyAbles.get(i));
                        needLandAbles.remove((goomba)enemyAbles.get(i));
                        enemyAbles.remove(i--);
                    } else if (enemyAbles.get(i) instanceof BulletBill) {
                        for (BillBlaster b : billBlasters)
                            if (b.getBullet() == enemyAbles.get(i)){
                                b.StopsBullet();
                                break;
                            }

                    }else {
                        for (bigTube b : bigTubes)
                            if (b.getCarnivorousPlant() == enemyAbles.get(i)){
                                b.takeDown();
                                break;
                            }
                    }
                }
            }
        }

        for (int i = 0; i < brokenCubes.size(); i++) {
            if (collision(mario.ceilingArea(), brokenCubes.get(i).floorSpace()) && mario.getStatus() == Person.options.BigBody && mario.getHeJumps()) {
                groundAbles.remove(brokenCubes.remove(i));
                break;
            }
        }

        for (needLandAble needLandAble : needLandAbles) {
            if (needLandAble instanceof Person) {
                mario.setTouchGround(false);
            }
            groundAble closestCube = null;
            int closestDistance = Integer.MAX_VALUE;
            for (groundAble c : groundAbles) {
                Rectangle upperArea = c.upperArea();
                Rectangle floorSpace = needLandAble.floorSpace();

                int distanceX = Math.abs(upperArea.x - floorSpace.x);
                int distanceY = upperArea.y - floorSpace.y >= -1 ? upperArea.y - floorSpace.y : Integer.MAX_VALUE;

                if (collision(needLandAble.floorSpace(), c.upperArea()) || distanceX < needLandAble.getWidth() && distanceY < closestDistance) {
                    if (collision(needLandAble.floorSpace(), c.upperArea()) && needLandAble instanceof Person) {
                        mario.setTouchGround(true);
                    }
                    closestCube = c;
                    closestDistance = distanceY;
                }
            }

            if (closestCube != null) {
                needLandAble.setGround(closestCube.getY() - needLandAble.getHeight());
            }
        }
    }
    public boolean collision(Rectangle rect1, Rectangle rect2) {
        return rect1.intersects(rect2);
    }

    public synchronized void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.LEVEL1_BACKGROUND).getImage(), -imageX, 0, getWidth(), getHeight(), this);
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.LEVEL1_BACKGROUND).getImage(), getWidth() - imageX, 0, getWidth(), getHeight(), this);
        g2d.drawImage(Coin.imageIcon.getImage(), getWidth() - Coin.width * 2, Coin.height, Coin.width, Coin.height, this);
        g2d.setFont(new Font("Arial", Font.BOLD, 35));
        g2d.setColor(Color.yellow);
        g2d.drawString(collectedCoins + "*", getWidth() - Coin.width * 2 - 35, Coin.height * 2);
        g2d.dispose();

        for (Coin c : coins)
            c.paint(graphics);

        for (Cube c : cubes)
            c.paint(graphics);

        for (goomba goomba : goombas)
            goomba.paint(graphics);

        for (mushroom m : mushrooms)
            m.paint(graphics);

        for (brokenCube b : brokenCubes)
            b.paint(graphics);

        for (bigTube b : bigTubes)
            b.paint(graphics);

        for (BillBlaster b : billBlasters)
            b.paint(graphics);
        for (luckyCube l : luckyCubes)
            l.paint(graphics);
        for (PenGoalPole p : penGoalPoles)
            p.paint(graphics);
        for (castle c : castles)
            c.paint(graphics);

        mario.paint(graphics);
    }

    public void moveScreen(int distance) {
        boolean n = false;
        boolean j = false;
        int screenWidth = getWidth();
        boolean inFirstHalf = (mario.getX() - startPoint) <= screenWidth;
        boolean inLastHalf = (endPoint - mario.getX()) <= screenWidth;

        if ((startPoint + distance) <= 0 && (endPoint + distance) >= 0) {
            if (inLastHalf || inFirstHalf) {
                if ((mario.getX() + mario.getWidth() * 2 - distance) <= endPoint) {
                    mario.setX(mario.getX() - distance);
                    n = true;
                    j = true;
                }
            }
        }

        if (!n) {
            distance *= 2;
        }
        if ((startPoint + distance) <= 0 && (endPoint - getWidth() + distance) >= 0) {
            for (Cube cube : cubes)
                cube.setX(cube.getX() + distance);
            for (Coin coin : coins) {
                if (!coin.isStartCollected())
                    coin.setX(coin.getX() + distance);
            }
            for (luckyCube l : luckyCubes)
                l.setX(l.getX() + distance);

            for (goomba goomba : goombas)
                goomba.setX(goomba.getX() + distance);

            for (mushroom m : mushrooms)
                m.setX(m.getX() + distance);

            for (brokenCube b : brokenCubes)
                b.setX(b.getX() + distance);

            for (bigTube b : bigTubes)
                b.setX(b.getX() + distance);

            for (BillBlaster b : billBlasters) {
                b.setX(b.getX() + distance);
                b.getBullet().setX(b.getBullet().getX() + distance);
            }
            for (PenGoalPole p : penGoalPoles)
                p.setX(p.getX() + distance);
            for (castle c : castles)
                c.setX(c.getX() + distance);
            j = true;
        }
        if (j) {
            startPoint += distance;
            endPoint += distance;
        }
    }
    private void showPauseMenu() {
        // עצירת הלולאה הראשית של המשחק
        stop = true;

        // הסרת המאזין לקלטים

        // הוספת מחלקת העצירה למסך
        this.add(pauseMenu);

        // הסרת כל הקומפוננטות האחרות של GameFrame

        // עדכון המסך
        this.revalidate();
        this.repaint();
    }

}