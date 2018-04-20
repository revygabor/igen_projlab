/**
 * Absztrakt osztály a Field-en található
 * súrlódástvmódosító anyagokra.
 */

public abstract class FieldEffect {
    public abstract int getFrictionCoefficient();

    /**
     * Az effekt rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return Az effekt rovid (par betus) leirasa
     */
    public abstract String getShortDesc();
}
