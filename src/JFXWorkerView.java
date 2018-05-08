import javafx.scene.image.Image;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki az munkast.
 */
public class JFXWorkerView implements IWorkerView {
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalhato kepek tombje. Minden jatekoshoz egy kep.
     */
    private static final Image[] imgs = new Image[]{
            new Image("res" + File.separator + "worker0.jpg"),
            new Image("res" + File.separator + "worker1.jpg"),
            new Image("res" + File.separator + "worker2.jpg"),
            new Image("res" + File.separator + "worker3.jpg"),
            new Image("res" + File.separator + "worker4.jpg"),
            new Image("res" + File.separator + "worker5.jpg")
    };

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
        int x = InGameState.TILES_START_X + f.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + f.getYPos()*InGameState.TILE_HEIGHT;
        jfxSokobanWindow.getGraphics().drawImage(imgs[w.getId()], x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);
        //TODO: stats
    }
}
