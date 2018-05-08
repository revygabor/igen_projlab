/**
 * Ez az osztaly rajzolja ki a padlot.
 */
public class JFXFloorView implements IFloorView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXFloorView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Padlo kirajzolasa
     * @param f kirajzolando padlo
     */
    @Override
    public void draw(Floor f) {

    }
}
