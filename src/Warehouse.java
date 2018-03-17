public class Warehouse {

    private static Warehouse instance = new Warehouse();

    /**
     * Csokkenti az elo munkasokat szamlalo mezo erteket.
     */
    public void decreaseLivingWorkers() {
        Main.functionCalled("Warehouse.DecreaseLivingWorkers");
        Main.functionReturned("Warehouse.DecreaseLivingWorkers", "");
    }

    /**
     * Inicializalo metodus a raktar objektumainak letrehozasara.
     */
    public void init() {
        Main.functionCalled("Warehouse.init");
        Main.functionReturned("Warehouse.init", "");
    }

    /**
     * Megvizsgalja, hogy a jatek a vegere ert-e (pl. a livingWorkers attributum erteke 1, vagy mar nincs tobb mozgathato Box).
     */
    public void checkEndGame() {
        Main.functionCalled("Warehouse.checkEndGame");
        Main.functionReturned("Warehouse.checkEndGame", "");
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
