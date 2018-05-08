/**
 * Az mézes(növelt) súrlódású Field effektje.
 */
public class Honey extends FieldEffect {
    /**
     * A suróldási együttható értéke
     */
    private int frictionCoefficient = 10;

    /**
     * A nezet, ami ki fogja rajzolni.
     */
    IHoneyDrawer honeyDrawer;

    public Honey(IHoneyDrawer honeyDrawer) {
        this.honeyDrawer = honeyDrawer;
    }

    /**
     * @return A surlódási együttható értékét
     */
    @Override
    public int getFrictionCoefficient() {
        return frictionCoefficient;
    }


    /**
     * A mez effekt rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A mez rovid leirasa
     */
    @Override
    public String getShortDesc() {
        return "H";
    }

    @Override
    public void draw(Field field) {
        honeyDrawer.draw(this, field);
    }
}
