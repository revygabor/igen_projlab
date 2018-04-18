public class Warehouse {

    private static Warehouse instance = new Warehouse();
    private int livingWorkers = 0;
    private Field[] fields;

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
    public void init(int startingWorkerCount, Field[] fields) {
        this.fields = fields;
        livingWorkers = startingWorkerCount;
    }

    /**
     * Megvizsgalja, hogy a jatek a vegere ert-e (pl. a livingWorkers attributum erteke 1, vagy mar nincs tobb mozgathato Box).
     */
    public void checkEndGame() {

    }

    /**
     * Visszaadja a singleton Warehouse osztaly peldanyat
     * @return a Warehouse singleton osztaly peldanya
     */
    static Warehouse getInstance() {
        return instance;
    }

    private Warehouse() {}
}
