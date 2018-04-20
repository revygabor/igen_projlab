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

    /**
     * Az akadaly rovid leirasat adja meg, amit a teljes jatekallapot leirasakor hasznalunk
     * @return Az akadaly rovid (par betus) leirasa
     */
    @Override
    public String getShortDesc() {
        return "O" + friction.getShortDesc();
    }

    /**
     * Az akadaly hosszu leirasat adja meg, amit a mezo allapotanak lekerdezesekor hasznalunk
     * @return Az akadaly hosszu leirasa
     */
    @Override
    public String getLongDesc() {
        return "Obstacle";
    }
}
