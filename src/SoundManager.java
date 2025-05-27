import javax.sound.sampled.*;

public class SoundManager {
    private static Clip backgroundClip;  
    private static Clip winClip; 
    public static void playBackgroundMusic() {
        try {
            System.out.println("Trying to load: " + SoundManager.class.getResource("/sounds/bgm.wav"));
            if (winClip != null && winClip.isRunning()) {
                winClip.stop();
                winClip.close();
                System.out.println("winning music stopped.");
            } 
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource("/sounds/bgm.wav")
            );

            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audio);
            FloatControl volumeControl = (FloatControl) backgroundClip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-15.0f); // Lower volume
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playClickSound() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource("/sounds/click.wav")
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            System.out.println("CLICKED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playErrorSound() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource("/sounds/error.wav")
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            System.out.println("ERROR");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public void playWinSound() {
        try {
            
            if (backgroundClip != null && backgroundClip.isRunning()) {
                backgroundClip.stop();
                backgroundClip.close();
                System.out.println("Background music stopped.");
            }

           
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource("/sounds/win.wav")
            );
            winClip = AudioSystem.getClip();
            winClip.open(audio);
            winClip.start();
            System.out.println("WIN sound played.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
