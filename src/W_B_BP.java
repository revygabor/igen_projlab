public class W_B_BP implements UseCase{
	Field neighbour;
	Box b;
	Worker w;
	BoxPlace bp;
	
    /**
     * Inicializalja  a teszt esetet.
     * Letrehozza a valtozokat,
     * beallitja a szukseges szomszedsagokat,
     * a Thinkeget a megfelelo fieldre mozgatja
     */
	public W_B_BP() {
		neighbour = new Floor();
	    b = new Box();
	    w = new Worker();
	    bp = new BoxPlace();
	        
	    neighbor.setNeighbour(Direction.UP, bp);
	        
	    b.moveToField(neighbour, null);
	}

	/**
	 * Elinditja a tesztet.
	 */
	@Override
	public void start() {
	    b.pushByWorker(w, Direction.UP);
	}
}
