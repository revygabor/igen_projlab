public class W_B_H implements UseCase {

    Worker w;
    Box b1;
    Field f1;
    Field neighbor;

    /**
     * Inicializalja  a teszt esetet.
     * Letrehozza a valtozokat,
     * beallitja a szukseges szomszedsagokat,
     * a Thinkeget a megfelelo fieldre mozgatja
     */
    public W_B_H(){
        w = new Worker();
        b1 = new Box();
        f1 = new Floor();
        neighbor = new Hole();

        f1.setNeighbor(Direction.RIGHT, neighbor);
        b1.moveToField(f1, null);
    }

    /**
     * Elinditja a tesztet.
     */
    @Override
    public void start() {
        b1.pushByWorker(w, Direction.RIGHT);
    }
}
