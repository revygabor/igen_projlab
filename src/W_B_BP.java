
public class W_B_BP implements UseCase{
	Field neighbor;
	Box b;
	Worker w;
	BoxPlace bp;
	
	/**
	 * Inicializ�lja  a teszt esetet.
	 * L�trehozza a v�ltoz�kat,
	 * be�ll�tja a sz�ks�ges szomsz�ds�gokat,
	 * a Thinkeget a megfelel� fieldre mozgatja
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
	 * Elind�tja a tesztet.
	 */
	@Override
	public void start() {
	    b.pushByWorker(w, Direction.UP);
	}
}