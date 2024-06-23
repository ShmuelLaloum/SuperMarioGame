package gameScreens;
import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;
public class explainOfTheGame extends JPanel {
    private static final ImageIcon marioJumpExplain = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_JUMPS_RIGHT);
    private static final ImageIcon marioMoveLeftExplain = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_LEFT);
    private static final ImageIcon marioMoveRightExplain = ImageManager.getImageIcon(ImageManager.ImageName.MARIO_GOES_RIGHT);
    private static final ImageIcon JumpButton = ImageManager.getImageIcon(ImageManager.ImageName.JUMP_BUTTON);
    private static final ImageIcon moveRightButton = ImageManager.getImageIcon(ImageManager.ImageName.MOVE_RIGHT_BUTTON);
    private static final ImageIcon moveLeftButton = ImageManager.getImageIcon(ImageManager.ImageName.MOVE_LEFT_BUTTON);
    private static final ImageIcon letsGoPic = ImageManager.getImageIcon(ImageManager.ImageName.LETS_GO_BUTTON);
    private static final ImageIcon background = ImageManager.getImageIcon(ImageManager.ImageName.EXPLAIN_OF_THE_GAME);
    public explainOfTheGame(window window,StartScreen startScreen){
        this.setOpaque(false);
        this.setLayout(null);

        JLabel jump = new JLabel("Jump.1");
        jump.setBounds(1160,200,150,100);
        Font font = new Font("Algerian", Font.BOLD, 30);
        jump.setFont(font);
        this.add(jump);

        JLabel moveRight = new JLabel("move right.2");
        moveRight.setBounds(1050,350,250,100);
        moveRight.setFont(font);
        this.add(moveRight);

        JLabel moveLeft = new JLabel("move left.3");
        moveLeft.setBounds(1065,500,250,100);
        moveLeft.setFont(font);
        this.add(moveLeft);

        JLabel explainOfTheGame = new JLabel("<html>Your goal: pass the stage without dying to the enemies that are waiting for you on the way,<br>good luck</html>");
        explainOfTheGame.setHorizontalAlignment(SwingConstants.CENTER);
        explainOfTheGame.setBounds(300,100,400,500);
        explainOfTheGame.setFont(font);
        this.add(explainOfTheGame);

        JButton letsGoButton = new JButton();
        letsGoButton.setBounds(400,550,220,60);
        letsGoButton.setOpaque(false);
        letsGoButton.setContentAreaFilled(false);
        letsGoButton.setBorderPainted(false);
        letsGoButton.setIcon(letsGoPic);
        this.add(letsGoButton);

        letsGoButton.addActionListener(event -> {
            Container parent = this.getParent();
            if (parent != null) {
                parent.remove(this);
                startScreen.buttonsAreVisible(true);
                parent.revalidate();
                parent.repaint();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 100, 0, getWidth()-200, getHeight()-50, this);
        g.drawImage(JumpButton.getImage() ,750 , 200 ,70,70,this);
        g.drawImage(moveRightButton.getImage() ,750 , 350 ,70,70,this);
        g.drawImage(moveLeftButton.getImage() ,750 , 500 ,70,70,this);

        g.drawImage(marioJumpExplain.getImage() ,870, 125 , 100,100,this);
        g.drawImage(marioMoveRightExplain.getImage() ,870, 315 , 100,100,this);
        g.drawImage(marioMoveLeftExplain.getImage() ,870, 465 , 100,100,this);

    }
}
