import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PlayerNumberSelectorButton {
    private static final Font SELECTED_FONT = new Font("Times New Roman", 35);
    private static final Font UNSELECTED_FONT = new Font("Bernard MT Condensed", 28);
    private static final Paint[] COLORS = new Paint[] {
            Color.CYAN,
            Color.RED,
            Color.YELLOW,
            Color.BLUE,
            Color.GREY,
            Color.GREEN
    };
    private int playerNumber;
    private boolean selected = false;
    private JFXSokobanWindow window;
    private int xPos, yPos;

    public PlayerNumberSelectorButton(int playerNumber, JFXSokobanWindow window, int xPos, int yPos) {
        this.playerNumber = playerNumber;
        this.window = window;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void draw() {
        GraphicsContext g = window.getGraphics();
        g.setTextBaseline(VPos.TOP);
        g.setTextAlign(TextAlignment.LEFT);
        if(selected) {
            g.setFont(SELECTED_FONT);
        } else {
            g.setFont(UNSELECTED_FONT);
        }
        g.setFill(COLORS[playerNumber-1]);
        g.fillText(String.valueOf(playerNumber), xPos, yPos);
    }

    public Rectangle getBoundingRect() {
        return new Rectangle(xPos, yPos, 20, 20);
    }
}
