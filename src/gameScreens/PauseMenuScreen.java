package gameScreens;

import levels.level;
import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class PauseMenuScreen extends JPanel {
    public PauseMenuScreen(level level, window window){
        this.setOpaque(false);
        this.setLayout(null);
        Image resizedQuitGameImage = ImageManager.getImageIcon(ImageManager.ImageName.QUIT_GAME_BUTTON).getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedContinueImage = ImageManager.getImageIcon(ImageManager.ImageName.CONTINUE_BUTTON).getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);

        JButton quitGameButton = new JButton();
        quitGameButton.setBounds(660,500,180,65);
        quitGameButton.setOpaque(false);
        quitGameButton.setContentAreaFilled(false);
        quitGameButton.setBorderPainted(false);
        quitGameButton.setFocusPainted(false);
        quitGameButton.setIcon(new ImageIcon(resizedQuitGameImage));

        quitGameButton.addActionListener(event -> {
            window.switchPanel(new levelsMenu(window));
        });

        JButton continueButton = new JButton();
        continueButton.setBounds(quitGameButton.getX(),quitGameButton.getY()+97,180,65);
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setBorderPainted(false);
        continueButton.setFocusPainted(false);
        continueButton.setIcon(new ImageIcon(resizedContinueImage));

        continueButton.addActionListener(event -> {
            window.switchPanel(new GameFrame(level,window));
        });
        this.add(continueButton);
        this.add(quitGameButton);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // אופציונלי: יישום אפקט טשטוש פשוט (טשטוש מורכב דורש יותר מאמץ)
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(255, 255, 255, 128)); // לבן חצי-שקוף
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.OPTIONS_BACKGROUND).getImage(),500,200,500,550,this);
        g2d.dispose();

    }
}
