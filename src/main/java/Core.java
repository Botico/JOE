import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

class Core extends Thread implements Runnable {

    private static String userInput() {
        // This is the user input method that gets user input
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    }

    private static void chat() throws IOException, ParseException {
        // This is the chat method
        String[] arguments = new String[] {"123"};
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("./data/UpdatedData.json"));
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println("Ok, what do you want to talk about?");
        String secondaryInput = userInput();
        if (Pattern.matches(".*\\bday\\b.*", secondaryInput)) {
            System.out.println("My day is " + jsonObject.get("dayQuality") + ". Hows yours?");
            String tridaryInput = userInput();
            if (Pattern.matches("(.*\bhorrible\b.*|.*\bbad\b.*)", tridaryInput)){
                System.out.println("Sorry to hear that.");
                main(arguments);
            } else if (Pattern.matches("(.*\\bokay\\b.*|.*\\bfine\\b.*)", tridaryInput)) {
                System.out.println("Wells that's good!");
                main(arguments);
            } else if (Pattern.matches("(.*\\bgreat\\b.*|.*\\bbest\\b.*)", tridaryInput)) {
                System.out.println("Good for you!");
                main(arguments);
            }
        } else {
            System.out.println("Did you grow up under a rock? Because I cant understand that.");
            main(arguments);
        }
    }

    private static void time(String type) throws IOException, ParseException {
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

    public static void main(String[] args) throws IOException, ParseException {
        // This is the main method that handles calling functions based on user input
        String[] arguments = new String[] {"123"};

        BufferedReader reader = new BufferedReader(new FileReader("./data/log.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
             reader.close();

        if (lines >= 50000) {
            PrintWriter writer = new PrintWriter("./data/log.txt");
            writer.print("");
            writer.close();
        }
        System.out.println("Hello! I'm Joe. Can I help you today?");
        String startingInput = userInput();
        if (Pattern.matches(".*\\bjoe\\b.*", startingInput)) {
            System.out.println("How can I help you?");
            String input = userInput();
            if (Pattern.matches(".*\\btime\\b.*", input)) {
                time("time");
            } else if (Pattern.matches(".*\\bminute\\b.*", input)) {
                time("minute");
            } else if (Pattern.matches(".*\\bhour\\b.*", input)) {
                time("hour");
            } else if (Pattern.matches(".*\\bmonth\\b.*", input)) {
                time("month");
            } else if (Pattern.matches(".*\\byear\\b.*", input)) {
                time("year");
            } else if (Pattern.matches(".*\\bchat\\b.*",input)) {
                chat();
            } else {
                System.out.println("I'm sorry, but I don't quite understand. Later, you will be able to install mods with want you want.");
                main(arguments);
            }
        }
    }
}
