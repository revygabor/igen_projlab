/**
 * Ez az osztaly rajzolja ki az akadalyt.
 */
public class JFXObstacleView implements IObstacleView {
    private JFXSokobanWindow jfxSokobanWindow;

    public JFXObstacleView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Akadaly kirajzolasa.
     * @param o kirajzolando akadaly
     */
    @Override
    public void Draw(Obstacle o) {

    }
}
