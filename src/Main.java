import com.oracle.deploy.update.UpdateCheck;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * A jatekban levo munkasok tombje
     */
    private static Worker[] workers;

    public static void main(String[] args) throws IOException {
        newGame();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = consoleReader.readLine()) != null) {
            String out = execute(line);
            if (out.equals("END")) newGame();
            else System.out.println(out);
        }
    }

    /**
     * Uj jatek inditasara hasznalt fuggveny
     */
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


    /***
     * Beolvassa a parameterkent megadott eleresi uton talalhato bemeneti file-t
     * @param path A file eleresi utja
     * @throws IOException A file olvasasa kozben hiba tortent
     */
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
        List<List<Field>> fields = new ArrayList<>();
        int rowNum = 0;
        List<Field> currRow = new ArrayList<>();
        fields.add(currRow);
        while ((line = file.readLine()) != null) {
            split = line.split(" ");
            //"nulladik" sorba falak
            if(rowNum == 0) {
                List<Field> zerothRow = fields.get(0);
                for (int i = 0; i < split.length+2; i++) {
                    Obstacle o = new Obstacle();
                    zerothRow.add(o);
                    if(i != 0) {
                        Field prevWall = zerothRow.get(i - 1);
                        prevWall.setNeighbor(Direction.RIGHT, o);
                        o.setNeighbor(Direction.LEFT, prevWall);
                    }
                }
                rowNum++;
            }
            List<Field> prevRow = fields.get(rowNum - 1);
            currRow = new ArrayList<>();
            fields.add(currRow);
            Obstacle obstacle = new Obstacle(); //implicit fal a sor elejen
            obstacle.setNeighbor(Direction.UP, prevRow.get(0));
            prevRow.get(0).setNeighbor(Direction.DOWN, obstacle);
            currRow.add(obstacle);
            Field f = obstacle;
            for (int i = 0; i < split.length; i++) {
                String fieldDesc = split[i];
                f = fieldFromInput(fieldDesc);
                if(f == null) {
                    System.out.println("Error initializing fields, wrong field description: " + fieldDesc);
                    return;
                }
                currRow.add(f);
                if(i >= prevRow.size()) { //TODO: normalisan megoldani nem kerul be az uj szomszed row sehova, normalisan megoldani
                    Field obs = new Obstacle();
                    f.setNeighbor(Direction.UP, obs);
                    obs.setNeighbor(Direction.DOWN, f);
                } else {
                    Field uNeighbor = prevRow.get(i);
                    f.setNeighbor(Direction.UP, uNeighbor);
                    uNeighbor.setNeighbor(Direction.DOWN, f);
                }
                Field lNeighbor = currRow.get(i); //egyel el vagyunk csuszva, most az i. van a leirtak kozul,
                                                  // de mivel az elejen van egy obstacle, igy a sorban az i. az eloz
                lNeighbor.setNeighbor(Direction.RIGHT, f);
                f.setNeighbor(Direction.LEFT, lNeighbor);
            }
            obstacle = new Obstacle(); //implicit fal a sor vegen
            obstacle.setNeighbor(Direction.LEFT, f);
            f.setNeighbor(Direction.RIGHT, obstacle);
        }
        List<Field> closingRow = new ArrayList<>();
        fields.add(closingRow);
        for (Field field : currRow) {
            Obstacle o = new Obstacle();
            closingRow.add(o);
            o.setNeighbor(Direction.UP, field);
            field.setNeighbor(Direction.DOWN, o);
        }
    }

    /**
     * Parancs vegrehajtasara hasznalt fuggveny.
     * @param command a vegrehajtando parancs szovegesen
     * @return a parancs vegrehajtasanak kimenete a kimeneti nyelvnek megfeleleloen
     */
    private static String execute(String command) {
        if(command.equals("X")) {
            return "END";
        }
        if(command.charAt(0) == 'W')
            return getWorkerState(Integer.parseInt(command.substring(1)));
        if(command.charAt(0) == 'F') {
            String[] split = command.substring(1).split(";");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            return getFieldState(x, y);
        }
        if(command.equals("S"))
            return getGameState();
        if(command.substring(0, command.length()-1).matches("\\d+")) {
            int id = Integer.parseInt(command.substring(0, command.length()-1));
            return commandWorker(id, command.substring(command.length() - 1));
        }
        return "Wrong command";
    }

    /**
     * A parameterkent megaddott azonositoju munkas allapotat adja vissza a kimeneti nyelvnek megfeleloen
     * @param idx A munkas azonositoja
     * @return A munkas allapotat leiro string
     */
    private static String getWorkerState(int idx) {
        return workers[idx].toString();
    }

    /**
     * Az x-y koordinataval megadott mezo tipusat es allapotat adja vissza a kimeneti nyelvnek megfelelo formatumban
     * @param x A mezo sora
     * @param y Hanyadik mezo a soron belul
     * @return A mezot leiro string
     */
    private static String getFieldState(int x, int y) {
        return Warehouse.getInstance().getFields().get(x).get(y).getLongDescs();
    }

    /**
     * A jatek teljes allapotat leiro szoveget adja vissza a kimeneti nyelvnek megfelelon
     * @return A jatek teljes allapotat leiro szoveg
     */
    private static String getGameState() {
        StringBuilder res = new StringBuilder("");
        for (Worker w : workers) {
            res.append(w.getScore()).append(' ').append(w.getStrength()).append(' ');
        }
        res.append('\n');
        for (List<Field> row : Warehouse.getInstance().getFields()) {
            for (Field field : row) {
                res.append(field.getShortDesc()).append(' ');
            }
            res.append('\n');
        }
        return res.toString();
    }

    /**
     * A megadott munkast utasitja a megadott paranccsal.
     * @param idx A munkas azonositoja
     * @param command A vegrehajtando parancs szovegesen
     * @return A parancs vegrehajtasanak kimenete a kimeneti nyelvnek megfeleloen
     */
    private static String commandWorker(int idx, String command) {
        if(command.equals("H")) {
            workers[idx].dropHoney();
            return "";
        }
        if(command.equals("O")) {
            workers[idx].dropOil();
            return "";
        }
        if(command.matches("[UDLR]")) {
            Direction d =
                    command.equals("U") ? Direction.UP :
                    command.equals("D") ? Direction.DOWN :
                    command.equals("R") ? Direction.RIGHT :
                    Direction.LEFT;
            return workers[idx].move(d) ? "true" : "false";
        }
        return "Wrong command for worker";
    }


    /**
     * HiddenHole-okat tartalmaz amiket mar letrehoztunk, de a letrehozaskor meg nem volt meg a switch-e
     * Arra hasznaljuk, hogy ha letrejon a hozza tartozo switch, ebbol ki tudja szedni
     */
    private static Map<Integer, HiddenHole> _lonelyHiddenHoleCache = new HashMap<>();
    /**
     * Dummy HiddenHoleokat, tartalmaz, amiknek mar a switch-e letrejott, de a switchhez tartozo HiddenHole meg nem volt meg.
     * A dummy HiddenHole mar hozza van rendelve a megfelelo switchhez, igy mikor infot kapunk a HiddenHole-rol, uj letrehozasa
     * helyett a dummyt frissitjuk.
     */
    private static Map<Integer, HiddenHole> _dummyHiddenHoleCache = new HashMap<>();
    /**
     * A bemeneti nyelvnek megfelelo, mezot leiro string bemenetbol kesziti el a megfelelo allapotu es tipusu mezot
     * @param desc A mezot leiro szoveg
     * @return Az input altal leirt mezo
     */
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

            FieldEffect eff = effect.equals("H") ? new Honey() : effect.equals("O") ? new Oil() : new Nothing();
            f.apply(eff);

            if(contained != null) {
                if(contained.equals("B"))
                    new Box().moveToField(f, null, 10000);
                else {
                    int id = Integer.parseInt(matcher.group("wid"));
                    workers[id].moveToField(f, null, 0);
                }
            }

            return f;
        }
        return null;
    }
}
