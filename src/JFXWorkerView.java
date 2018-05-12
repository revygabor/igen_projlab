import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.File;

/**
 * Ez az osztaly rajzolja ki az munkast.
 */
public class JFXWorkerView implements IWorkerView {
    public static final Font STAT_FONT = new Font("Times New Roman", 25);
    /**
     * Az ablak, ahova rajzol.
     */
    private JFXSokobanWindow jfxSokobanWindow;
    /**
     * A rajzolashoz hasznalhato kepek tombje. Minden jatekoshoz egy kep.
     */
    private static final Image[] imgs = new Image[]{
            new Image("res" + File.separator + "worker_0.png"),
            new Image("res" + File.separator + "worker_1.png"),
            new Image("res" + File.separator + "worker_2.png"),
            new Image("res" + File.separator + "worker_3.png"),
            new Image("res" + File.separator + "worker_4.png"),
            new Image("res" + File.separator + "worker_5.png")
    };

    public JFXWorkerView(JFXSokobanWindow jfxSokobanWindow) {
        this.jfxSokobanWindow = jfxSokobanWindow;
    }

    public static final Paint[] PLAYER_COLORS = new Paint[] {
            Color.BLUE,
            Color.RED,
            Color.GREEN,
            Color.YELLOW,
            Color.CYAN,
            Color.GRAY
    };

    /**
     * Munkas kirajzolasa.
     * @param w kirajzolando munkas
     * @param f mezo, amin a munkas van
     */
    @Override
    public void draw(Worker w, Field f) {
        int x = InGameState.TILES_START_X + f.getXPos()*InGameState.TILE_WIDTH;
        int y = InGameState.TILES_START_Y + f.getYPos()*InGameState.TILE_HEIGHT;
        GraphicsContext g = jfxSokobanWindow.getGraphics();
        g.drawImage(imgs[w.getId()], x, y, InGameState.TILE_WIDTH, InGameState.TILE_HEIGHT);

        //Pötty rajzolás
        int xCircle = InGameState.PLAYER_STATS_START_X;
        int yCircle = InGameState.PLAYER_STATS_START_Y + w.getId() * InGameState.PLAYER_STATS_DY;
        g.setFill(Color.gray(0.7));
        g.fillOval(xCircle, yCircle, 30, 30);
        g.setFill(PLAYER_COLORS[w.getId()]);
        g.fillOval(xCircle+2.5, yCircle+2.5, 25, 25);

        //Játékos azonosító kiírása
        final int TEXT_OFFSET_X = 40;
        g.setTextAlign(TextAlignment.LEFT);
        int xText = InGameState.PLAYER_STATS_START_X + TEXT_OFFSET_X;
        int yText = InGameState.PLAYER_STATS_START_Y + w.getId() * InGameState.PLAYER_STATS_DY;
        g.setTextBaseline(VPos.TOP);
        g.setFont(STAT_FONT);
        g.setFill(Color.WHITE);
        g.fillText("Player"+w.getId()+":", xText, yText);

        //Játékos pontszám kiírása
        final int SCORE_GAP = 110;
        g.fillText(w.getScore() + " pont", xText + SCORE_GAP, yText);

        //Erő kiírása
        final int STRENGTH_OFFSET_X = 25;
        final int STRENGTH_OFFSET_Y = 30;
        g.setFill(Color.gray(0.3));
        g.fillText("Erő: " + w.getStrength(), xText + STRENGTH_OFFSET_X, yText + STRENGTH_OFFSET_Y);
    }
}
