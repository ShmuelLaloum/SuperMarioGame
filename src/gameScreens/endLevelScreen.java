package gameScreens;

import levels.*;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class endLevelScreen extends JPanel {
    public enum Status {PASS,FAIL}
    private final window window;
    private final ImageIcon imageBackground;
    public static final ImageIcon imageBackgroundPass = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL_COMPLETE_BACKGROUND);
    public static final ImageIcon imageBackgroundFail = ImageManager.getImageIcon(ImageManager.ImageName.GAME_OVER_BACKGROUND);
    public static final ImageIcon levelsButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVELS_BUTTON);
    public static final ImageIcon nextLevelsButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.NEXT_LEVEL_BUTTON);
    public static final ImageIcon retryLevelsButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.RETRY_LEVEL_BUTTON);
    private static GameFrame gaFrame;
    private static level level;
    private static levelsMenu leMenu;
    public endLevelScreen(Status status,levelsMenu levelsMenu, level levelCurrent, GameFrame gameFrame,window window){
        gaFrame = gameFrame;
        level = levelCurrent;
        leMenu = levelsMenu;
        this.setLayout(null);
        if (SoundManager.isPlayBackGroundMusic())
            SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
        this.window = window;
        imageBackground = status == Status.PASS ? imageBackgroundPass : imageBackgroundFail;
        Image resizedLevelsImage = levelsButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedNextLeveImage = nextLevelsButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedRetryLevelButtonImage = retryLevelsButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);

        if (!gameScreens.levelsMenu.isLevelIsComplete(levelCurrent)) {
            gameScreens.levelsMenu.setLevelIsComplete(levelCurrent,status == Status.PASS);
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
            gaFrame = null;
            leMenu.removePanelMakeSureToStart();
            window.switchPanel(leMenu);
        });

        retryLevelButton.setBounds(600,levelsButton.getY()-70,180,65);
        retryLevelButton.setOpaque(false);
        retryLevelButton.setContentAreaFilled(false);
        retryLevelButton.setBorderPainted(false);
        retryLevelButton.setFocusPainted(false);
        retryLevelButton.setIcon(new ImageIcon(resizedRetryLevelButtonImage));
        retryLevelButton.addActionListener(event -> {
            SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
            level = gameScreens.levelsMenu.resetLevel(level);
            gaFrame = new GameFrame(level,leMenu,window);
            window.switchPanel(gaFrame);
        });

        if (gameScreens.levelsMenu.getNextLevel(levelCurrent) != null && (Objects.requireNonNull(gameScreens.levelsMenu.getNextLevel(level))).isBuilt() && gameScreens.levelsMenu.isLevelIsComplete(levelCurrent)) {
            nextLevelButton.setBounds(600, retryLevelButton.getY() - 70, 180, 65);
            nextLevelButton.setOpaque(false);
            nextLevelButton.setContentAreaFilled(false);
            nextLevelButton.setBorderPainted(false);
            nextLevelButton.setFocusPainted(false);
            nextLevelButton.setIcon(new ImageIcon(resizedNextLeveImage));
            nextLevelButton.addActionListener(event -> {
                SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
                level = gameScreens.levelsMenu.getNextLevel(level);
                gaFrame = new GameFrame(level,leMenu,window);
                window.switchPanel(gaFrame);
            });
            this.add(nextLevelButton);
        }

        this.add(levelsButton);
        this.add(retryLevelButton);
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(imageBackground.getImage(), 0, 0, 1540, 941, this);
    }
}