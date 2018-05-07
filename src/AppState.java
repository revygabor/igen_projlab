import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public abstract class AppState {
    protected JFXSokobanWindow window;

    protected AppState(JFXSokobanWindow window) {
        this.window = window;
    }

    public abstract void Draw(GraphicsContext g);
    public abstract EventHandler<MouseEvent> getClickHandler();
    public abstract EventHandler<KeyEvent> getKeyPressedHandler();
}
