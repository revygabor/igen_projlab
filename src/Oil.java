/**
 * Az olajos(csökkentett) súrlódású Field effektje.
 */
public class Oil extends FieldEffect {
    /**
     * A suróldási együttható értéke
     */
    private int frictionCoefficient = 2;

    /**
     * @return A surlódási együttható értékét
     */
    @Override
    public int getFrictionCoefficient() {
        return frictionCoefficient;
    }
}
