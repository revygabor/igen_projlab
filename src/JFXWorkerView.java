/**
 * Ez az osztaly rajzolja ki az munkast.
 */
public class JFXWorkerView implements IWorkerView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXWorkerView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Munkas kirajzolasa.
     * @param w kirajzolando munkas
     * @param f mezo, amin a munkas van
     */
    @Override
    public void Draw(Worker w, Field f) {

    }
}
