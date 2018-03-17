
public class W_F implements UseCase{
	Worker w;
	Field f1;
	Field neighbor;
	
	/**
	 * Inicializ�lja  a teszt esetet.
	 * L�trehozza a v�ltoz�kat,
	 * be�ll�tja a sz�ks�ges szomsz�ds�gokat,
	 * a Thinkeget a megfelel� fieldre mozgatja
	 */
	public W_F() {
		w = new Worker();
	    f1 = new Floor();
	    neighbor = new Floor();
	        
	    f1.setNeighbor(Direction.UP, neighbor);
	        
	    w.moveToField(f1, null);
	}

	/**
	 * Elind�tja a tesztet.
	 */
	@Override
	public void start() {
	    w.move(Direction.UP);
	}
}