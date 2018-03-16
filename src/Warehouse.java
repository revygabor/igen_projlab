public class Warehouse {

    private static Warehouse instance = new Warehouse();

    public void decreaseLivingWorkers() {
        Main.functionCalled("Warehouse.DecreaseLivingWorkers");
        Main.functionReturned("Warehouse.DecreaseLivingWorkers", "");
    }

    public void init() {
        Main.functionCalled("Warehouse.init");
        Main.functionReturned("Warehouse.init", "");
    }

    public void checkEndGame() {
        Main.functionCalled("Warehouse.checkEndGame");
        Main.functionReturned("Warehouse.checkEndGame", "");
    }

    static Warehouse getInstance() {
        return instance;
    }

    private Warehouse() {}
}
