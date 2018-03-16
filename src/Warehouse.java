public class Warehouse {

    private static Warehouse instance = new Warehouse();

    public void decreaseLivingWorkers() {
        Main.functionCalled("Warehouse.DecreaseLivingWorkers");
        Main.functionReturned("Warehouse.DecreaseLivingWorkers", "");
    }

    static Warehouse getInstance() {
        return instance;
    }

    private Warehouse() {}
}
