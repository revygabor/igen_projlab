/**
 * A lyukat jelkepezi. A raerkezo objektumot befogadja,
 * majd kiveszi a jatekbol.
 */
public class Hole extends Field {
    public Hole() {
    }

    /**
     * Befogadja a raerkezo Thing-et, majd meghivja
     * rajta a die() fuggvenyt. Minden esetben true
     * a visszateresi erteke.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return mindig true, mert mindig elnyeli
     */
    @Override
    public boolean accept(Thing t, Direction d, int f) {

        if(t!=null)
            t.die();

        return true;
    }
}
