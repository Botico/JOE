import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SameParameterValue")
class SoundHandler {

    public static void main(String[] args) {
        SoundClipTest(args[0]);
    }

    private static String downDir(int levels) {
        String oldPath = System.getProperty("user.dir");
        String[] splitedPathArray = oldPath.split("/");
        levels = splitedPathArray.length - levels;
        List<String> splitedPathList = Arrays.asList(splitedPathArray);
        splitedPathList = splitedPathList.subList(0, levels);
        String newPath = String.join("/", splitedPathList);
        return newPath + "/";
    }

    private static void SoundClipTest(String fileName) {
        InputStream inputStream = null;

        downDir(1);

        try {
            String effectsPath = downDir(2);
            inputStream = new FileInputStream(effectsPath + "effects/" + fileName + ".wav");
        } catch (IOException e) {
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
            String effectsPath = downDir(2);
            fileInputStream = new FileInputStream(effectsPath + "effects/" + fileName + ".wav");
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
        System.exit(1);
    }
}
