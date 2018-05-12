/**
 * Olyan mezo, amely nem rendelkezik kulonleges
 * tulajdonsagokkal.
 */
public class Floor extends Field {

    /**
     * A nezet, ami ki fogja rajzolni.
     */
    IFloorView floorView;

    public Floor(int x, int y, IFloorView floorView) {
        super(x, y);
        this.floorView = floorView;
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
        String desc = "_" + friction.getShortDesc();

        if(containedThing != null)
            desc += containedThing.getShortDesc();

        return desc;
    }


    /**
     * A padlo hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A padlo hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        String desc = "Floor";

        if(containedThing != null)
            desc += ": " + containedThing.getLongDesc();

        return desc;
    }

    @Override
    public void draw() {
        floorView.draw(this);
        friction.draw(this);

        if(containedThing!=null)
            containedThing.draw();
    }

    @Override
    public boolean isInhibitable(Direction d) {
        if(containedThing == null || !containedThing.isInhibitsField()) return true;
        else return neighbor.get(d).isInhibitable(d);
    }
}
