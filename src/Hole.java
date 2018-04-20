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

    /**
     * A lyuk rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A lyuk rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        return null;//TODO
    }

    /**
     * A lyuk hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A lyuk hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        return null;//TODO
    }
}
