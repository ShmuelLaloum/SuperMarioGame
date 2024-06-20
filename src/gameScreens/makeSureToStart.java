package gameScreens;

import levels.level;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class makeSureToStart extends JPanel {
    private static final ImageIcon playButton = new ImageIcon("src/gameResources/playButton.png");
    private static final ImageIcon threeGoldStars = new ImageIcon("src/gameResources/threeGoldStars.png");
    private static final ImageIcon threeGreyStars = new ImageIcon("src/gameResources/threeGreyStars.png");
    private static final ImageIcon backButton = new ImageIcon("src/gameResources/backButton.png");
    private static final ImageIcon background = new ImageIcon("src/gameResources/backgroundWaiting.png");
    public makeSureToStart(window window, level level){
        this.setLayout(null);
        this.setBounds(150,50,1250,750);
        this.setOpaque(false);
        Image resizedPlayImage = ImageManager.getImageIcon(ImageManager.ImageName.PLAY_BUTTON_BACKGROUND).getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);
        Image resizedBackImage = ImageManager.getImageIcon(ImageManager.ImageName.BACK_BUTTON_BACKGROUND).getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);

       /* JLabel requirements = new JLabel("level requirements :" + levelRequirements + " coins");
        requirements.setBounds(335,360,600,100);
        Font font = new Font("Algerian", Font.BOLD, 35);
        requirements.setFont(font);
        this.add(requirements);

        */

        JButton startGame = new JButton();
        startGame.setBounds(680,615,100,40);
        startGame.setOpaque(false);
        startGame.setContentAreaFilled(false);
        startGame.setBorderPainted(false);
        startGame.setFocusPainted(false);
        startGame.setIcon(new ImageIcon(resizedPlayImage));
        this.add(startGame);
        startGame.addActionListener(event -> {
            SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
            window.switchPanel(new GameFrame(level, window));
        });

        JButton back = new JButton();
        back.setBounds(430,615,100,40);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setIcon(new ImageIcon(resizedBackImage));
        this.add(back);
        back.addActionListener(event -> {
            window.switchPanel(new levelsMenu(window));
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.MAKE_SURE_TO_START_SCREEN_BACKGROUND).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}