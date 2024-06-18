package gameScreens;
import levels.level1;
import levels.level5;

import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    public window(){
        this.setLayout(new BorderLayout());
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        StartScreen startScreen = new StartScreen(this);
        switchPanel(startScreen);

        //switchPanel(new GameFrame(new level1(),this));
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