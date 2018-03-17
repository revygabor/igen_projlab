public class W_B_Wall implements UseCase {
    Worker w;
    Field f1;
    Box b;
    Field neighbor1;
    Obstacle wall;

    /**
     * Inicializ�lja  a teszt esetet.
     * L�trehozza a v�ltoz�kat,
     * be�ll�tja a sz�ks�ges szomsz�ds�gokat,
     * a Thinkeget a megfelel� fieldre mozgatja
     */
    public W_B_Wall(){
        w = new Worker();
        f1 = new Floor();
        b = new Box();
        neighbor1 = new Floor();
        wall = new Obstacle();

        f1.setNeighbour(Direction.UP, neighbor1);
        neighbor1.setNeighbour(Direction.UP, wall);

        w.moveToField(f1, null);
        b.moveToField(neighbor1, null);
    }

    /**
     * Elind�tja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.UP);
    }
}