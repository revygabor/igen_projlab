import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JFXSokobanWindow extends Application {

    AppState appState;
    private Canvas mainCanvas;
    private GraphicsContext graphicsContext;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Killer Sokoban by Igen");
        mainCanvas = new Canvas();
        graphicsContext = mainCanvas.getGraphicsContext2D();
        Group root = new Group();
        root.getChildren().add(mainCanvas);

        mainCanvas.setHeight(500);
        mainCanvas.setWidth(500);

        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(0,0, 100,100);

        scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        setAppState(new MenuState(this));
    }

    void setAppState(AppState newState) {
        appState = newState;
        appState.Draw();
        mainCanvas.setOnMouseClicked(appState.getClickHandler());
        scene.setOnKeyPressed(appState.getKeyPressedHandler());
    }

    public GraphicsContext getGraphics() {
        return graphicsContext;
    }
}
