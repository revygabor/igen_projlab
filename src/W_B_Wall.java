public class W_B_Wall implements UseCase {
    Worker w;
    Field f1;
    Box b;
    Field neighbor1;
    Obstacle wall;

    /**
     * Inicializalja  a teszt esetet.
     * Letrehozza a valtozokat,
     * beallitja a szukseges szomszedsagokat,
     * a Thinkeget a megfelelo fieldre mozgatja
     */
    public W_B_Wall(){
        w = new Worker();
        f1 = new Floor();
        b = new Box();
        neighbor1 = new Floor();
        wall = new Obstacle();

        f1.setNeighbor(Direction.UP, neighbor1);
        neighbor1.setNeighbor(Direction.UP, wall);

        w.moveToField(f1, null);
        b.moveToField(neighbor1, null);
    }

    /**
     * Elinditja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.UP);
    }
}
