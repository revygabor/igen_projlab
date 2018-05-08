import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki a kapcsolot.
 */
public class JFXSwitchView implements ISwitchView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalt kep, ha a switch zarva van.
     */
    private static final Image closedImg = new Image("res" + File.separator + "switch_closed.jpg");

    /**
     * A rajzolashoz hasznalt kep, ha a switch nyitva van.
     */
    private static final Image openImg = new Image("res" + File.separator + "switche_open.jpg");

    public JFXSwitchView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    /**
     * Kapcsolo kirajzolasa.
     * @param s kirajzolando kapcsolo
     */
    @Override
    public void Draw(Switch s) {
        int x = InGameState.TILES_START_X + s.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + s.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(s.isOn() ? closedImg : openImg, x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
    }
}
