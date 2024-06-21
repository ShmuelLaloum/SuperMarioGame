package gameScreens;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    private static StartScreen startScreen;
    public static final ImageIcon logoImage = ImageManager.getImageIcon(ImageManager.ImageName.LOGO);

    public window(){
        this.setTitle("Super Mario Game");
        this.setIconImage(logoImage.getImage());
        this.setLayout(new BorderLayout());
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        startScreen = new StartScreen(this);
        switchPanel(startScreen);

        this.setVisible(true);
    }
    public void switchPanel(JPanel newPanel) {
        this.getContentPane().removeAll();
        this.add(newPanel);
        this.revalidate();
        this.repaint();
        newPanel.requestFocusInWindow();
    }
    public void switchPanel( JLayeredPane newPanel) {
        this.getContentPane().removeAll();
        this.add(newPanel);
        this.revalidate();
        this.repaint();
        newPanel.requestFocusInWindow();
    }
}