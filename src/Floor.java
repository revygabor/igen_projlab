/**
 * Olyan mezo, amely nem rendelkezik kulonleges
 * tulajdonsagokkal.
 */
public class Floor extends Field {

    public Floor(int x, int y) {
        super(x, y);
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott
     * “t” Thing befogadasara, melynek mozgasiranya “d” Direction.
     * Ha a befogadas sikeres volt, akkor true-val, egyebkent false-al
     * ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return sikeres -e a befogadás
     */
    @Override
    public boolean accept(Thing t, Direction d, int f) {

        if(containedThing == null || d == null) {
            containedThing = t;

            return true;
        }

        Field n = this.neighbor.get(d);
        boolean moveAccepted = t.pushOtherThing(containedThing, d, f);

        if(moveAccepted) {
            containedThing = t;
        }

        return moveAccepted;
    }


    /**
     * A padlo rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A padlo rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        return "_" + friction.getShortDesc() + containedThing.getShortDesc();
    }


    /**
     * A padlo hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A padlo hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        return "Floor: " + containedThing.getLongDesc();
    }
}
