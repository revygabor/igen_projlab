/**
 * Olyan mezo, amely eleinte Floor-kent viselkedik,
 * azonban a hozza tartozo Switch aktivalasaval lyuk
 * lesz.
 */
public class HiddenHole extends Field {
    private Floor floor = new Floor();
    private Hole hole = new Hole();
    private Field activeComponent;

    public HiddenHole() {
        Main.functionCalled("HiddenHole");

        activeComponent = floor;

        Main.functionReturned("HiddenHole", "HiddenHole");
    }

    /**
     * Beállítja a Floor komponensén a szomszédot.
     * A Hole komponensen nem kell.
     * @param d az az irany, amelyikben a beallitando szomszedos
     *           mezo van
     * @param field a beallitando szomszedos mezo
     */
    @Override
    public void setNeighbour(Direction d, Field field) {
        Main.functionCalled("HiddenHole.setNeighbour");

        floor.setNeighbour(d, field);

        Main.functionReturned("HiddenHole.setNeighbour", "void");
    }

    /**
     * Mindig az allapotanak megfelelo objektumanak accept
     * metodusat hivja meg. Floor eseten a floor-et,
     * Hole eseten a Hole-et.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return sikeres -e a befogadas
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("HiddenHole.accept");

        boolean moveAccepted =  activeComponent.accept(t, d);

        Main.functionReturned("HiddenHole.accept", moveAccepted?"true":"false");
        return moveAccepted;
    }

    /**
     * A hozza tartozo Switch-tol jelet kapott, hogy allapotot
     * kell valtoztatnia. Ekkor az activeComponent viselkedese
     * Hole-rol Floor-ra vagy Floor-rol Hole-ra valtozik.
     */
    public void signalSwitch() {
        Main.functionCalled("HiddenHole.signalSwitch");

        Field newActiveComponent;
        if(activeComponent == floor) {
            newActiveComponent = hole;
        }
        else
            newActiveComponent = floor;

        newActiveComponent.accept(activeComponent.containedThing, Direction.DOWN); //aki eddig a floor-on volt, meghal
        activeComponent.containedThing = null;
        activeComponent = newActiveComponent;


        Main.functionReturned("signalSwitch", "void");
    }

    /**
     * d iranyba levo szomszedjan meghivja az accept függvenyt,
     * aminek atadja a containedThing-et, jelezven, hogy a Thing
     * szeretne odalepni. Visszateresi erteke jelzi, hogy
     * sikeres volt-e a mozgas. Ebben az esetben Floor eseten
     * mukodik igy, Hole eseten mindig true az ertek.
     * @param d amelyik iranyba el kell mozgatni
     * @return
     */
    public boolean moveContainedThing(Direction d) {
        Main.functionCalled("Hiddenhole.moveContainedThing");

        boolean moveAccepted = activeComponent.moveContainedThing(d);

        Main.functionReturned("Hiddenhole.moveContainedThing", moveAccepted?"true":"false");
        return moveAccepted;
    }
}
