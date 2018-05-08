import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki az akadalyt.
 */
public class JFXObstacleView implements IObstacleView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "obstacle.jpg");

    public JFXObstacleView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Akadaly kirajzolasa.
     * @param o kirajzolando akadaly
     */
    @Override
    public void draw(Obstacle o) {
        int x = InGameState.TILES_START_X + o.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + o.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }
}
