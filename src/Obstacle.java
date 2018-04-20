/**
 * A falakat es oszlopokat reprezentalja.
 * Semmit sem enged magara lepni.
 */
public class Obstacle extends Field {
    public Obstacle(int x, int y) {
        super(x, y);
    }

    /**
     * Visszateresi erteke mindig false.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @param f a még rendelkezésre álló erő
     * @return false
     */
    @Override
    public boolean accept(Thing t, Direction d, int f) {
        return false;
    }
}
