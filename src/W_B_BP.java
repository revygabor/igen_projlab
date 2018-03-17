
public class W_B_BP implements UseCase{
	Field neighbor;
	Box b;
	Worker w;
	BoxPlace bp;
	
	/**
	 * Inicializálja  a teszt esetet.
	 * Létrehozza a változókat,
	 * beállítja a szükséges szomszédságokat,
	 * a Thinkeget a megfelelõ fieldre mozgatja
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
	 * Elindítja a tesztet.
	 */
	@Override
	public void start() {
	    b.pushByWorker(w, Direction.UP);
	}
}