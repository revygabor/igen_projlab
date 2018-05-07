import javafx.event.EventHandler;
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

    public InGameState(String mapFilePath, int playerNumber, JFXSokobanWindow window) {
        super(window);
    }

    @Override
    public void Draw() {

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
