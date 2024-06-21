package gameScreens;

import levels.level;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class PauseMenuScreen extends JPanel {
    private window window;
    private static level level;
    private static GameFrame gaFrame;
    private static levelsMenu leMenu;
    public static final ImageIcon backgroundImage = ImageManager.getImageIcon(ImageManager.ImageName.OPTIONS_BACKGROUND);
    public static final ImageIcon quitGameButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.QUIT_GAME_BUTTON);
    public static final ImageIcon continueButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.CONTINUE_BUTTON);
    private static final ImageIcon retryLevelButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.RETRY_LEVEL_BUTTON2);
    public PauseMenuScreen(level levelCurrent,levelsMenu levelsMenu,GameFrame gameFrame, window window){
        this.setOpaque(false);
        this.setLayout(null);
        this.window = window;
        level = levelCurrent;
        leMenu = levelsMenu;
        gaFrame = gameFrame;
        Image resizedQuitGameImage = quitGameButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedContinueImage = continueButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);
        Image resizedretryLevelImage = retryLevelButtonImage.getImage().getScaledInstance(180, 65, Image.SCALE_SMOOTH);

        JButton quitGameButton = new JButton();
        quitGameButton.setBounds(660,450,180,65);
        quitGameButton.setOpaque(false);
        quitGameButton.setContentAreaFilled(false);
        quitGameButton.setBorderPainted(false);
        quitGameButton.setFocusPainted(false);
        quitGameButton.setIcon(new ImageIcon(resizedQuitGameImage));

        quitGameButton.addActionListener(event -> {
            SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_GAME_MUSIC);
            SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
            gaFrame = null;
            leMenu.removePanelMakeSureToStart();
            window.switchPanel(leMenu);
        });

        JButton retryLevelButton = new JButton();
        retryLevelButton.setBounds(quitGameButton.getX(),quitGameButton.getY()+97,180,65);
        retryLevelButton.setOpaque(false);
        retryLevelButton.setContentAreaFilled(false);
        retryLevelButton.setBorderPainted(false);
        retryLevelButton.setFocusPainted(false);
        retryLevelButton.setIcon(new ImageIcon(resizedretryLevelImage));

        retryLevelButton.addActionListener(event -> {
            level = gameScreens.levelsMenu.resetLevel(levelCurrent);
            gaFrame = new GameFrame(level,levelsMenu,window);
            window.switchPanel(gaFrame);
        });

        JButton continueButton = new JButton();
        continueButton.setBounds(retryLevelButton.getX(),retryLevelButton.getY()+97,180,65);
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setBorderPainted(false);
        continueButton.setFocusPainted(false);
        continueButton.setIcon(new ImageIcon(resizedContinueImage));

        continueButton.addActionListener(event -> {
            gaFrame = new GameFrame(level,levelsMenu,window);
            window.switchPanel(gaFrame);
        });

        this.add(retryLevelButton);
        this.add(continueButton);
        this.add(quitGameButton);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // אופציונלי: יישום אפקט טשטוש פשוט (טשטוש מורכב דורש יותר מאמץ)
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(255, 255, 255, 128)); // לבן חצי-שקוף
        g2d.fillRect(0, 0, 1540, 941);
        g2d.drawImage(backgroundImage.getImage(),500,200,500,550,this);
        g2d.dispose();

    }
}
