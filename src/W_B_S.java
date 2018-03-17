public class W_B_S implements UseCase{

		 Worker w;
		 Box b;
		 HiddenHole hh;
		 Switch s;
		 Field f1;
		 Field neighbor;
		 
		 /**
		  * Inicializalja  a teszt esetet.
		  * Letrehozza a valtozokat,
		  * beallitja a szukseges szomszedsagokat,
		  * a Thinkeget a megfelelo fieldre mozgatja
		  */
		 public W_B_S(){
		        w = new Worker();
		        b = new Box();
		        hh = new HiddenHole();
		        f1 = new Floor();
		        neighbor = new Floor();
		        s = new Switch(hh);
		        
		        f1.setNeighbour(Direction.RIGHT, neighbor);
		        neighbor.setNeighbour(Direction.RIGHT, s);
		        w.moveToField(f1, null);
		        b.moveToField(neighbor, null);
		    		        		        
		   }
		
		
		/**
	     * Elindítja a tesztet.
	     */
	    @Override
	    public void start() {
	    	w.move(Direction.RIGHT);
	    }
		
}
