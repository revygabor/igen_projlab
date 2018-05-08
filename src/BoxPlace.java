/**
 * Az a mezo, ahova a munkasoknak a ladakat kell tolniuk.
 */
public class BoxPlace extends Field {
    private boolean boxIsHere = false;

    /**
     * A nezet, ami ki fogja rajzolni.
     */
    IBoxPlaceView boxPlaceView;

    public BoxPlace(int x, int y, IBoxPlaceView boxPlaceView) {
        super(x, y);
        this.boxPlaceView = boxPlaceView;
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott
     * “t” Thing befogadasara, melynek mozgasiranya “d” Direction.
     * Ha a befogadas sikeres volt, akkor true-val,
     * egyebkent false-al ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return
     */
    @Override
    public boolean accept(Thing t, Direction d, int f) {

        if(boxIsHere) {
           return false;
        }

        if(containedThing == null || d == null) {
            containedThing = t;

            if(t != null)
                t.arriveAtBoxPlace(this);

            return true;
        }

        Field n = neighbor.get(d);
        boolean moveAccepted = t.pushOtherThing(containedThing, d, f);

        if(moveAccepted) {
            containedThing = t;

            if(t != null)
                t.arriveAtBoxPlace(this);
        }

        return moveAccepted;
    }

    /**
     * Ez a fuggveny modositja a boxIsHere attributum erteket.
     * Ha egy lada kerult a mezore, akkor a boxIsHere erteke
     * true, egyebkent false.
     */
    public void signalBoxEntered() {

        boxIsHere = true;

    }

    /**
     * A ladahely rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A ladahely rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        String desc = "P" + friction.getShortDesc();

        if(containedThing != null)
            desc += containedThing.getShortDesc();

        return desc;
    }

    /**
     * A ladahely hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A ladahely hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        String desc = "BoxPlace";

        if(containedThing != null)
            desc += ": " + containedThing.getLongDesc();

        return desc;
    }

    @Override
    public void draw() {
        boxPlaceView.Draw(this);
        friction.draw(this);

        if(containedThing!=null)
            containedThing.draw();
    }
}
