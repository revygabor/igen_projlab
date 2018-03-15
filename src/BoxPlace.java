/**
 * Az a mezo, ahova a munkasoknak a ladakat kell tolniuk.
 */
public class BoxPlace extends Floor {
    private boolean boxIsHere = false;

    public BoxPlace() {
        Main.functionCalled("BoxPlace");

        Main.functionReturned("BoxPlace", "BoxPlace");
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott
     * “t” Thing befogadasara, melynek mozgasiranya “d” Direction.
     * Ha a befogadas sikeres volt, akkor true-val,
     * egyebkent false-al ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("accept");

        if(boxIsHere) {
           Main.functionReturned("BoxPlace.accept", "false");
           return false;
        }

        if(containedThing == null) {
            containedThing = t;

            if(t != null)
                t.arriveAtBoxPlace(this);

            Main.functionReturned("BoxPlace.accept", "true");
            return true;
        }

        Field f = neighbor.get(d);
        boolean moveAccepted = containedThing.moveToField(f);

        if(moveAccepted) {
            containedThing = t;

            if(t != null)
                t.arriveAtBoxPlace(this);
        }

        Main.functionReturned("BoxPlace.accept", moveAccepted ?"true":"false");
        return moveAccepted;
    }

    /**
     * Ez a fuggveny modositja a boxIsHere attributum erteket.
     * Ha egy lada kerult a mezore, akkor a boxIsHere erteke
     * true, egyebkent false.
     */
    public void signalBoxEntered() {
        Main.functionCalled("BoxPlace.signalBoxEntered");

        boxIsHere = true;

        Main.functionReturned("BoxPlace.signalBoxEntered", "void");
    }
}
