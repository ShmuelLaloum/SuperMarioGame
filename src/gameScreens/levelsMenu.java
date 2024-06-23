package gameScreens;

import levels.*;
import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class levelsMenu extends JLayeredPane {
    public static final ImageIcon level1ButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL1_BUTTON);
    public static final ImageIcon level2ButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL2_BUTTON);
    public static final ImageIcon level3ButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL3_BUTTON);
    public static final ImageIcon level4ButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL4_BUTTON);
    public static final ImageIcon level5ButtonImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL5_BUTTON);
    public static final ImageIcon backgroundImage = ImageManager.getImageIcon(ImageManager.ImageName.LEVELS_MENU_SCREEN_BACKGROUND);
    private static boolean levelIsComplete1 = false;
    private static boolean levelIsComplete2 = false;
    private static boolean levelIsComplete3 = false;
    private static boolean levelIsComplete4 = false;
    private static boolean levelIsComplete5 = false;

    private static level1 level1 = new level1();
    private static level2 level2 = new level2();
    private static level3 level3 = new level3();
    private static level4 level4 = new level4();
    private static level5 level5 = new level5();
    private static makeSureToStart makeSureToStart;
    private Window window;
    private static JButton playEffectButton = new JButton();
    private static JButton playBackGroundButton = new JButton();
    public static final Image resizedPlayBackGroundActiveImage = ImageManager.getImageIcon(ImageManager.ImageName.BACKGROUND_MUSIC_ACTIVE_BUTTON).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    public static final Image resizedPlayBackGroundNoActiveImage = ImageManager.getImageIcon(ImageManager.ImageName.BACKGROUND_MUSIC_NO_ACTIVE_BUTTON).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    public static final Image resizedplayEffectActiveImage = ImageManager.getImageIcon(ImageManager.ImageName.MUSIC_EFFECT_ACTIVE_BUTTON).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    public static final Image resizedplayEffectNoActiveImage = ImageManager.getImageIcon(ImageManager.ImageName.MUSIC_EFFECT_NO_ACTIVE_BUTTON).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

    public levelsMenu(window window) {
        this.window = window;
        this.setLayout(null);
        Image resizedLevel1Image = level1ButtonImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel2Image = level2ButtonImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel3Image = level3ButtonImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel4Image = level4ButtonImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel5Image = level5ButtonImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);


        playBackGroundButton.setBounds(0, 0, 50, 50);
        playBackGroundButton.setOpaque(false);
        playBackGroundButton.setContentAreaFilled(false);
        playBackGroundButton.setBorderPainted(false);
        playBackGroundButton.setFocusPainted(false);
        playBackGroundButton.setIcon(new ImageIcon(resizedPlayBackGroundActiveImage));
        this.add(playBackGroundButton);
        playBackGroundButton.addActionListener(event -> {
            SoundManager.setPlayBackGroundMusic(!SoundManager.isPlayBackGroundMusic());
            if (SoundManager.isPlayBackGroundMusic()){
                SoundManager.loopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
            }else {
                SoundManager.stopSound(SoundManager.SoundName.BACKGROUND_LOBBY_MUSIC);
            }
            updateImageForMusicButtons();

        });
        playEffectButton.setBounds(playBackGroundButton.getX()+50, playBackGroundButton.getY(), 50, 50);
        playEffectButton.setOpaque(false);
        playEffectButton.setContentAreaFilled(false);
        playEffectButton.setBorderPainted(false);
        playEffectButton.setFocusPainted(false);
        playEffectButton.setIcon(new ImageIcon(resizedplayEffectActiveImage));
        this.add(playEffectButton);
        playEffectButton.addActionListener(event -> {
            SoundManager.setPlayMusicEffect(!SoundManager.isPlayMusicEffect());
            updateImageForMusicButtons();
        });



        JButton level1Button = new JButton();
        level1Button.setBounds(175, 390, 70, 70);
        level1Button.setOpaque(false);
        level1Button.setContentAreaFilled(false);
        level1Button.setBorderPainted(false);
        level1Button.setFocusPainted(false);
        level1Button.setIcon(new ImageIcon(resizedLevel1Image));
        this.add(level1Button, JLayeredPane.DEFAULT_LAYER);

        level1Button.addActionListener(event -> {
            level1 = (levels.level1) resetLevel(level1);
            makeSureToStart = new makeSureToStart(window, this, level1);
            this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
            disableAllButtons();
            this.revalidate();
            this.repaint();
        });

        JButton level2Button = new JButton();
        level2Button.setBounds(175, 740, 70, 70);
        level2Button.setOpaque(false);
        level2Button.setContentAreaFilled(false);
        level2Button.setBorderPainted(false);
        level2Button.setFocusPainted(false);
        level2Button.setIcon(new ImageIcon(resizedLevel2Image));
        this.add(level2Button, JLayeredPane.DEFAULT_LAYER);

        level2Button.addActionListener(event -> {
            if (isLevelIsComplete(level1)) {
                level2 = (levels.level2) resetLevel(level2);
                makeSureToStart = new makeSureToStart(window,this, level2);
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level3Button = new JButton();
        level3Button.setBounds(735, 740, 70, 70);
        level3Button.setOpaque(false);
        level3Button.setContentAreaFilled(false);
        level3Button.setBorderPainted(false);
        level3Button.setFocusPainted(false);
        level3Button.setIcon(new ImageIcon(resizedLevel3Image));
        this.add(level3Button, JLayeredPane.DEFAULT_LAYER);

        level3Button.addActionListener(event -> {
            if (isLevelIsComplete(level2)) {
                level3 = (levels.level3) resetLevel(level3);
                makeSureToStart = new makeSureToStart(window,this, level3);
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level4Button = new JButton();
        level4Button.setBounds(735, 390, 70, 70);
        level4Button.setOpaque(false);
        level4Button.setContentAreaFilled(false);
        level4Button.setBorderPainted(false);
        level4Button.setFocusPainted(false);
        level4Button.setIcon(new ImageIcon(resizedLevel4Image));
        this.add(level4Button, JLayeredPane.DEFAULT_LAYER);
        level4Button.addActionListener(event -> {
            if (isLevelIsComplete(level3)) {
                level4 = (levels.level4) resetLevel(level4);
                makeSureToStart = new makeSureToStart(window,this, level4);
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level5Button = new JButton();
        level5Button.setBounds(1295, 390, 70, 70);
        level5Button.setOpaque(false);
        level5Button.setContentAreaFilled(false);
        level5Button.setBorderPainted(false);
        level5Button.setFocusPainted(false);
        level5Button.setIcon(new ImageIcon(resizedLevel5Image));
        this.add(level5Button, JLayeredPane.DEFAULT_LAYER);
        level5Button.addActionListener(event -> {
            if (isLevelIsComplete(level5)) {
                level5 = (levels.level5) resetLevel(level5);
                makeSureToStart = new makeSureToStart(window, this,level5);
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage.getImage(), 0, 0, 1540, 941, this);
    }

    public static boolean isLevelIsComplete(level level) {
        return switch (level) {
            case level1 level1 -> levelIsComplete1;
            case level2 level2 -> levelIsComplete2;
            case level3 level3 -> levelIsComplete3;
            case level4 level4 -> levelIsComplete4;
            case null, default -> levelIsComplete5;
        };
    }

    public static void setLevelIsComplete(level level, boolean status) {
        switch (level) {
            case level1 level1 -> levelIsComplete1 = status;
            case level2 level2 -> levelIsComplete2 = status;
            case level3 level3 -> levelIsComplete3 = status;
            case level4 level4 -> levelIsComplete4 = status;
            case null, default -> levelIsComplete5 = status;
        }
    }

    public static level getNextLevel(level level) {
        switch (level) {
            case level1 level1 -> {
                return new level2();
            }
            case level2 level2 -> {
                return new level3();
            }
            case level3 level3 -> {
                return new level4();
            }
            case level4 level4 -> {
                return new level5();
            }
            case null, default -> {
                return null;
            }
        }
    }

    public static level resetLevel(level level) {
        switch (level) {
            case level1 level1 -> {
                return new level1();
            }
            case level2 level2 -> {
                return new level2();
            }
            case level3 level3 -> {
                return new level3();
            }
            case level4 level4 -> {
                return new level4();
            }
            case null, default -> {
                return new level5();
            }
        }
    }

    public void disableAllButtons() {
        for (Component component : this.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }

    public void enableAllButtons() {
        for (Component component : this.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(true);
            }
        }
    }

    public void removePanelMakeSureToStart(){
        this.remove(makeSureToStart);
        this.revalidate();
        this.repaint();
        this.requestFocusInWindow();
        enableAllButtons();
    }
    public void updateImageForMusicButtons(){
        if (SoundManager.isPlayBackGroundMusic()) {
            playBackGroundButton.setIcon(new ImageIcon(resizedPlayBackGroundActiveImage));
        }else {
            playBackGroundButton.setIcon(new ImageIcon(resizedPlayBackGroundNoActiveImage));
        }
        if (SoundManager.isPlayMusicEffect()) {
            playEffectButton.setIcon(new ImageIcon(resizedplayEffectActiveImage));
        }else {
            playEffectButton.setIcon(new ImageIcon(resizedplayEffectNoActiveImage));
        }
        System.out.println("D");
    }
}
