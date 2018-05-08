/**
 * Ez az osztaly rajzolja ki a padlot.
 */
public class JFXOilDrawer implements IOilDrawer {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXOilDrawer(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Olaj kirajzolasa.
     * @param o kirajzolando olaj
     * @param f mezo, amin az olaj van
     */
    @Override
    public void Draw(Oil o, Field f) {

    }
}
