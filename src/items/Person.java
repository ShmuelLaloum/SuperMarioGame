package items;

import gameScreens.GameFrame;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Person implements needLandAble,Cloneable{
    private int x;
    private int y;
    private int ground;
    private boolean alive;
    private boolean outOfFrame = false;
    private float clarity = 1f;
    private ImageIcon image;
    public static final ImageIcon imageMarioGoesRight = new ImageIcon("src/gameResources/MarioGoesRight.png");
    public static final ImageIcon imageMarioGoesLeft = new ImageIcon("src/gameResources/MarioGoesLeft.png");
    public static final ImageIcon imageMarioJumpsRight = new ImageIcon("src/gameResources/MarioJumpsRight.png");
    public static final ImageIcon imageMarioJumpsLeft = new ImageIcon("src/gameResources/MarioJumpsLeft.png");
    public static final int jumpHeight = 200;
    public static final int walkingDistance = 5;
    private int width = 30;
    private int height = 30;
    private boolean heJumps = false;
    private ArrayList<fireBall> fireBalls = new ArrayList<>();
    public enum options{NORMAL,BigBody}
    private options status;
    private boolean touchGround = false;
    private boolean CanGoLeft = true,CanGoRight = true,CanJump= true;

    public Person(int x, int y) {
        status = options.NORMAL;
        this.x = x;
        this.y = y;
        this.alive = true;
        image = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);//imageMarioGoesRight;
        //updateGroundBasedOnClosestCube();
        LandUpdate();


    }
    public void setGround(int newY){
        this.ground = newY;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setY(int newY){
        y= newY;
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        float alpha = clarity;
        AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(composite);
        g2d.drawImage(image.getImage(), x, y, width, height, null);

        for (fireBall fireBall : fireBalls){
            fireBall.paint(graphics);
        }
        g2d.dispose();
    }
    public void jump() {
        if (!heJumps && touchGround) {
            if (CanJump) {
                heJumps = true;
                image = image == ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT) ? ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_LEFT) : ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_RIGHT);
            }
            SoundManager.stopSound(SoundManager.SoundName.MARIO_JUMP);
            Thread n = new Thread(() -> {
                SoundManager.playSound(SoundManager.SoundName.MARIO_JUMP,-10.0f);
                int sum = 0;
                while ((sum < jumpHeight )) {
                    if (sum < (jumpHeight / 2) && CanJump && alive) {
                        y--;
                    }else {
                        /*if (y < ground) {
                            y++;
                        } else {
                            break;
                        }*/
                        break;

                    }
                    sum++;
                    try {
                        Thread.sleep(2);
                    } catch (Exception ignored) {
                    }
                }
                image = image == ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_LEFT) ? ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT) : ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);;
                heJumps = false;
                touchGround = false;


                //m = false;
            });
            n.start();
        }
    }
    public void moveLeft(){
        if (CanGoLeft /*&& x-walkingDistance > walkingDistance*2*/) {
            if (image != ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT)){
                image = heJumps ? ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_LEFT) : ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT);
            }
            //this.x -= walkingDistance;
            //s1.moveScreen(walkingDistance);
        }
    }
    public void moveRight(){
        if (CanGoRight){
            if (image != ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT)){
                image = heJumps ? ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_RIGHT) : ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);
            }
            //this.x+=walkingDistance;
            //s1.moveScreen(-walkingDistance);
        }

    }

    public void die(int heightFrame){
        SoundManager.playSound(SoundManager.SoundName.MARIO_DIE);
        this.alive = false;
        Thread n = new Thread(() -> {
            int sum = 0;
            while (this.y <= heightFrame){
                y++;
                clarity =  sum%5 == 0 ? 1f : 0.5f;
                try {
                    Thread.sleep(120);
                } catch (Exception ignored) {
                }
                sum++;
            }
            outOfFrame = true;
        });
        n.start();

    }
    public boolean isAlive(){
        return alive;
    }
    public boolean isOutOfFrame(){
        return outOfFrame;
    }

    public Rectangle floorSpace(){
        return new Rectangle(x+width/15,y+height ,width-width/15,height/15);
    }
    public Rectangle ceilingArea(){
        return new Rectangle(x+width/15,y-height/15 ,width-width/15,height/15);
    }
    public Rectangle rightField(){
        return new Rectangle(x+width+walkingDistance,y ,width/15,height);
    }
    public Rectangle leftField(){
        return new Rectangle(x-walkingDistance-1,y,width/15,height);
    }
    public int getHeight(){
        return height;
    }
    public void setCanJump(boolean newCanJump) {
        this.CanJump = newCanJump;
        /*for (items.groundAble c : allCubes) {
            if (ceilingArea().intersects(c.body()))
                return true;
        }
        return false;

         */
    }
    public boolean isCanJump(){
        return CanJump;
    }
    public void setCanGoRight(boolean newCanGoRight) {
        this.CanGoRight = newCanGoRight;
        /*for (items.groundAble c : allCubes) {
            if (rightField().intersects(c.body()))
                return true;
        }
        return false;

         */
    }
    public boolean isCanGoRight(){
        return CanGoRight;
    }
    public void setCanGoLeft(boolean newCanGoLeft) {
        this.CanGoLeft = newCanGoLeft;
        /*for (items.groundAble c : allCubes) {
            if (leftField().intersects(c.body()))
                return true;
        }
        return false;

         */
    }
    public boolean isCanGoLeft(){
        return CanGoLeft;
    }
    public int getGround(){
        return ground;
    }
    private void updateGroundBasedOnClosestCube() {
        /*new Thread(()->{
            while (true){
        items.Cube closestCube = null;
        int closestDistance = Integer.MAX_VALUE;

        for (items.Cube c : allCubes) {
            Rectangle upperArea = c.upperArea();
            Rectangle floorSpace = this.floorSpace();

            int distanceX = Math.abs(upperArea.x - floorSpace.x);
            int distanceY = upperArea.y - floorSpace.y >= 0 ? upperArea.y - floorSpace.y : Integer.MAX_VALUE;

            if (distanceX < 25 && distanceY < closestDistance) {
                closestCube = c;
                closestDistance = distanceY;
            }
        }

        if (closestCube != null) {
            this.setGround(closestCube.getY() - this.getHeight());
        }
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {
        }
    }
}).start();

         */
    }
    public void LandUpdate(){
        new Thread(()->{
            boolean k = false;
            while (isAlive()){
                if (!heJumps && y < ground){
                    if (!k)
                        image = image == imageMarioGoesLeft ? imageMarioJumpsLeft : image == imageMarioGoesRight ?imageMarioJumpsRight : image;
                    y++;
                    k = true;
                    touchGround = false;
                }else if (k){
                    image = image == imageMarioJumpsLeft ? imageMarioGoesLeft : image == imageMarioJumpsRight ? imageMarioGoesRight : image;
                    k = false;
                    touchGround = true;
                }
                try {
                    Thread.sleep(3);
                }catch (Exception e){
                }
            }
        }).start();
    }

    public Rectangle body(){
        return new Rectangle(x,y,width,height);
    }
    public void setFireBalls(ArrayList<fireBall> fireBalls){
        this.fireBalls = fireBalls;
    }

    public void shoot(){
        fireBalls.add(new fireBall(Math.min(x , Window.WIDTH / 2),y));
        fireBalls.getLast().shoot();
    }
    public int getWidth(){
        return width;
    }
    public void setHeJumps(boolean newHeJumps){
        heJumps = newHeJumps;
    }
    public boolean getHeJumps(){
        return heJumps;
    }
    public boolean isTouchGround(){
        return touchGround;
    }
    public void setTouchGround(boolean newT){
        touchGround = newT;
    }
    public void bodyGrows(){
        status = options.BigBody;
        y-=15;
        width = 35;
        height = 45;
    }
    public void normalBody(){
        status = options.NORMAL;
        y+=15;
        width = 30;
        height = 30;
    }
    public options getStatus(){
        return status;
    }
    public Person clone() throws CloneNotSupportedException{
        return (Person)super.clone();
    }

}