import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class SoundHandler {

    public static void main(String[] args) {
        SoundClipTest(args[0]);
    }

    private static void SoundClipTest(String fileName) {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./effects/" + fileName + ".wav");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(Objects.requireNonNull(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("./effects/" + fileName + ".wav");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long duration = 0;
        try {
            duration = Objects.requireNonNull(fileInputStream).getChannel().size() / 128;
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
    }
}
