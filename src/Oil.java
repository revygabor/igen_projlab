/**
 * Az olajos(csökkentett) súrlódású Field effektje.
 */
public class Oil extends FieldEffect {
    /**
     * A suróldási együttható értéke
     */
    private int frictionCoefficient = 2;

    /**
     * A nezet, ami ki fogja rajzolni.
     */
    IOilDrawer oilDrawer;

    public Oil(IOilDrawer oilDrawer) {
        this.oilDrawer = oilDrawer;
    }

    /**
     * @return A surlódási együttható értékét
     */
    @Override
    public int getFrictionCoefficient() {
        return frictionCoefficient;
    }


    /**
     * Az olaj effekt rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return Az olaj rovid leirasa
     */
    @Override
    public String getShortDesc() {
        return "O";
    }

    @Override
    public void draw(Field field) {
        oilDrawer.Draw(this, field);
    }
}
