public class W_B_BP implements UseCase{
	Field neighbor;
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
		neighbor = new Floor();
	    b = new Box();
	    w = new Worker();
	    bp = new BoxPlace();
	        
	    neighbor.setNeighbor(Direction.UP, bp);
	        
	    b.moveToField(neighbor, null);
	}

	/**
	 * Elinditja a tesztet.
	 */
	@Override
	public void start() {
	    b.pushByWorker(w, Direction.UP);
	}
}