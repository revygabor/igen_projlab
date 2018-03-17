/**
 * A lyukat jelkepezi. A raerkezo objektumot befogadja,
 * majd kiveszi a jatekbol.
 */
public class Hole extends Field {
    public Hole() {
        Main.functionCalled("Hole");

        Main.functionReturned("Hole", "Hole");
    }

    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("Hole.accept");

        if(t!=null)
            t.die();

        Main.functionReturned("Hole.accept", "true");
        return true;
    }
}
