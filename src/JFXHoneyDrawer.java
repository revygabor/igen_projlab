/**
 * Ez az osztaly rajzolja ki a mezet.
 */
public class JFXHoneyDrawer implements IHoneyDrawer {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXHoneyDrawer(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Mez kirajzolasa.
     * @param h kirajzolando mez
     * @param f mezo, amin a mez van
     */
    @Override
    public void Draw(Honey h, Field f) {

    }
}
