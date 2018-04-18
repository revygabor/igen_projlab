/**
 * Az a mezo, ahova a munkasoknak a ladakat kell tolniuk.
 */
public class BoxPlace extends Floor {
    private boolean boxIsHere = false;

    public BoxPlace() {
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
}
