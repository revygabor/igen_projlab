import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class W_W_HH implements UseCase{

	 Worker w;
	 Worker w2;
	 HiddenHole hh;
	 Field f1;
	 Field neighbor;
	 
	 /**
	  * Inicializalja  a teszt esetet.
	  * Letrehozza a valtozokat,
	  * beallitja a szukseges szomszedsagokat,
	  * a Thinkeget a megfelelo fieldre mozgatja
	  */
	 public W_W_HH()throws IOException{
	        w = new Worker();
	        w2 = new Worker();
	        hh = new HiddenHole();
	        f1 = new Floor();
	        neighbor = new Floor();
	        
	        

	        f1.setNeighbor(Direction.RIGHT, neighbor);
	        neighbor.setNeighbor(Direction.RIGHT, hh);
	        w.moveToField(f1, null);
	        w2.moveToField(neighbor, null);
	        
	        System.out.println("A rejtett lyuk nyitva legyen? Ezaltal a munkas beleesik. [Y/N]");
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String response = br.readLine();

	        //A kerdesre adott valasztol fuggoen (alapertelmezetten a padlo van beallitva). 
	        if(response.equals("Y") || response.equals("y")) {
	            hh.signalSwitch();
	        }
	        
	   }
	
	
	/**
     * Elinditja a tesztet.
     */
    @Override
    public void start() {
    	w.move(Direction.RIGHT);
    }
	
}
