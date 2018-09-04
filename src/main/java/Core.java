import java.util.Scanner;
import java.util.regex.*;
import java.util.Calendar;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class Core extends Thread implements Runnable{

    private static String user_input() {
        // This is the user input method that gets user input
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    }

    private static void time(String type) {
        // This method handles time
        String[] arguments = new String[] {"123"};
        Calendar cal = Calendar.getInstance();
        switch (type) {
            case "time":
                System.out.println("Time time is " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
                main(arguments);
                break;
            case "minute":
                System.out.println("The minute right now is " + cal.get(Calendar.MINUTE));
                main(arguments);
                break;
            case "hour":
                System.out.println("The hour right now is " + cal.get(Calendar.HOUR));
                main(arguments);
                break;
            case "month":
                System.out.println("The month right now is " + cal.get(Calendar.MONTH));
                main(arguments);
                break;
            case "year":
                System.out.println("The year right now is " + cal.get(Calendar.YEAR));
                main(arguments);
                break;
        }
    }

    public static void main(String[] args) {
        // This is the main method that handles calling functions based on user input
        String[] arguments = new String[] {"123"};
        System.out.println("Hello! I'm Joe. Can I help you today?");
        String input = user_input();
        if (Pattern.matches(".*\\btime\\b.*", input)) {
            time("time");
        }
        else if (Pattern.matches(".*\\bminute\\b.*", input)) {
            time("minute");
        }
        else if (Pattern.matches(".*\\bhour\\b.*", input)) {
            time("hour");
        }
        else if (Pattern.matches(".*\\bmonth\\b.*", input)) {
            time("month");
        }
        else if (Pattern.matches(".*\\byear\\b.*", input)) {
            time("year");
        } else if (Pattern.matches("(.*\\bsound\\b.*)|(.*\\bmusic\\b.*)|(.*\\baudible\\b.*)|(.*\\bplay\\b.*)", input)) {

            if (Pattern.matches("(.*\\bhappy\\b.*)|(.*\\benthusiastic\\b.*)|(.*\\bcheerful\\b.*)|(.*\\bestatic\\b.*)|(.*\\bjubilant\\b.*)|(.*\\bjoyfull\\b.*)|(.*\\bupbeat\\b.*)", input)) {

            } else if (Pattern.matches("(.*\\bsad\\b.*)|(.*\\bmeloncholly\\b.*)|(.*\\bdepresing\\b.*)|(.*\\bdismal\\b.*)|(.*\\bwistfull\\b.*)|(.*\\bbitter\\b.*)|(.*\\bsomber\\b.*)", input)) {

            } else if (Pattern.matches("(.*\\bscarry\\b.*)|(.*\\bcreepy\\b.*)|(.*\\berrie\\b.*)|(.*\\bhorifying\\b.*)|(.*\\bspooky\\b.*)|(.*\\bchilling\\b.*)", input)) {

            } else if (Pattern.matches("(.*\\belectronic\\b.*)|(.*\\bcomputerized\\b.*)", input)) {

            } else if (Pattern.matches("(.*\\bmeditation\\b.*)|(.*\\bcalming\\b.*)", input)) {

            } else {
                System.out.println("Sorry, but I can't find that music file. Try running diagnostics!");
            }

        } else {
            System.out.println("Sorry, I don't quite understand. Later, you will be able to install mods with want you want.");
            main(arguments);
        }
    }
}

class Audio extends JFrame {
    public Audio(String type, String fileName) {
        switch (type) {
            case "time":
                sound(fileName);
        }
    }
    public void sound(String fileName) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test Sound Clip");
        this.setSize(300, 200);
        this.setVisible(true);

        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource(fileName);
            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}