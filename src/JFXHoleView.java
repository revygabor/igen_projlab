/**
 * Ez az osztaly rajzolja ki a lyukat.
 */
public class JFXHoleView implements IHoleView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXHoleView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Lyuk kirajzolasa.
     * @param h kirajzolando lyuk
     */
    @Override
    public void draw(Hole h) {

    }
}
