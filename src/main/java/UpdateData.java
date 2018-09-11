import java.lang.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.*;

import org.json.simple.JSONObject;

public class UpdateData {

    private static void log(String contense, String loggingClass) throws IOException {
        // Logger function. This use to be returnLogObject, but it wrote XML data.
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        // This block configure the logger with handler and formatter
        fh = new FileHandler("./data/log.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);
        System.out.println(logger);
        System.out.println(fh);
        switch (loggingClass) {
            case "finest":
                logger.finest(contense);
                break;
            case "finer":
                logger.finer(contense);
                break;
            case "fine":
                logger.fine(contense);
                break;
            case "config":
                logger.config(contense);
                break;
            case "severe":
                logger.severe(contense);
                break;
        }
        System.out.println("Done!");
        fh.close(); // Do this so there is not a max lock (100) error
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        log("Running", "fine");
        UpdateData.DataUpdateTiming();
    }

    private static void DataUpdateTiming() throws InterruptedException, IOException {
        while (true) {
            Thread.sleep(1000);
            DataUpdate();
        }
    }

    @SuppressWarnings("unchecked")
    private static void DataUpdate() throws IOException {

        log("Generating random int for day quality...", "fine");
        Random randomClass = new Random();
        int dayQualityInt = randomClass.nextInt((5 - 1) + 1) + 1;
        String dayQuality = null;
        switch (dayQualityInt) {
            case 1:
                dayQuality = "horrible";
                break;
            case 2:
                dayQuality = "bad";
                break;
            case 3:
                dayQuality = "ok";
                break;
            case 4:
                dayQuality = "good";
                break;
            case 5:
                dayQuality = "great";
                break;
        }

        log("Creating JSONObject...", "fine");
        JSONObject JSONDataObject = new JSONObject();

        log("Adding data to JSONObject...", "fine");
        JSONDataObject.put("dayQuality", dayQuality);
        JSONDataObject.put("updateTime", System.currentTimeMillis());

        try (FileWriter file = new FileWriter("./data/UpdatedData.json")) {
            file.write(JSONDataObject.toJSONString());
        } catch (IOException FileNotFoundError) {
            log("JSON FILE COULD NOT BE FOUND! PLEASE RUN DIAGNOSTICS!", "severe");
            System.out.println("It looks like the UpdatedData.json could not be found. Please run diagnostics!");
        } catch (SecurityException SecurityException) {
            log("JSON FILE COULD NOT BE ACCESSED! PLEASE RUN DIAGNOSTICS!", "severe");
            System.out.println("It looks like the UpdatedData.json could not be accessed. Please run diagnostics!");
        }
    }
}
