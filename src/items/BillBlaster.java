package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class BillBlaster implements groundAble,needLandAble{
    public static final ImageIcon image = ImageManager.getImageIcon(ImageManager.ImageName.BILL_BLASTER);
    public enum directionBill{right,left}
    private int x;
    private int y;
    public static final int width = 50;
    public static final int height = 50;
    private int distance = 1;
    private int direction;
    private int ground;
    private BulletBill bullet;
    private boolean active;

    public BillBlaster(int x, int y, directionBill directionBill){
        this.x = x;
        this.y = y;
        active = true;
        direction = directionBill == BillBlaster.directionBill.right ? -1 : 1;
        bullet = new BulletBill(direction == -1 ? x+30 : x,y,directionBill);
        moveBall();
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        bullet.paint(graphics);
        g2d.drawImage(image.getImage(),x,y, width, height, null);
        g2d.dispose();
    }
    public void moveBall(){
        new Thread(()->{
            while (true){
                if (active) {
                    if (distance % 300 == 0) {
                        distance = direction == -1 ? -6 : 6;
                        bullet.setY(y);
                    }
                    distance += direction;
                    bullet.setX((direction == -1 ? x + 30 : x) - distance);
                }
                try {
                    Thread.sleep(20);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public int getX(){
        return x;
    }
    public void setX(int newX){
        x = newX;
    }
    public int getY() {
        return y;
    }
    public Rectangle upperArea() {
        Rectangle rectangle = new Rectangle(x,y,width,height/15);
        return rectangle;
    }

    @Override
    public void LandUpdate() {
        new Thread(()->{
            while (true){
                if (active) {
                    if (y < ground) {
                        y++;
                    }
                    try {
                        Thread.sleep(2);
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }
    public void setGround(int newG) {
        this.ground = newG;
    }
    public Rectangle floorSpace() {
        return new Rectangle(x+width/15,y+height ,width-width/15,height/15);
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Rectangle body(){
        return new Rectangle(x,y, width, height);
    }
    public BulletBill getBullet(){
        return bullet;
    }
    public void StopsBullet(){
        distance = direction == -1 ? -6 : 6;
        bullet.setX((direction == -1 ? x+30 : x)-distance);
    }
    public void setActive(boolean newActive){
        active = newActive;
    }
}