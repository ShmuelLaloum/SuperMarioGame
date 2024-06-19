package gameScreens;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartScreen extends JPanel {
    private Clip backgroundSound;
    private JButton startButton;
    public static final ImageIcon backgroundImage = new ImageIcon("src/gameResources/EntranceBackground.jpg"/*"src/gameResources/StartScreenBackground.png"*/);
    public static final ImageIcon startButtonBackgroundImage = new ImageIcon("src/gameResources/StartButtonBackground.png");
    public static final File StartScreenSound = new File("resources/sounds/background_music.wav");

    public StartScreen(window window){
        this.setLayout(null);

        Image resizedImage = ImageManager.getImageIcon(ImageManager.ImageName.START_BUTTON_BACKGROUND).getImage().getScaledInstance(250, 95,Image.SCALE_SMOOTH);

        startButton = new JButton(new ImageIcon(resizedImage));
        startButton.setBounds(650, 750, 250, 95);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);

        this.add(startButton);


        /*try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(StartScreenSound);
            backgroundSound = AudioSystem.getClip();
            backgroundSound.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

         */

        //playBackgroundMusic();
        SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);


        startButton.addActionListener(event -> {
            window.switchPanel(new levelsMenu(window));
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.LOGIN_SCREEN_BACKGROUND).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    public Dimension getPreferredSize() {
        // Ensure the panel is the same size as the window
        return new Dimension(1920, 1080);
    }
}