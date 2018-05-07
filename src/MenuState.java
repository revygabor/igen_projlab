import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.File;

public class MenuState extends AppState {

    private DifficultySelectorButton[] diffSelectors = new DifficultySelectorButton[Difficulty.values().length];
    private PlayerNumberSelectorButton[] playerNumSelectors = new PlayerNumberSelectorButton[6];

    Difficulty selectedDifficulty = Difficulty.EASY;
    int selectedPlayerNumbers = 2;

    public static final int IMAGE_X = 0;
    public static final int IMAGE_Y = 200;
    Rectangle newGameRect = new Rectangle(720, 500, 200,100);
    public static final Font NEW_GAME_FONT = new Font("Arial", 50);
    private final int X_START_DIFFICULTY = 720;
    private final int Y_START_DIFFICULTY = 325;
    private final int DY_DIFFICULTY = 50;
    private final int X_START_NUMBER = 720;
    private final int Y_START_NUMBER = 250;
    private final int DX_NUMBER = 40;
    private final Image menuImage = new Image("res"+ File.separator + "menu.png");

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
            if(newGameRect.contains(event.getX(), event.getY()))
                startGame();
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
        diffSelectors[0].setSelected(true);
        playerNumSelectors[1].setSelected(true);
    }

    private void startGame() {
        window.setAppState(new InGameState(selectedDifficulty.getMapFilePath(), selectedPlayerNumbers, window));
    }

    @Override
    public void Draw() {
        GraphicsContext g = window.getGraphics();
        g.clearRect(0, 0, 2000, 2000);
        g.setFill(Color.BLACK);
        g.fillRect(0,0,2000,2000);
        g.drawImage(menuImage, IMAGE_X, IMAGE_Y);
        for (DifficultySelectorButton diffSelector : diffSelectors) {
            diffSelector.draw();
        }
        for (PlayerNumberSelectorButton playerNumSelector : playerNumSelectors) {
            playerNumSelector.draw();
        }
        g.setFill(Color.gray(0.2));
        g.fillRect(newGameRect.getX(), newGameRect.getY(), newGameRect.getWidth(), newGameRect.getHeight());
        g.setStroke(Color.WHITE);
        g.strokeRect(newGameRect.getX(), newGameRect.getY(), newGameRect.getWidth(), newGameRect.getHeight());
        g.setTextBaseline(VPos.CENTER);
        g.setTextAlign(TextAlignment.CENTER);
        double textY = newGameRect.getY() + newGameRect.getHeight() / 2;
        double textX = newGameRect.getX() + newGameRect.getWidth() / 2;
        g.setFill(Color.WHITE);
        g.setFont(NEW_GAME_FONT);
        g.fillText("Új játék", textX, textY);

        g.setFill(Color.WHITE);
        g.setTextAlign(TextAlignment.LEFT);
        g.setTextBaseline(VPos.TOP);
        g.setFont(new Font("Times New Roman", 25));
        g.fillText("Játékosok száma:", X_START_NUMBER - 230, Y_START_NUMBER);
        g.fillText("Pályák:", X_START_DIFFICULTY - 100, Y_START_DIFFICULTY);
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
