package util;

import com.google.common.util.concurrent.SettableFuture;
import com.implemica.bormashenko.calculator.Launcher;
import javafx.stage.Stage;

/**
 * Class for running GUI tests.
 *
 * @author Mykhailo Bormashenko
 * @see Launcher
 * @todo refactoring
 */
public class SetLauncherAppForTests extends Launcher {

    /**
     * Something that helps us to run GUI tests.
     */
    private static final SettableFuture<Stage> stageFuture = SettableFuture.create();

    /**
     * Constructor for creating application's UI.
     */
    public SetLauncherAppForTests() {
        super();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start(primaryStage);
        stageFuture.set(primaryStage);
    }

    static SettableFuture<Stage> getStageFuture() {
        return stageFuture;
    }
}