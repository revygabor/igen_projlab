import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InGameState extends AppState {

    private Worker[] workers;
    public static final int TILES_START_X = 50;
    public static final int TILES_START_Y = 50;
    public static final int TILE_HEIGHT = 50;
    public static final int TILE_WIDTH = 50;
    public static final int PLAYER_STATS_START_X = 720;
    public static final int PLAYER_STATS_START_Y = 50;
    public static final int PLAYER_STATS_DY = 100;

    private final Rectangle menuButtonRect = new Rectangle(720, 500, 200,100);
    public static final Font MENU_BUTTON_FONT = new Font("Arial", 50);

    private List<Map<KeyCode, Direction>> keyMapMove = new ArrayList<>(); {
        //player 0 - WASD
        HashMap<KeyCode, Direction> player0 = new HashMap<>();
        player0.put(KeyCode.W, Direction.UP);
        player0.put(KeyCode.S, Direction.DOWN);
        player0.put(KeyCode.A, Direction.LEFT);
        player0.put(KeyCode.D, Direction.RIGHT);
        keyMapMove.add(player0);
        //player 1 - Arrows
        HashMap<KeyCode, Direction> player1 = new HashMap<>();
        player1.put(KeyCode.UP, Direction.UP);
        player1.put(KeyCode.DOWN, Direction.DOWN);
        player1.put(KeyCode.LEFT, Direction.LEFT);
        player1.put(KeyCode.RIGHT, Direction.RIGHT);
        keyMapMove.add(player1);
        //player 2 - IJKL
        HashMap<KeyCode, Direction> player2 = new HashMap<>();
        player2.put(KeyCode.I, Direction.UP);
        player2.put(KeyCode.K, Direction.DOWN);
        player2.put(KeyCode.J, Direction.LEFT);
        player2.put(KeyCode.L, Direction.RIGHT);
        keyMapMove.add(player2);
        //player 3 - TFGH
        HashMap<KeyCode, Direction> player3 = new HashMap<>();
        player3.put(KeyCode.T, Direction.UP);
        player3.put(KeyCode.G, Direction.DOWN);
        player3.put(KeyCode.F, Direction.LEFT);
        player3.put(KeyCode.H, Direction.RIGHT);
        keyMapMove.add(player3);
        //player 4 - Numpad 8456
        HashMap<KeyCode, Direction> player4 = new HashMap<>();
        player4.put(KeyCode.NUMPAD8, Direction.UP);
        player4.put(KeyCode.NUMPAD5, Direction.DOWN);
        player4.put(KeyCode.NUMPAD4, Direction.LEFT);
        player4.put(KeyCode.NUMPAD6, Direction.RIGHT);
        keyMapMove.add(player4);
        //player 5 - F2,123
        HashMap<KeyCode, Direction> player5 = new HashMap<>();
        player5.put(KeyCode.F2, Direction.UP);
        player5.put(KeyCode.DIGIT2, Direction.DOWN);
        player5.put(KeyCode.DIGIT1, Direction.LEFT);
        player5.put(KeyCode.DIGIT3, Direction.RIGHT);
        keyMapMove.add(player5);
    }

    private List<KeyCode> keyMapOil = new ArrayList<>();
    {
        keyMapOil.add(KeyCode.Q);
        keyMapOil.add(KeyCode.PERIOD);
        keyMapOil.add(KeyCode.U);
        keyMapOil.add(KeyCode.R);
        keyMapOil.add(KeyCode.NUMPAD7);
        keyMapOil.add(KeyCode.F1);
    }
    private List<KeyCode> keyMapHoney = new ArrayList<>();
    {
        keyMapHoney.add(KeyCode.E);
        keyMapHoney.add(KeyCode.MINUS);
        keyMapHoney.add(KeyCode.O);
        keyMapHoney.add(KeyCode.Z);
        keyMapHoney.add(KeyCode.NUMPAD9);
        keyMapHoney.add(KeyCode.F3);
    }


    private EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(menuButtonRect.contains(event.getX(), event.getY()))
                window.setAppState(new MenuState(window));
        }
    };
    private EventHandler<KeyEvent> keyPressedHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            for (int i = 0; i < keyMapMove.size(); i++) {
                Map<KeyCode, Direction> playerKeyMap = keyMapMove.get(i);
                if(playerKeyMap.containsKey(event.getCode()) && i < workers.length && workers[i].isAlive()) {
                    workers[i].move(playerKeyMap.get(event.getCode()));
                    draw();
                    return;
                }
            }
            int playerId = keyMapOil.indexOf(event.getCode());
            if(playerId >= 0) {
                workers[playerId].dropOil();
                draw();
                return;
            }
            playerId = keyMapHoney.indexOf(event.getCode());
            if(playerId >= 0) {
                workers[playerId].dropHoney();
                draw();
            }
        }
    };

    private String errorReadingFile = null;
    public InGameState(String mapFilePath, int playerNumber, JFXSokobanWindow window) {
        super(window);
        workers = new Worker[playerNumber];
        try {
            readInputFile(mapFilePath);
        } catch (IOException e) {
            errorReadingFile = e.getMessage();
        }
    }

    @Override
    public void draw() {
        GraphicsContext g = window.getGraphics();
        g.clearRect(0,0,2000,2000);
        g.setFill(Color.BLACK);
        g.fillRect(0,0,2000,2000);
        if(errorReadingFile != null) {
            g.setFill(Color.RED);
            g.setFont(new Font("Arial", 25));
            g.fillText(errorReadingFile, 0, 0);
        }
        else {
            Warehouse.getInstance().draw();
        }
        g.setFill(Color.gray(0.2));
        g.fillRect(menuButtonRect.getX(), menuButtonRect.getY(), menuButtonRect.getWidth(), menuButtonRect.getHeight());
        g.setStroke(Color.WHITE);
        g.strokeRect(menuButtonRect.getX(), menuButtonRect.getY(), menuButtonRect.getWidth(), menuButtonRect.getHeight());
        g.setTextBaseline(VPos.CENTER);
        g.setTextAlign(TextAlignment.CENTER);
        double textY = menuButtonRect.getY() + menuButtonRect.getHeight() / 2;
        double textX = menuButtonRect.getX() + menuButtonRect.getWidth() / 2;
        g.setFill(Color.WHITE);
        g.setFont(MENU_BUTTON_FONT);
        g.fillText("Menü", textX, textY);
    }

    @Override
    public EventHandler<MouseEvent> getClickHandler() {
        return clickHandler;
    }

    @Override
    public EventHandler<KeyEvent> getKeyPressedHandler() {
        return keyPressedHandler;
    }


    private List<Box> boxes=new ArrayList<>();
    /***
     * Beolvassa a parameterkent megadott eleresi uton talalhato bemeneti file-t
     * @param path A file eleresi utja
     * @throws IOException A file olvasasa kozben hiba tortent
     */
    private void readInputFile(String path) throws IOException {
        boxes.clear();
        //file beolvasasa soronkent
        BufferedReader file = new BufferedReader(new FileReader(path));
        String line = file.readLine();

        //elso sor - munkasok adatai szokozzel elvalasztva
        String[] split = line.split(" ");
        for(int i = 0; i<workers.length; i++) {
            boolean isDead = split[2 * i].equals("X");
            int score = isDead ? -1 : Integer.parseInt(split[2 * i]);
            int strength = Integer.parseInt(split[2 * i + 1]);
            workers[i] = new Worker(score, strength, i, !isDead, workerView, honeyDrawer, oilDrawer);
        }

        //palya letrehozasa
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
                    Obstacle o = new Obstacle(i, 0, obstacleView);
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
            Obstacle obstacle = new Obstacle(0, rowNum, obstacleView); //implicit fal a sor elejen
            obstacle.setNeighbor(Direction.UP, prevRow.get(0));
            prevRow.get(0).setNeighbor(Direction.DOWN, obstacle);
            currRow.add(obstacle);
            Field f = obstacle;
            int i;
            for (i = 0; i < split.length; i++) {
                String fieldDesc = split[i];
                f = fieldFromInput(fieldDesc, i+1, rowNum);
                if(f == null) {
                    System.out.println("Error initializing fields, wrong field description: " + fieldDesc);
                    return;
                }
                currRow.add(f);
                if(i >= prevRow.size()) {
                    Field obs = new Obstacle(i+1, rowNum-1, obstacleView);
                    f.setNeighbor(Direction.UP, obs);
                    obs.setNeighbor(Direction.DOWN, f);
                    Field prevLast = prevRow.get(prevRow.size() - 1);
                    prevRow.add(obs);
                    prevLast.setNeighbor(Direction.RIGHT, obs);
                    obs.setNeighbor(Direction.LEFT, prevLast);
                } else {
                    Field uNeighbor = prevRow.get(i+1);
                    f.setNeighbor(Direction.UP, uNeighbor);
                    uNeighbor.setNeighbor(Direction.DOWN, f);
                }
                Field lNeighbor = currRow.get(i); //egyel el vagyunk csuszva, most az i. van a leirtak kozul,
                // de mivel az elejen van egy obstacle, igy a sorban az i. az eloz
                lNeighbor.setNeighbor(Direction.RIGHT, f);
                f.setNeighbor(Direction.LEFT, lNeighbor);
            }
            obstacle = new Obstacle(i+1, rowNum, obstacleView); //implicit fal a sor vegen
            obstacle.setNeighbor(Direction.LEFT, f);
            f.setNeighbor(Direction.RIGHT, obstacle);
            currRow.add(obstacle);
            rowNum++;
        }
        List<Field> closingRow = new ArrayList<>();
        fields.add(closingRow);
        for (int i = 0; i < currRow.size(); i++) {
            Field field = currRow.get(i);
            Obstacle o = new Obstacle(i, rowNum, obstacleView);
            closingRow.add(o);
            o.setNeighbor(Direction.UP, field);
            field.setNeighbor(Direction.DOWN, o);
        }

        Warehouse.getInstance().init(workers.length, fields, new ArrayList<>(boxes));
    }

    /**
     * HiddenHole-okat tartalmaz amiket mar letrehoztunk, de a letrehozaskor meg nem volt meg a switch-e
     * Arra hasznaljuk, hogy ha letrejon a hozza tartozo switch, ebbol ki tudja szedni
     */
    private Map<Integer, HiddenHole> _lonelyHiddenHoleCache = new HashMap<>();
    /**
     * Dummy HiddenHoleokat, tartalmaz, amiknek mar a switch-e letrejott, de a switchhez tartozo HiddenHole meg nem volt meg.
     * A dummy HiddenHole mar hozza van rendelve a megfelelo switchhez, igy mikor infot kapunk a HiddenHole-rol, uj letrehozasa
     * helyett a dummyt frissitjuk.
     */
    private Map<Integer, HiddenHole> _dummyHiddenHoleCache = new HashMap<>();
    private IBoxPlaceView boxPlaceView = new JFXBoxPlaceView(window);
    private IBoxView boxView = new JFXBoxView(window);
    private IFloorView floorView = new JFXFloorView(window);
    private IHoleView holeView = new JFXHoleView(window);
    private IHoneyDrawer honeyDrawer = new JFXHoneyDrawer(window);
    private IObstacleView obstacleView = new JFXObstacleView(window);
    private IOilDrawer oilDrawer = new JFXOilDrawer(window);
    private ISwitchView switchView = new JFXSwitchView(window);
    private IWorkerView workerView = new JFXWorkerView(window);
    /**
     * A bemeneti nyelvnek megfelelo, mezot leiro string bemenetbol kesziti el a megfelelo allapotu es tipusu mezot
     * @param desc A mezot leiro szoveg
     * @return Az input altal leirt mezo
     */
    private Field fieldFromInput(String desc, int x, int y) {
        Pattern p = Pattern.compile("^(?<fieldtype>H|(H(?<hid>\\d+)(?<state>[H_]))|(S(?<sid>\\d+)(?<onoff>[NF]))|P|O|_)(?<effect>[HON])(?<contained>(W(?<wid>\\d+))|B)?");
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
                f = new Hole(x, y, holeView);
            else if(fieldtype.equals("P"))
                f = new BoxPlace(x, y, boxPlaceView);
            else if(fieldtype.equals("O"))
                f = new Obstacle(x, y, obstacleView);
            else if(fieldtype.equals("_"))
                f = new Floor(x, y, floorView);
            else if(fieldtype.charAt(0) == 'H') {
                int id = Integer.parseInt(matcher.group("hid"));
                if(_dummyHiddenHoleCache.containsKey(id)) {
                    f = _dummyHiddenHoleCache.get(id);
                    ((HiddenHole) f).setCoords(x, y);
                } else {
                    f = new HiddenHole(x, y, id, holeView, floorView);
                    _lonelyHiddenHoleCache.put(id, (HiddenHole) f);
                }
                String state = matcher.group("state");
                if(state.equals("H"))
                    ((HiddenHole)f).signalSwitch();
            } else {
                int id = Integer.parseInt(matcher.group("sid"));
                if(_lonelyHiddenHoleCache.containsKey(id))
                    f = new Switch(_lonelyHiddenHoleCache.get(id), x, y, id, switchView);
                else {
                    HiddenHole dummyHH = new HiddenHole(-1, -1, id, holeView, floorView);
                    f = new Switch(dummyHH, x, y, id, switchView);
                    _dummyHiddenHoleCache.put(id, dummyHH);
                }
                String onoff = matcher.group("onoff");
//                if(onoff.equals("N"))
//                    ((Switch)f).changeSwitch(); //nem kell mert a doboz rakeruleskor beallitja, persze ez gond is lehet mert az onoff igy nem csinal semmit
            }

            FieldEffect eff = effect.equals("H") ? new Honey(honeyDrawer) : effect.equals("O") ? new Oil(oilDrawer) : new Nothing();
            f.apply(eff);

            if(contained != null) {
                if(contained.equals("B")) {
                    Box box = new Box(boxView);
                    box.moveToField(f, null, 10000);
                    boxes.add(box);
                }
                else {
                    int id = Integer.parseInt(matcher.group("wid"));
                    if(id < workers.length)
                        workers[id].moveToField(f, null, 0);
                }
            }

            return f;
        }
        return null;
    }
}
