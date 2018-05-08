import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a dobozhelyet.
 */
public class JFXBoxPlaceView implements IBoxPlaceView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "box_place.jpg");

    /**
     * Dobozhelyek kirajzolasa.
     * @param bp kirajzolando dobozhely
     */
    @Override
    public void Draw(BoxPlace bp) {
        int x = InGameState.TILES_START_X + bp.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + bp.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }

    public JFXBoxPlaceView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }
}
