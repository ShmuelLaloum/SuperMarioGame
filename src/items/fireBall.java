package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class fireBall {
    public static final ImageIcon imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.FIRE_BALL);
    private int x;
    private int y;
    public static final int width = 10;
    public static final int height = 10;
    private boolean change = false;
    public fireBall(int x,int y){
        this.x = x;
        this.y = y;
        j();
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(), x, y, width, height, null);
        g2d.dispose();
    }
    public void shoot(){
        new Thread(()->{
            int sum = 1;
            int g = 1;
            int f= 1;
            while (sum < 200){
                if (change){
                    change = false;
                    f*=-1;
                }
                x+=f;
                if (sum%20 == 0){
                    g *=-1;
                }
                y+=g;
                sum++;
                try {
                    Thread.sleep(5);
                }catch (Exception e){

                }
            }
            y = -10;

        }).start();
    }
    public void j(){
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public Rectangle body(){
        Rectangle rectangle = new Rectangle(x,y,width,height);
        return rectangle;
    }
}