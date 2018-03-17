public class W_B_H implements UseCase {

    Worker w;
    Box b1;
    Field f1;
    Field neighbor;

    /**
     * Inicializálja  a teszt esetet.
     * Létrehozza a változókat,
     * beállítja a szükséges szomszédságokat,
     * a Thinkeget a megfelelő fieldre mozgatja
     */
    public W_B_H(){
        w = new Worker();
        b1 = new Box();
        f1 = new Floor();
        neighbor = new Hole();

        f1.setNeighbour(Direction.RIGHT, neighbor);
        b1.moveToField(f1, null);
    }

    /**
     * Elindítja a tesztet.
     */
    @Override
    public void start() {
        b1.pushByWorker(w, Direction.RIGHT);
    }
}
