/*import javax.swing.*;
import java.io.File;

public class Adap {
public static void main(String[] args) {
        // Create a MIDI player
        MidiPlayer midiPlayer = new MidiPlayerImpl();

        // Create an adapter for MP3 using the MIDI player
        Mp3Player mp3Player = new MidiToMp3Adapter(midiPlayer);

        // Open a file dialog to choose a file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose MP3 file");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
        // Get the selected file
        File selectedFile = fileChooser.getSelectedFile();

        // Use the MP3 player (which internally uses the MIDI player)
        mp3Player.playMp3(selectedFile.getAbsolutePath());
        } else {
        System.out.println("File selection canceled.");
        }
    }
}
*/