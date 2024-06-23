package gameScreens;

import levels.level;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class makeSureToStart extends JPanel {
    private static final ImageIcon playButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.PLAY_BUTTON_BACKGROUND);
    private static final ImageIcon backButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.BACK_BUTTON_BACKGROUND);
    public static final ImageIcon backgroundImage = ImageManager.getImageIcon(ImageManager.ImageName.MAKE_SURE_TO_START_SCREEN_BACKGROUND);
    private static final ImageIcon threeGoldStars = ImageManager.getImageIcon(ImageManager.ImageName.THREE_GOLD_STARS);
    private static final ImageIcon threeGreyStars = ImageManager.getImageIcon(ImageManager.ImageName.THREE_GREY_STARS);
    private static GameFrame gameFrame;
    private level level;
    public makeSureToStart(window window,levelsMenu levelsMenu, level Openlevel){
        level = Openlevel;
        this.setOpaque(false);
        this.setLayout(null);
        this.setBounds(150,50,1250,750);
        this.setOpaque(false);
        Image resizedPlayImage = playButtonImage.getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);
        Image resizedBackImage = backButtonImage.getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);

       JLabel requirements = new JLabel();
       if (level.isBuilt()) {
           requirements.setText("level requirements :" + level.getCoinsRequired() + " coins");
           requirements.setBounds(335,360,600,100);
       }else {
           requirements.setText("Coming soon!");
           requirements.setBounds(480,360,600,100);
       }
       Font font = new Font("Algerian", Font.BOLD, 35);
       requirements.setFont(font);
       this.add(requirements);

       if (level.isBuilt()) {
           JButton startGame = new JButton();
           startGame.setBounds(680, 615, 100, 40);
           startGame.setOpaque(false);
           startGame.setContentAreaFilled(false);
           startGame.setBorderPainted(false);
           startGame.setFocusPainted(false);
           startGame.setIcon(new ImageIcon(resizedPlayImage));
           this.add(startGame);
           startGame.addActionListener(event -> {
               SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
               gameFrame = new GameFrame(level, levelsMenu, window);
               window.switchPanel(gameFrame);
           });
       }

        JButton back = new JButton();
       if (level.isBuilt()) {
           back.setBounds(430, 615, 100, 40);
       }else {
           back.setBounds(550, 615, 100, 40);
       }
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setIcon(new ImageIcon(resizedBackImage));
        this.add(back);
        back.addActionListener(event -> {
            levelsMenu.removePanelMakeSureToStart();
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        if (levelsMenu.isLevelIsComplete(level)){
            graphics.drawImage(threeGoldStars.getImage(), 400, 100, threeGoldStars.getIconWidth()*2, threeGoldStars.getIconHeight()*2, this);
        }else {
            graphics.drawImage(threeGreyStars.getImage(), 400,100, threeGreyStars.getIconWidth()*2, threeGreyStars.getIconHeight()*2, this);
        }
    }
}