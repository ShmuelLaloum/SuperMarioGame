package gameScreens;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartScreen extends JPanel {
    private JButton startButton;
    public static final ImageIcon backgroundImage = ImageManager.getImageIcon(ImageManager.ImageName.LOGIN_SCREEN_BACKGROUND);
    public static final ImageIcon informationButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.INFORMATION_BUTTON);
    public static final ImageIcon startButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.START_BUTTON);
    private static levelsMenu levelsMenu;

    public StartScreen(window window){
        this.setLayout(null);
        levelsMenu = new levelsMenu(window);

        Image resizedImage = startButtonImage.getImage().getScaledInstance(250, 95,Image.SCALE_SMOOTH);
        Image resizedImage1 = informationButtonImage.getImage().getScaledInstance(250, 95,Image.SCALE_SMOOTH);

        startButton = new JButton(new ImageIcon(resizedImage));
        startButton.setBounds(800, 740, 250, 95);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);

        this.add(startButton);

        JButton informationButton = new JButton(new ImageIcon(resizedImage1));
        informationButton.setBounds(450, 740, 250, 95);
        informationButton.setOpaque(false);
        informationButton.setContentAreaFilled(false);
        informationButton.setBorderPainted(false);
        informationButton.setFocusPainted(false);

        this.add(informationButton);

        SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);

        startButton.addActionListener(event -> {
            window.switchPanel(levelsMenu);
        });
        informationButton.addActionListener(event -> {
            explainOfTheGame explainOfTheGame = new explainOfTheGame();
            this.add(explainOfTheGame, JLayeredPane.PALETTE_LAYER);
            this.revalidate();
            this.repaint();
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage.getImage(), 0, 0, 1540, 941, this);
    }
}