package gameScreens;

import levels.*;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class endLevelScreen extends JPanel {
    public enum Status {PASS,FAIL}
    private window window;
    private ImageIcon imageBackground;
    public endLevelScreen(Status status, level level, window window){
        SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC);
        this.window = window;
        imageBackground = status == Status.PASS ? ImageManager.getImageIcon(ImageManager.ImageName.LEVEL_COMPLETE_BACKGROUND) : ImageManager.getImageIcon(ImageManager.ImageName.GAME_OVER_BACKGROUND);
        Image resizedLevelsImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVELS_BUTTON).getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedNextLeveImage = ImageManager.getImageIcon(ImageManager.ImageName.NEXT_LEVEL_BUTTON).getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedRetryLevelButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.RETRY_LEVEL_BUTTON).getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        this.setLayout(null);

        if (!levelsMenu.isLevelIsComplete(level)) {
            levelsMenu.setLevelIsComplete(level,status == Status.PASS);
        }
        JButton levelsButton = new JButton();
        JButton retryLevelButton = new JButton();
        JButton nextLevelButton = new JButton();



        levelsButton.setBounds(600,800,180,65);
        levelsButton.setOpaque(false);
        levelsButton.setContentAreaFilled(false);
        levelsButton.setBorderPainted(false);
        levelsButton.setFocusPainted(false);
        levelsButton.setIcon(new ImageIcon(resizedLevelsImage));
        levelsButton.addActionListener(event -> {
            window.switchPanel(new levelsMenu(window));
        });

        retryLevelButton.setBounds(600,levelsButton.getY()-70,180,65);
        retryLevelButton.setOpaque(false);
        retryLevelButton.setContentAreaFilled(false);
        retryLevelButton.setBorderPainted(false);
        retryLevelButton.setFocusPainted(false);
        retryLevelButton.setIcon(new ImageIcon(resizedRetryLevelButtonImage));
        retryLevelButton.addActionListener(event -> {
            SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC);
            window.switchPanel(new GameFrame(levelsMenu.resetLevel(level),window));
        });

        if (levelsMenu.getNextLevel(level) != null && levelsMenu.isLevelIsComplete(level)) {
            nextLevelButton.setBounds(600, retryLevelButton.getY() - 70, 180, 65);
            nextLevelButton.setOpaque(false);
            nextLevelButton.setContentAreaFilled(false);
            nextLevelButton.setBorderPainted(false);
            nextLevelButton.setFocusPainted(false);
            nextLevelButton.setIcon(new ImageIcon(resizedNextLeveImage));
            nextLevelButton.addActionListener(event -> {
                SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC);
                window.switchPanel(new GameFrame(levelsMenu.getNextLevel(level),window));
            });
            this.add(nextLevelButton);
        }

        this.add(levelsButton);
        this.add(retryLevelButton);
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(imageBackground.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
