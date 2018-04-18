import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Inicializalja  a tesztesetet.
 * Letrehozza a valtozokat,
 * beallitja a szukseges szomszedsagokat,
 * a Thinkeget a megfelelo fieldre mozgatja
 */
public class W_B_B_F implements UseCase {
    Worker w;
    Field f1;
    Field neighbor1;
    Field neighbor2;
    Box b1;
    Box b2;
    Obstacle wall;

    public W_B_B_F() throws IOException {
        w = new Worker();
        f1 = new Floor();
        neighbor1 = new Floor();
        neighbor2 = new Floor();
        b1 = new Box();

        f1.setNeighbor(Direction.RIGHT, neighbor1);
        neighbor1.setNeighbor(Direction.RIGHT, neighbor2);
        w.moveToField(f1, null, 1);
        b1.moveToField(neighbor1, null, 1);

        System.out.println("Legyen masodik doboz? Ezaltal a mozgas sikertelen lesz. [Y/N]");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = br.readLine();

        //A kerdesre adott valasztol fuggoen
        if(response.equals("Y") || response.equals("y")) {
            b2 = new Box();
            b2.moveToField(neighbor2, null, 1);
            wall = new Obstacle();
            neighbor2.setNeighbor(Direction.RIGHT, wall);
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
