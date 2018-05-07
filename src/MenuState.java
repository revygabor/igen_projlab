import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuState extends AppState {

    private DifficultySelectorButton[] diffSelectors = new DifficultySelectorButton[Difficulty.values().length];
    private PlayerNumberSelectorButton[] playerNumSelectors = new PlayerNumberSelectorButton[6];

    Difficulty selectedDifficulty = Difficulty.EASY;
    int selectedPlayerNumbers = 2;
    Rectangle newGameRect = new Rectangle(200, 200, 50,50);

    private final int X_START_DIFFICULTY = 100;
    private final int Y_START_DIFFICULTY = 100;
    private final int DY_DIFFICULTY = 30;
    private final int X_START_NUMBER = 100;
    private final int Y_START_NUMBER = 30;
    private final int DX_NUMBER = 20;

    private EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            for (DifficultySelectorButton diffSelector : diffSelectors) {
                if(diffSelector.getBoundingRect().contains(event.getX(), event.getY())) {
                    selectedDifficulty = diffSelector.getDifficulty();
                    for (DifficultySelectorButton selector : diffSelectors) {
                        selector.setSelected(false);
                    }
                    diffSelector.setSelected(true);
                }
            }
            for (PlayerNumberSelectorButton playerNumSelector : playerNumSelectors) {
                if (playerNumSelector.getBoundingRect().contains(event.getX(), event.getY())) {
                    selectedPlayerNumbers = playerNumSelector.getPlayerNumber();
                    for (PlayerNumberSelectorButton numSelector : playerNumSelectors) {
                        numSelector.setSelected(false);
                    }
                    playerNumSelector.setSelected(true);
                }
            }
            MenuState.this.Draw();
        }
    };
    private EventHandler<KeyEvent> keyPressedHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

        }
    };


    public MenuState(JFXSokobanWindow window) {
        super(window);

        Difficulty[] values = Difficulty.values();
        for (int i = 0; i < values.length; i++) {
            Difficulty difficulty = values[i];
            diffSelectors[i] = new DifficultySelectorButton(difficulty, X_START_DIFFICULTY, Y_START_DIFFICULTY + i * DY_DIFFICULTY, window);
        }
        for (int i = 1; i <= 6; i++) {
            playerNumSelectors[i-1] = new PlayerNumberSelectorButton(i, window, X_START_NUMBER+(i-1)*DX_NUMBER, Y_START_NUMBER);
        }
    }

    @Override
    public void Draw() {
        GraphicsContext g = window.getGraphics();
        g.clearRect(0, 0, 500, 500);
        g.setFill(Color.BLACK);
        g.fillRect(0,0,500,500);
        for (DifficultySelectorButton diffSelector : diffSelectors) {
            diffSelector.draw();
        }
        for (PlayerNumberSelectorButton playerNumSelector : playerNumSelectors) {
            playerNumSelector.draw();
        }
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
