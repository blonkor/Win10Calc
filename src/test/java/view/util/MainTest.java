package view.util;

import com.google.common.util.concurrent.SettableFuture;
import com.implemica.bormashenko.calculator.Launcher;
import javafx.stage.Stage;

public class MainTest extends Launcher {

    private static final SettableFuture<Stage> stageFuture = SettableFuture.create();

    public MainTest() {
        super();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start(primaryStage);
        stageFuture.set(primaryStage);
    }

    public static SettableFuture<Stage> getStageFuture() {
        return stageFuture;
    }
}