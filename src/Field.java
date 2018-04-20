import java.util.HashMap;
import java.util.Map;

/**
 * Absztrakt osztaly, a mezok alapjat kepezi. Feladata, hogy kezelje
 * a raerkezo Thing-eket, es kesobb majd a Thing keresenek megfelelo
 * szomszedjanak atadja. A mezok kozott levo ket iranyba navigalhato
 * kapcsolatok a palyat irjak le.
 */
public abstract class Field {
    protected Map<Direction, Field> neighbor = new HashMap<>();
    protected Thing containedThing;
    protected FieldEffect friction = new Nothing();

    public Field() {
    }

    /**
     * Beallitja az adott mezo szomszedjat amegfelelo iranyban.
     * Az aodtt iranyba levo mezoket egy hashmapben tarolja,
     * melyben (irany, szomszed) parok vannak.
     *
     * @param d az az irany, amelyikben a beallitando szomszedos
     *           mezo van
     * @param field a beallitando szomszedos mezo
     */
    public void setNeighbor(Direction d, Field field) {
        neighbor.put(d, field); //hashMap-be rakas
    }

    /**
     * Megprobalja befogadni t Thing-et.
     * Ha eppen all rajta valami, akkor az erkezo t Thing-en meghivja
     * a pushOtherThing metodust. A visszateresi erteke jelzi, hogy
     * sikeres volt-e a befogadas.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return sikeres -e a befogadas
     */
    public abstract boolean accept(Thing t, Direction d, int f);

    /**
     * d iranyba levo szomszedjan meghivja az accept függvenyt,
     * aminek atadja a containedThing-et, jelezven, hogy a Thing,
     * szeretne odalepni. Visszateresi erteke jelzi, hogy
     * sikeres volt-e a mozgas.
     * @param d amelyik iranyba el kell mozgatniű
     * @param f a még rendelkezésre álló erő
     * @return sikeres -e a mozgatas
     */
    public boolean moveContainedThing(Direction d, int f) {

        if(containedThing == null) {
            return true;
        }

        Field n = neighbor.get(d);
        boolean moveAccepted = containedThing.moveToField(n, d, f);

        if(moveAccepted) {
            this.containedThing = null;
        }

        return moveAccepted;
    }

    /**
     * Új súrlódási effectet állítbe a mezőre
     * @param effect az új effect
     */
    public void apply(FieldEffect effect){
        friction = effect;
    }

    /**
     * A mezo rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A mezo rovid (par betus) leirasa
     */
    abstract public String getShortDesc();

    /**
     * A mezo hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A mezo hosszu leirasa
     */
    abstract public String getLongDesc();

    /**
     * A mezo X poziciojat adja meg
     * @return X pozicio
     */
    public int getXPos() {//TODO
        return 0;
    }

    /**
     * A mezo Y poziciojat adja meg
     * @return Y pozicio
     */
    public int getYPos() {//TODO
        return 0;
    }

}
