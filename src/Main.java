import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Warehouse warehouse;
    static Worker[] workers;

    public static void main(String[] args) {
        newGame();
    }

    private static void newGame() {
        _lonelyHiddenHoleCache.clear();
        _dummyHiddenHoleCache.clear();
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
            //TODO: finish, create fields and set neighbors
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


    private static Map<Integer, HiddenHole> _lonelyHiddenHoleCache = new HashMap<>();
    private static Map<Integer, HiddenHole> _dummyHiddenHoleCache = new HashMap<>();
    private static Field fieldFromInput(String desc) {
        Pattern p = Pattern.compile("^(?<fieldtype>H|(H(?<hid>\\d+)([H_]))|(S(?<sid>\\d+)([NF]))|P|O|_)(?<effect>[HON])(?<contained>(W(?<wid>\\d+))|B)?");
        Matcher matcher = p.matcher(desc);
        if(matcher.matches()) {
            String fieldtype = matcher.group("fieldtype");
            String effect = matcher.group("effect");
            String contained = matcher.group("contained");
            Field f;
            if(fieldtype == null) {
                System.out.println("Wrong field type");
                return null;
            }
            if(effect == null) {
                System.out.println("Wrong effect");
                return null;
            }
            if(fieldtype.equals("H"))
                f = new Hole();
            else if(fieldtype.equals("P"))
                f = new BoxPlace();
            else if(fieldtype.equals("O"))
                f = new Obstacle();
            else if(fieldtype.equals("_"))
                f = new Floor();
            else if(fieldtype.charAt(0) == 'H') {
                int id = Integer.parseInt(matcher.group("hid"));
                if(_dummyHiddenHoleCache.containsKey(id)) {
                    f = _dummyHiddenHoleCache.get(id);
                } else {
                    f = new HiddenHole();
                    _lonelyHiddenHoleCache.put(id, (HiddenHole) f);
                }
            } else {
                int id = Integer.parseInt(matcher.group("sid"));
                if(_lonelyHiddenHoleCache.containsKey(id))
                    f = new Switch(_lonelyHiddenHoleCache.get(id));
                else {
                    HiddenHole dummyHH = new HiddenHole();
                    f = new Switch(dummyHH);
                    _dummyHiddenHoleCache.put(id, dummyHH);
                }
            }

            //TODO: effects

            if(contained != null) {
                if(contained.equals("B"))
                    f.accept(new Box(), null);
                else {
                    int id = Integer.parseInt(matcher.group("wid"));
                    f.accept(workers[id], null);
                }
            }

            return f;
        }
        return null;
    }
}
