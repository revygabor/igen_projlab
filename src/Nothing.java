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
}
