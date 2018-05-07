import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InGameState extends AppState {

    private EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

        }
    };
    private EventHandler<KeyEvent> keyPressedHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

        }
    };

    public InGameState(JFXSokobanWindow window) {
        super(window);
    }

    @Override
    public void Draw(GraphicsContext g) {

    }

    @Override
    public EventHandler<MouseEvent> getClickHandler() {
        return clickHandler;
    }

    @Override
    public EventHandler<KeyEvent> getKeyPressedHandler() {
        return keyPressedHandler;
    }
}
