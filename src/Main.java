import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Warehouse warehouse;
    static Worker[] workers;

    public static void main(String[] args) {
        newGame();
    }

    private static void newGame() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String path = "";
        while(true) {
            try {
                path = consoleReader.readLine();
                readInputFile(path);
                break;
            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }

    List<List<Field>> fieldTable = new ArrayList<>();

    private static void readInputFile(String path) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String line = file.readLine();
        String[] split = line.split(" ");
        workers = new Worker[split.length / 2];
        for(int i = 0; i<workers.length; i++) {
            int score = Integer.parseInt(split[2 * i]);
            int strength = Integer.parseInt(split[2 * i + 1]);
            workers[i] = new Worker(score, strength);
        }
        while ((line = file.readLine()) != null) {
            split = line.split(" ");
            //TODO: finish
        }
    }

    private static String execute(String command) {
        throw new NotImplementedException();
    }

    private static String getWorkerState(int idx) {
        throw new NotImplementedException();
    }

    private static String getFieldState(int x, int y) {
        throw new NotImplementedException();
    }

    private static String getGameState() {
        throw new NotImplementedException();
    }

    private static String commandWorker(int idx, String command) {
        throw new NotImplementedException();
    }

    private Field fieldFromInput(String desc) {
        Pattern p = Pattern.compile("^(?<fieldtype>H|(H\\d+([H_]))|(S\\d+([NF]))|P|O|_)(?<effect>[HON])(?<contained>(W\\d+)|B)?");
        Matcher matcher = p.matcher(desc);
        if(matcher.matches()) {
            String fieldtype = matcher.group("fieldtype");

        }
        return null;
    }
}
