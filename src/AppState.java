import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public abstract class AppState {
    /**
     * A játék ablaka
     */
    protected JFXSokobanWindow window;

    protected AppState(JFXSokobanWindow window) {
        this.window = window;
    }

    /**
     * Kirajzolja a konstruktorban megadott ablakba az alkalmazás állapotot
     */
    public abstract void draw();

    /**
     * Kattintások kezelésére használható eseménykezelő objektumot ad vissza
     * @return Ennek az alkalmazás állapotnak megfelelő kattintás eseménykezelő
     */
    public abstract EventHandler<MouseEvent> getClickHandler();

    /**
     * Billentyűlenyomások kezelésére használható eseménykezelő objektumot ad vissza
     * @return Ennek az alkalmazás állapotnak megfelelő billentyűlenyomás eseménykezelő
     */
    public abstract EventHandler<KeyEvent> getKeyPressedHandler();
}
