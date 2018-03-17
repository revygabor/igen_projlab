/**
 * Olyan mezo, amely nem rendelkezik kulonleges
 * tulajdonsagokkal.
 */
public class Floor extends Field {

    public Floor() {
        Main.functionCalled("Floor");

        Main.functionReturned("Floor", "Floor");
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott
     * “t” Thing befogadasara, melynek mozgasiranya “d” Direction.
     * Ha a befogadas sikeres volt, akkor true-val, egyebkent false-al
     * ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return sikeres -e a befogadás
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("accept");

        if(containedThing == null || d == null) {
            containedThing = t;

            Main.functionReturned("Floor.accept", "true");
            return true;
        }

        Field n = this.neighbor.get(d);
        boolean moveAccepted = t.pushOtherThing(containedThing, d);

        if(moveAccepted) {
            containedThing = t;
        }

        Main.functionReturned("Floor.accept", moveAccepted?"true":"false");
        return moveAccepted;
    }
}
