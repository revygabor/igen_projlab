import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private static Warehouse instance = new Warehouse();
    private int livingWorkers = 0;
    private List<List<Field>> fields;
    private List<Box> boxes;

    /**
     * Csokkenti az elo munkasokat szamlalo mezo erteket.
     */
    public void decreaseLivingWorkers() {
        livingWorkers--;
        checkEndGame();
    }

    /**
     * Inicializalo metodus a raktar objektumainak letrehozasara.
     */
    public void init(int startingWorkerCount, List<List<Field>> fields, List<Box> boxes) {
        this.fields = fields;
        livingWorkers = startingWorkerCount;
        this.boxes = boxes;
    }

    /**
     * Megvizsgalja, hogy a jatek a vegere ert-e (pl. a livingWorkers attributum erteke 1, vagy mar nincs tobb mozgathato Box).
     */
    public boolean checkEndGame() {
        if(livingWorkers<=1) return true;
        if(boxes.size() == 0) return true;

        for (Box b:boxes) {
            if(b.stillMoveable()) return false;
        }
        return true;
    }

    /**
     * Visszaadja a singleton Warehouse osztaly peldanyat
     * @return a Warehouse singleton osztaly peldanya
     */
    static Warehouse getInstance() {
        return instance;
    }

    private Warehouse() {}

    public List<List<Field>> getFields() {
        return fields;
    }

    public void draw() {
        for (List<Field> row : fields) {
            for (Field field : row) {
                field.draw();
            }
        }
    }
}
