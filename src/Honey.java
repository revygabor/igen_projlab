/**
 * Az mézes(növelt) súrlódású Field effektje.
 */
public class Honey extends FieldEffect {
    /**
     * A suróldási együttható értéke
     */
    private int frictionCoefficient = 10;

    /**
     * @return A surlódási együttható értékét
     */
    @Override
    public int getFrictionCoefficient() {
        return frictionCoefficient;
    }
}