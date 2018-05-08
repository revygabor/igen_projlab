import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a mezet.
 */
public class JFXHoneyDrawer implements IHoneyDrawer {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "honey.jpg");

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
        int x = InGameState.TILES_START_X + f.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + f.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }
}
