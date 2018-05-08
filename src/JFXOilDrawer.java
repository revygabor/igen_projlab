import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a padlot.
 */
public class JFXOilDrawer implements IOilDrawer {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "oil.png");

    public JFXOilDrawer(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Olaj kirajzolasa.
     * @param o kirajzolando olaj
     * @param f mezo, amin az olaj van
     */
    @Override
    public void draw(Oil o, Field f) {
        int x = InGameState.TILES_START_X + f.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + f.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }
}
