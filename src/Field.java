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

    public Field() {
        Main.functionCalled("Field");

        Main.functionReturned("Field", "Field");
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
    public void setNeighbour(Direction d, Field field) {
        Main.functionCalled("Field.setNeighbour");

        neighbor.put(d, field); //hashMap-be rakas

        Main.functionReturned("Field.setNeighbour", "");
    }

    /**
     * Megprobalja befogadni t Thing-et.
     * Ha eppen all rajta valami, akkor az erkezo t Thing-en meghivja
     * a pushOtherThing metodust. A visszateresi erteke jelzi, hogy
     * sikeres volt-e a befogadas.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return sikeres -e a befogadas
     */
    public abstract boolean accept(Thing t, Direction d);

    /**
     * d iranyba levo szomszedjan meghivja az accept függvenyt,
     * aminek atadja a containedThing-et, jelezven, hogy a Thing
     * szeretne odalepni. Visszateresi erteke jelzi, hogy
     * sikeres volt-e a mozgas.
     * @param d amelyik iranyba el kell mozgatni
     * @return sikeres -e a mozgatas
     */
    public boolean moveContainedThing(Direction d) {
        Main.functionCalled("Field.moveContainedThing");

        if(containedThing == null) {
            Main.functionReturned("Field.moveContainedThing", "true");
            return true;
        }

        Field n = neighbor.get(d);
        boolean moveAccepted = containedThing.moveToField(n, d);

        if(moveAccepted) {
            this.containedThing = null;
        }

        Main.functionReturned("Field.moveContainedThing", moveAccepted ?"true":"false");
        return moveAccepted;
    }

}
