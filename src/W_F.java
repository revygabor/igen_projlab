public class W_F implements UseCase{
    Worker w;
    Field f1;
    Field neighbour;
	
    /**
     * Inicializalja  a teszt esetet.
     * Letrehozza a valtozokat,
     * beallitja a szukseges szomszedsagokat,
     * a Thinkeget a megfelelo fieldre mozgatja
     */
    public W_F() {
	    w = new Worker();
	    f1 = new Floor();
	    neighbour = new Floor();
	        
        f1.setNeighbour(Direction.UP, neighbour);
	        
        w.moveToField(f1, null);
    }

    /**
     * Elinditja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.UP);
    }
}
