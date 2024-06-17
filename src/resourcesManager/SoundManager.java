package resourcesManager;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    //Volume range for GOOMBA_DIE: -80.0 dB to 6.0206 dB
    public enum SoundName {
        BACKGROUND_LOBBY_MUSIC("background_Lobby_music.wav"),
        BACKGROUND_GAME_MUSIC("backgroundGameMusic.wav"),
        MARIO_JUMP("marioJump.wav"),
        MARIO_EAT_MUSHROOM("mario_Eat_Mushroom.wav"),
        MARIO_DIE("mario_die.wav"),
        GOOMBA_DIE("sound_goomba_Die.wav"),
        MARIO_COLLECTS_COIN("marioCollectsCoin.wav");

        private final String fileName;

        SoundName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static final Map<SoundName, Clip> soundClips = new HashMap<>();

    static {
        // טוען את כל הסאונדים מראש
        for (SoundName soundName : SoundName.values()) {
            loadSound(soundName);
        }
    }

    private static void loadSound(SoundName soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/sounds/"+soundName.getFileName()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            soundClips.put(soundName, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSound(SoundName soundName) {
        playSound(soundName, 0.0f); // Default volume
    }

    public static void playSound(SoundName soundName, float volume) {
        Clip clip = soundClips.get(soundName);
        if (clip == null) {
            loadSound(soundName);
            clip = soundClips.get(soundName);
        }
        if (clip != null) {
            clip.setFramePosition(0); // Restart the clip from the beginning
            setVolume(soundName, volume);
            clip.start();
        }
    }

    public static void loopSound(SoundName soundName) {
        loopSound(soundName, 0.0f); // Default volume
    }

    public static void loopSound(SoundName soundName, float volume) {
        Clip clip = soundClips.get(soundName);
        if (clip == null) {
            loadSound(soundName);
            clip = soundClips.get(soundName);
        }
        if (clip != null) {
            clip.setFramePosition(0); // Restart the clip from the beginning
            setVolume(soundName, volume);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public static void stopSound(SoundName soundName) {
        Clip clip = soundClips.get(soundName);
        if (clip != null) {
            clip.stop();
        }
    }
    public static void setVolume(SoundName soundName, float volume) {
        Clip clip = soundClips.get(soundName);
        if (clip != null) {
            try {
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float min = volumeControl.getMinimum();
                float max = volumeControl.getMaximum();
                if (volume < min) {
                    volume = min;
                } else if (volume > max) {
                    volume = max;
                }
                volumeControl.setValue(volume);
            } catch (IllegalArgumentException e) {
                e.printStackTrace(); // Log the error if the control is not supported
            }
        }
    }

    public static void printVolumeRange(SoundName soundName) {
        Clip clip = soundClips.get(soundName);
        if (clip != null) {
            try {
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float min = volumeControl.getMinimum();
                float max = volumeControl.getMaximum();
                System.out.println("Volume range for " + soundName + ": " + min + " dB to " + max + " dB");
            } catch (IllegalArgumentException e) {
                e.printStackTrace(); // Log the error if the control is not supported
            }
        }
    }
}