public class W_B_W_Wall implements UseCase {

    Worker w;
    Thing w2;
    Field f1;
    Field neighbor1;
    Field neighbor2;
    Thing b;
    Obstacle wall;
    Warehouse wh;

    /**
     * Inicializálja  a teszt esetet.
     * Létrehozza a változókat,
     * beállítja a szükséges szomszédságokat,
     * a Thinkeget a megfelelő fieldre mozgatja
     */
    public W_B_W_Wall(){
        w = new Worker();
        w2 = new Worker();
        f1 = new Floor();
        neighbor1 = new Floor();
        neighbor2 = new Floor();
        wall = new Obstacle();
        b = new Box();
        wh = new Warehouse();

        f1.setNeighbour(Direction.RIGHT, neighbor1);
        neighbor1.setNeighbour(Direction.RIGHT, neighbor2);
        neighbor2.setNeighbour(Direction.RIGHT, wall);

        w.moveToField(f1, null);
        b.moveToField(neighbor1, null);
        w2.moveToField(neighbor2, null);
    }

    /**
     * Elindítja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.RIGHT);
    }
}
