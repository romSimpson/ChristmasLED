import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AudioLedIntegration {
    public static void main(String[] args) {
        // Create an LED controller
        LedController ledController = new LedController();

        // Create an audio analyzer using the LED controller
        AudioAnalyzer audioAnalyzer = new AudioAnalyzerImpl(ledController);

        // Specify the file path to play
        String filePath = "C:\\Users\\admin\\Downloads\\Titantic.mp3";

        // Use the audio analyzer (which internally controls the LEDs)
        audioAnalyzer.analyzeAudio(filePath);

        // Open the audio file with the default associated application
        try {
            Desktop.getDesktop().open(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}