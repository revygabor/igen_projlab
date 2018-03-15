/**
 * A falakat es oszlopokat reprezentalja.
 * Semmit sem enged magara lepni.
 */
public class Obstacle extends Field {
    /**
     * Visszateresi erteke mindig false.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return false
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        return false;
    }
}
