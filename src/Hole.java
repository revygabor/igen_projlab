/**
 * A lyukat jelkepezi. A raerkezo objektumot befogadja,
 * majd kiveszi a jatekbol.
 */
public class Hole extends Field {
    public Hole() {
        Main.functionCalled("Hole");

        Main.functionReturned("Hole", "Hole");
    }

    /**
     * Befogadja a raerkezo Thing-et, majd meghivja
     * rajta a die() fuggvenyt. Minden esetben true
     * a visszateresi erteke.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return mindig true, mert mindig elnyeli
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("Hole.accept");

        if(t!=null)
            t.die();

        Main.functionReturned("Hole.accept", "true");
        return true;
    }
}
