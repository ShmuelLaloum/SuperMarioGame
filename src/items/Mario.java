package items;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mario implements needLandAble{
    private int x;
    private int y;
    private int ground;
    private boolean alive;
    private boolean outOfFrame = false;
    private float clarity = 1f;
    private ImageIcon image;
    public static final ImageIcon imageMarioGoesRight = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);
    public static final ImageIcon imageMarioGoesLeft = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT);
    public static final ImageIcon imageMarioJumpsRight = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_RIGHT);
    public static final ImageIcon imageMarioJumpsLeft = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_LEFT);
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
    private volatile boolean active = false;  // מתחיל כ-false
    private Thread landUpdateThread;
    private static int heightFrame;

    public Mario(int x, int y) {
        status = options.NORMAL;
        this.x = x;
        this.y = y;
        this.alive = true;
        image = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);//imageMarioGoesRight;
    }
    public static void setHeightFrame(int newHeight){
        heightFrame = newHeight;
    }
    private void createThread() {
        landUpdateThread = new Thread(this::LandUpdate);
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
        g2d.dispose();
    }
    public void jump() {
        if (!heJumps && touchGround) {
            if (CanJump) {
                heJumps = true;
                image = image == imageMarioGoesLeft ? imageMarioJumpsLeft : imageMarioJumpsRight;
            }
            SoundManager.stopSound(SoundManager.SoundName.MARIO_JUMP);
            Thread n = new Thread(() -> {
                if (SoundManager.isPlayMusicEffect())
                    SoundManager.playSound(SoundManager.SoundName.MARIO_JUMP,-10.0f);
                int sum = 0;
                while ((sum < jumpHeight ) && heJumps) {
                    if (active) {
                        if (sum < (jumpHeight / 2) && CanJump && alive) {
                            y--;
                        } else {
                            break;
                        }
                        sum++;
                        try {
                            Thread.sleep(2);
                        } catch (Exception ignored) {
                        }
                    }
                }
                image = image == imageMarioJumpsLeft ? imageMarioGoesLeft : imageMarioGoesRight;
                heJumps = false;
                touchGround = false;
            });
            n.start();
        }
    }
    public void moveLeft(){
        if (CanGoLeft) {
            if (image != imageMarioGoesLeft){
                image = heJumps ? imageMarioJumpsLeft : imageMarioGoesLeft;
            }
        }
    }
    public void moveRight(){
        if (CanGoRight){
            if (image != imageMarioGoesRight){
                image = heJumps ? imageMarioJumpsRight : imageMarioGoesRight;
            }
        }
    }

    public void die(){
        if (SoundManager.isPlayMusicEffect())
            SoundManager.playSound(SoundManager.SoundName.MARIO_DIE);
        this.alive = false;
        Thread n = new Thread(() -> {
            int sum = 0;
            while (this.y <= heightFrame) {
                if (active) {
                    y+=2;
                    clarity = sum % 5 == 0 ? 1f : 0.5f;
                    try {
                        Thread.sleep(5);
                    } catch (Exception ignored) {
                    }
                    sum++;
                }
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
    }
    public void setCanGoRight(boolean newCanGoRight) {
        this.CanGoRight = newCanGoRight;
    }
    public boolean isCanGoRight(){
        return CanGoRight;
    }
    public void setCanGoLeft(boolean newCanGoLeft) {
        this.CanGoLeft = newCanGoLeft;
    }
    public boolean isCanGoLeft(){
        return CanGoLeft;
    }
    public void LandUpdate(){
        boolean k = false;
        while (isAlive() && active){
            if (!heJumps && y < ground) {
                if (!k)
                    image = image == imageMarioGoesLeft ? imageMarioJumpsLeft : image == imageMarioGoesRight ? imageMarioJumpsRight : image;
                y++;
                k = true;
            } else if (k) {
                image = image == imageMarioJumpsLeft ? imageMarioGoesLeft : image == imageMarioJumpsRight ? imageMarioGoesRight : image;
                k = false;
            }

            try {
                Thread.sleep(3);
            } catch (Exception e) {
            }
        }
    }
    public Rectangle body(){
        return new Rectangle(x,y,width,height);
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
    public synchronized void setActive(boolean newActive) {
        if (newActive && !active) {
            active = true;
            createThread();
            landUpdateThread.start();
        } else if (!newActive && active) {
            active = false;
            landUpdateThread.interrupt();
        }
    }
    public  void setAlive(boolean nweAlive){
        alive = nweAlive;
    }

}