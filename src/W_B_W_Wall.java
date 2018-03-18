public class W_B_W_Wall implements UseCase {

    Worker w;
    Worker w2;
    Field f1;
    Field neighbor1;
    Field neighbor2;
    Box b;
    Obstacle wall;
    Warehouse wh;

    /**
     * Inicializalja  a teszt esetet.
     * Letrehozza a valtozokat,
     * beallitja a szukseges szomszedsagokat,
     * a Thinkeget a megfelelo fieldre mozgatja
     */
    public W_B_W_Wall(){
        w = new Worker();
        w2 = new Worker();
        f1 = new Floor();
        neighbor1 = new Floor();
        neighbor2 = new Floor();
        wall = new Obstacle();
        b = new Box();
        wh = Warehouse.getInstance();

        f1.setNeighbor(Direction.RIGHT, neighbor1);
        neighbor1.setNeighbor(Direction.RIGHT, neighbor2);
        neighbor2.setNeighbor(Direction.RIGHT, wall);

        w.moveToField(f1, null);
        b.moveToField(neighbor1, null);
        w2.moveToField(neighbor2, null);
    }

    /**
     * Elinditja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.RIGHT);
    }
}
