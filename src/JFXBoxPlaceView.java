/**
 * Ez az osztaly rajzolja ki a dobozhelyet.
 */
public class JFXBoxPlaceView implements IBoxPlaceView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXBoxPlaceView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Dobozhelyek kirajzolasa.
     * @param bp kirajzolando dobozhely
     */
    @Override
    public void Draw(BoxPlace bp) {

    }
}
