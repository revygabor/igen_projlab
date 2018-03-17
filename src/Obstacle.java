/**
 * A falakat es oszlopokat reprezentalja.
 * Semmit sem enged magara lepni.
 */
public class Obstacle extends Field {
    public Obstacle() {
        Main.functionCalled("Obstacle");

        Main.functionReturned("Obstacle", "Obstacle");
    }

    /**
     * Visszateresi erteke mindig false.
     * @param t befogadando valami
     * @param d ameyik iranyba mozog a valami
     * @return false
     */
    @Override
    public boolean accept(Thing t, Direction d) {
        Main.functionCalled("Obstacle.accept");
        Main.functionReturned("Obstacle.accept", "false");
        return false;
    }
}
