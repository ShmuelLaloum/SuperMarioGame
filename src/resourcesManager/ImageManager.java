package resourcesManager;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ImageManager {
    public enum ImageName {
        LOGIN_SCREEN_BACKGROUND("loginScreenBackground.jpg"),
        START_BUTTON_BACKGROUND("StartButtonBackground.png"),
        LEVELS_MENU_SCREEN_BACKGROUND("levelsMenuBackground.png"),
        LEVEL1_BUTTON("level1Button.png"),
        LEVEL2_BUTTON("level2Button.png"),
        LEVEL3_BUTTON("level3Button.png"),
        LEVEL4_BUTTON("level4Button.png"),
        LEVEL5_BUTTON("level5Button.png"),
        LEVEL1_BACKGROUND("level1Background.jpg"),
        MAKE_SURE_TO_START_SCREEN_BACKGROUND("makeSureToStartScreenBackground.png"),
        BACK_BUTTON_BACKGROUND("backButtonBackground.png"),
        PLAY_BUTTON_BACKGROUND("playButtonBackground.png"),
        GRASS_CUBE("grassCube.jpg"),
        LAND_CUBE("landCube.jpg"),
        LUCKY_CUBE("luckyCube.gif"),
        LUCKY_CUBE_BEEN_TAKEN("luckyCubeBeenTaken.png"),
        BROKEN_CUBE("brokenCube.png"),
        WOOD_CUBE("woodCube.jpg"),
        MUSHROOM_RED("mushroomRED.png"),
        TUBE("tube.png"),
        CARNIVOROUS_PLANT("CarnivorousPlant.gif"),
        COIN("coin.png"),
        CASTLE("castle.png"),
        PEN_GOAL_POLE("PenGoalPole.png"),
        BILL_BLASTER("BillBlaster.png"),
        BULLET_BILL_GO_RIGHT("BulletBillGoRight.png"),
        BULLET_BILL_GO_LEFT("BulletBillGoLeft.png"),
        GOOMBA_GO_RIGHT("goombaGoRight.gif"),
        GOOMBA_GO_LEFT("goombaGoLeft.gif"),
        GOOMBA_DIE("goombaDie.png"),
        FIRE_BALL("FireBall.png"),
        MARIO_GOES_LEFT("MarioGoesLeft.png"),
        MARIO_GOES_RIGHT("MarioGoesRight.png"),
        MARIO_JUMPS_LEFT("MarioJumpsLeft.png"),
        MARIO_JUMPS_RIGHT("MarioJumpsRight.png"),
        GAME_OVER_BACKGROUND("gameOverBackground.jpg"),
        LEVEL_COMPLETE_BACKGROUND("levelCompleteBackground.jpg"),
        LEVELS_BUTTON("levelsButton.png"),
        NEXT_LEVEL_BUTTON("nextLevelButton.png"),
        RETRY_LEVEL_BUTTON("retryLevelButton.png"),
        OPTIONS_BACKGROUND("optionsBackground.png"),
        QUIT_GAME_BUTTON("quitGameButton.png"),
        CONTINUE_BUTTON("continueButton.png"),
        RETRY_LEVEL_BUTTON2("retryLevelButton2.png"),
        PAUSE_BUTTON("pauseButton.png"),
        LOGO("logo.png"),
        BACKGROUND_MUSIC_ACTIVE_BUTTON("backgroundMusicActive.png"),
        BACKGROUND_MUSIC_NO_ACTIVE_BUTTON("backgroundMusicNoActive.png"),
        MUSIC_EFFECT_ACTIVE_BUTTON("musicEffectActive.png"),
        MUSIC_EFFECT_NO_ACTIVE_BUTTON("musicEffectNoActive.png"),
        EXPLAIN_OF_THE_GAME("explainOfTheGame.png"),
        JUMP_BUTTON("jumpButton.png"),
        MOVE_RIGHT_BUTTON("moveRightButton.png"),
        MOVE_LEFT_BUTTON("moveLeftButton.png"),
        LETS_GO_BUTTON("letsGoButton.png"),
        INFORMATION_BUTTON("informationButton.png"),
        START_BUTTON("startButton.png"),
        THREE_GOLD_STARS("threeGoldStars.png"),
        THREE_GREY_STARS("threeGreyStars.png");


        private final String fileName;

        ImageName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    private static final Map<ImageName, ImageIcon> imageCache = new HashMap<>();

    static {
        // טוען את כל התמונות מראש
        for (ImageName imageName : ImageName.values()) {
            loadImage(imageName);
        }
    }

    private static void loadImage(ImageName imageName) {
        String filePath = "resources/images/" + imageName.getFileName();
        ImageIcon imageIcon = new ImageIcon(filePath);
        imageCache.put(imageName, imageIcon);
    }

    public static ImageIcon getImageIcon(ImageName imageName) {
        return imageCache.get(imageName);
    }
}