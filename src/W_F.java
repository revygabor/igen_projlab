
public class W_F implements UseCase{
	Worker w;
	Field f1;
	Field neighbor;
	
	/**
	 * Inicializálja  a teszt esetet.
	 * Létrehozza a változókat,
	 * beállítja a szükséges szomszédságokat,
	 * a Thinkeget a megfelelõ fieldre mozgatja
	 */
	public W_F() {
		w = new Worker();
	    f1 = new Floor();
	    neighbor = new Floor();
	        
	    f1.setNeighbor(Direction.UP, neighbor);
	        
	    w.moveToField(f1, null);
	}

	/**
	 * Elindítja a tesztet.
	 */
	@Override
	public void start() {
	    w.move(Direction.UP);
	}
}