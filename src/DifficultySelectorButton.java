import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class DifficultySelectorButton {

    public static final Font SELECTED_FONT = new Font("Bernard MT Condensed", 22);
    public static final Font UNSELECTED_FONT = new Font("Times New Roman", 16);

    private boolean selected = false;

    public Difficulty getDifficulty() {
        return diff;
    }

    private Difficulty diff;
    private int xPos, yPos;
    private JFXSokobanWindow window;

    public DifficultySelectorButton(Difficulty diff, int xPos, int yPos, JFXSokobanWindow window) {
        this.diff = diff;
        this.xPos = xPos;
        this.yPos = yPos;
        this.window = window;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void draw() {
        GraphicsContext g = window.getGraphics();
        g.setTextBaseline(VPos.TOP);
        if(selected) {
            g.setFont(SELECTED_FONT);
            g.setFill(Color.GREY);
        }
        else {
            g.setFont(UNSELECTED_FONT);
            g.setFill(Color.WHITE);
        }
        g.fillText(diff.getName(), xPos, yPos);
    }

    public Rectangle getBoundingRect() {
        return new Rectangle(xPos, yPos, 100, 30);
    }
}
