import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a lyukat.
 */
public class JFXHoleView implements IHoleView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "hole.jpg");

    public JFXHoleView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Lyuk kirajzolasa.
     * @param h kirajzolando lyuk
     */
    @Override
    public void Draw(Hole h) {
        int x = InGameState.TILES_START_X + h.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + h.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }
}
