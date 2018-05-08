/**
 * Ez az osztaly rajzolja ki a dobozt.
 */
public class JFXBoxView implements IBoxView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXBoxView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Doboz kirajzolasa.
     * @param b kirjzolando doboz
     * @param f a mezo, amelyiken a doboz van
     */
    @Override
    public void Draw(Box b, Field f) {

    }
}
