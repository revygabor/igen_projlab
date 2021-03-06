import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a dobozt.
 */
public class JFXBoxView implements IBoxView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep.
     */
    private static final Image img = new Image("res" + File.separator + "box.jpg");

    public JFXBoxView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Doboz kirajzolasa.
     * @param b kirjzolando doboz
     * @param f a mezo, amelyiken a doboz van
     */
    @Override
    public void draw(Box b, Field f) {
        int x = InGameState.TILES_START_X + InGameState.TILE_WIDTH /10 + f.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + InGameState.TILE_HEIGHT /10 + f.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(img, x, y, InGameState.TILE_WIDTH *8/10, InGameState.TILE_HEIGHT *8/10);
    }
}
