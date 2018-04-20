/**
 * Az módusulatlan súrlódású Field effektje.
 */

public class Nothing extends FieldEffect {
    /**
     * A suróldási együttható értéke
     */
    private int frictionCoefficient = 5;

    /**
     * @return A surlódási együttható értékét
     */
    @Override
    public int getFrictionCoefficient() {
        return frictionCoefficient;
    }


    /**
     * A semmi effekt rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return A semmi effekt rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        return "N";
    }
}
