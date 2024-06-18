package gameScreens;

import levels.*;
import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class levelsMenu extends JLayeredPane {
    private static final ImageIcon lockedLevel = new ImageIcon("C:/Users/ASUS/Desktop/mario project/lockedLevel.png");
    private static final ImageIcon level1Image = new ImageIcon("src/gameResources/level1Button.png");
    private static final ImageIcon level2Image = new ImageIcon("C:/Users/ASUS/Desktop/mario project/level2Button.png");
    private static final ImageIcon level3Image = new ImageIcon("C:/Users/ASUS/Desktop/mario project/level3Button.png");
    private static final ImageIcon level4Image = new ImageIcon("C:/Users/ASUS/Desktop/mario project/level4Button.png");
    private static final ImageIcon level5Image = new ImageIcon("C:/Users/ASUS/Desktop/mario project/level5Button.png");
    private static final ImageIcon background = new ImageIcon("src/gameResources/menuBackground.png");

    private static boolean levelIsComplete1 = true;
    private static boolean levelIsComplete2 = false;
    private static boolean levelIsComplete3 = false;
    private static boolean levelIsComplete4 = false;
    private static boolean levelIsComplete5 = true;
    private window window;

    public levelsMenu(window window) {
        this.window = window;
        this.setLayout(null);
        Image resizedLevel1Image = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL1_BUTTON).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel2Image = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL2_BUTTON).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel3Image = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL3_BUTTON).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel4Image = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL4_BUTTON).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        Image resizedLevel5Image = ImageManager.getImageIcon(ImageManager.ImageName.LEVEL5_BUTTON).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);


        JButton level1Button = new JButton();
        level1Button.setBounds(175, 365, 70, 70);
        level1Button.setOpaque(false);
        level1Button.setContentAreaFilled(false);
        level1Button.setBorderPainted(false);
        level1Button.setFocusPainted(false);
        level1Button.setIcon(new ImageIcon(resizedLevel1Image));
        this.add(level1Button, JLayeredPane.DEFAULT_LAYER);

        level1Button.addActionListener(event -> {
            makeSureToStart makeSureToStart = new makeSureToStart(window, new level1());
            this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
            disableAllButtons();
            this.revalidate();
            this.repaint();
        });

        JButton level2Button = new JButton();
        level2Button.setBounds(175, 695, 70, 70);
        level2Button.setOpaque(false);
        level2Button.setContentAreaFilled(false);
        level2Button.setBorderPainted(false);
        level2Button.setFocusPainted(false);
        level2Button.setIcon(new ImageIcon(resizedLevel2Image));
        this.add(level2Button, JLayeredPane.DEFAULT_LAYER);

        level2Button.addActionListener(event -> {
            if (isLevelIsComplete(new level1())){
                makeSureToStart makeSureToStart = new makeSureToStart(window, new level2());
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level3Button = new JButton();
        level3Button.setBounds(735, 695, 70, 70);
        level3Button.setOpaque(false);
        level3Button.setContentAreaFilled(false);
        level3Button.setBorderPainted(false);
        level3Button.setFocusPainted(false);
        level3Button.setIcon(new ImageIcon(resizedLevel3Image));
        this.add(level3Button, JLayeredPane.DEFAULT_LAYER);

        level3Button.addActionListener(event -> {
            if (isLevelIsComplete(new level2())){
                makeSureToStart makeSureToStart = new makeSureToStart(window, new level3());
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level4Button = new JButton();
        level4Button.setBounds(735, 365, 70, 70);
        level4Button.setOpaque(false);
        level4Button.setContentAreaFilled(false);
        level4Button.setBorderPainted(false);
        level4Button.setFocusPainted(false);
        level4Button.setIcon(new ImageIcon(resizedLevel4Image));
        this.add(level4Button, JLayeredPane.DEFAULT_LAYER);
        level4Button.addActionListener(event -> {
            if (isLevelIsComplete(new level3())){
                makeSureToStart makeSureToStart = new makeSureToStart(window, new level4());
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

        JButton level5Button = new JButton();
        level5Button.setBounds(1295, 365, 70, 70);
        level5Button.setOpaque(false);
        level5Button.setContentAreaFilled(false);
        level5Button.setBorderPainted(false);
        level5Button.setFocusPainted(false);
        level5Button.setIcon(new ImageIcon(resizedLevel5Image));
        this.add(level5Button, JLayeredPane.DEFAULT_LAYER);
        level5Button.addActionListener(event -> {
            if (isLevelIsComplete(new level4())){
                makeSureToStart makeSureToStart = new makeSureToStart(window, new level5());
                this.add(makeSureToStart, JLayeredPane.PALETTE_LAYER);
                disableAllButtons();
                this.revalidate();
                this.repaint();
            }
        });

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.LEVELS_MENU_SCREEN_BACKGROUND).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
    public static void setLevelIsComplete(level level ,boolean status) {
        switch (level) {
            case level1 level1 -> levelIsComplete1 = status;
            case level2 level2 -> levelIsComplete2 = status;
            case level3 level3 -> levelIsComplete3 = status;
            case level4 level4 -> levelIsComplete4 = status;
            case null, default -> levelIsComplete5 = status;
        }
    }
    public static level getNextLevel(level level){
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
            case null, default -> {return null;
            }
        }
    }
    public static level resetLevel(level level){
        switch (level) {
            case levels.level1 level1 -> {
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
    public void moveToFront(Component component) {
        this.setLayer(component, JLayeredPane.PALETTE_LAYER);
        component.setVisible(true);
        component.repaint();
    }
}