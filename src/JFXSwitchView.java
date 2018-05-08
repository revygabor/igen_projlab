/**
 * Ez az osztaly rajzolja ki a kapcsolot.
 */
public class JFXSwitchView implements ISwitchView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXSwitchView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Kapcsolo kirajzolasa.
     * @param s kirajzolando kapcsolo
     */
    @Override
    public void draw(Switch s) {

    }
}
