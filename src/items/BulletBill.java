package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class BulletBill implements enemyAble {
    public static final ImageIcon imageIconGoRight = ImageManager.getImageIcon(ImageManager.ImageName.BULLET_BILL_GO_RIGHT);
    public static final ImageIcon imageIconGoLeft = ImageManager.getImageIcon(ImageManager.ImageName.BULLET_BILL_GO_LEFT);
    private ImageIcon imageIconHead;
    private int x;
    private int y;
    public static final int width = 35;
    public static final int height = 25;

    public BulletBill(int x, int y, BillBlaster.directionBill directionBill) {
        imageIconHead = directionBill == BillBlaster.directionBill.right ? imageIconGoRight : imageIconGoLeft;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIconHead.getImage(), x, y, width, height, null);
        g2d.dispose();
    }

    public Rectangle body() {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        return rectangle;
    }

    public Rectangle ceilingArea() {
        return new Rectangle(x + width / 15, y - height / 15, width - width / 15, height / 15);
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getX() {
        return x;
    }

    public void setY(int newY) {
        y = newY;
    }

    public int getY() {
        return y;
    }
}