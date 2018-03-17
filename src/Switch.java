/**
 * A raerkezo vagy onnan tavozo Thing-nek jelzi,
 * hogy egy kapcsolot erintett a mozgas. Ha
 * megvaltoztatjak az allapotat, azt jelzi a hozzatartozo
 * HiddenHole-nak.
 */
public class Switch extends Field {
    private HiddenHole hiddenHole;

    public Switch(HiddenHole hiddenHole) {
        Main.functionCalled("Switch");

        this.hiddenHole = hiddenHole;

        Main.functionReturned("Switch", "Switch");
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott “t” Thing befogadasara, melynek mozgasiranya “d” Direction. Ha a befogadas sikeres volt, akkor meghivja rajta a enterOrLeaveSwitch() fuggvenyt es true-val ter vissza, egyebkent false-al ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return sikeres volt -e a befogadas
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("Switch.accept");

        if(containedThing == null || d == null) {
            containedThing = t;

            if(t != null)
                t.enterOrLeaveSwitch(this);

            Main.functionReturned("Switch.accept", "true");
            return true;
        }

        Field n = this.neighbor.get(d);
        boolean moveAccepted = t.pushOtherThing(containedThing, d);

        if(moveAccepted) {
            containedThing = t;

            if(t != null)
                t.enterOrLeaveSwitch(this);
        }

        Main.functionReturned("Switch.accept", moveAccepted?"true":"false");
        return moveAccepted;
    }

    /**
     * Meghivja a hozza tartozo hiddenHole-on a signalSwitch() fuggvenyt.
     */
    public void changeSwitch() {
        Main.functionCalled("Switch.changeSwitch");

        hiddenHole.signalSwitch();

        Main.functionReturned("Switch.changeSwitch", "");
    }
}
