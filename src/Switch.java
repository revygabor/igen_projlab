/**
 * A raerkezo vagy onnan tavozo Thing-nek jelzi,
 * hogy egy kapcsolot erintett a mozgas. Ha
 * megvaltoztatjak az allapotat, azt jelzi a hozzatartozo
 * HiddenHole-nak.
 */
public class Switch extends Field {
    private HiddenHole hiddenHole;
    private int id;
    private boolean isOn = false;

    /**
     * A nezet, ami ki fogja rajzolni.
     */
    ISwitchView switchView;

    public Switch(HiddenHole hiddenHole, int x, int y, int id, ISwitchView switchView) {
        super(x, y);
        this.hiddenHole = hiddenHole;
        this.id = id;
        this.switchView = switchView;
    }

    /**
     * Megvizsgalja, hogy van-e lehetoseg a parameterul kapott “t” Thing befogadasara, melynek mozgasiranya “d” Direction. Ha a befogadas sikeres volt, akkor meghivja rajta a enterOrLeaveSwitch() fuggvenyt es true-val ter vissza, egyebkent false-al ter vissza.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return sikeres volt -e a befogadas
     */
    @Override
    public boolean accept(Thing t, Direction d, int f) {

        if(containedThing == null || d == null) {
            containedThing = t;

            if(t != null)
                t.enterOrLeaveSwitch(this);  // az erkezo ralep a Switch-re

            return true;
        }

        Thing tmp = containedThing; // ha elhagyja meg ismernunk kell

        boolean moveAccepted = t.pushOtherThing(containedThing, d, f);

        if(moveAccepted) {
            tmp.enterOrLeaveSwitch(this); // a rajta levo elhagyja a Switch-et
            containedThing = t;

            if(t != null)
                t.enterOrLeaveSwitch(this); // az erkezo ralep a Switch-re
        }

        return moveAccepted;
    }

    /**
     * Meghivja a hozza tartozo hiddenHole-on a signalSwitch() fuggvenyt.
     */
    public void changeSwitch() {
        isOn = !isOn;
        hiddenHole.signalSwitch();
    }

    /**
     * A kapcsolo rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A kapcsolo rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        String desc = "S" + id;
        desc += isOn ? "N" : "F";
        desc += friction.getShortDesc();

        if(containedThing != null)
            desc += containedThing.getShortDesc();

        return desc;
    }

    /**
     * A kapcsolo hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return A kapcsolo hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        String desc = "Switch: ";

        if(containedThing != null)
            desc += containedThing.getLongDesc() + ", ";

        desc += isOn ? "On" : "Off";

        return desc;
    }

    @Override
    public void draw() {
        switchView.draw(this);
        friction.draw(this);

        if(containedThing!=null)
            containedThing.draw();
    }

    public boolean isOn() {
        return isOn;
    }
}
