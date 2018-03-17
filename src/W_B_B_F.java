import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Inicializálja  a teszt esetet.
 * Létrehozza a változókat,
 * beállítja a szükséges szomszédságokat,
 * a Thinkeget a megfelelő fieldre mozgatja
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

        f1.setNeighbour(Direction.RIGHT, neighbor1);
        neighbor1.setNeighbour(Direction.RIGHT, neighbor2);
        w.moveToField(f1, null);
        b1.moveToField(neighbor1, null);

        System.out.println("Legyen második doboz? Ezáltal a mozgás sikertelen lesz. [Y/N]");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = br.readLine();

        //A kérdésre adott választól függően
        if(response.equals("Y") || response.equals("y")) {
            b2 = new Box();
            b2.moveToField(neighbor2, null);
            wall = new Obstacle();
            neighbor2.setNeighbour(Direction.RIGHT, wall);
        }
    }

    /**
     * Elindítja a tesztet.
     */
    @Override
    public void start() {
        w.move(Direction.RIGHT);
    }
}
