package view.util;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.utils.FXTestUtils;
import org.testfx.api.FxRobot;

import java.util.concurrent.TimeUnit;

/**
 * Class for controlling FxRobot. Extending it allows to automatically control mouse and keypad.
 *
 * @author Mykhailo Bormashenko.
 */
public class RobotControl extends GuiTest {

    /**
     * Double value of 2.0 for calculating center of node.
     */
    private static final double TWO = 2.0;

    /**
     * Robot for automatically control.
     */
    protected FxRobot robot = new FxRobot();

    /**
     * Moves cursor to the middle of node using robot.
     *
     * @param node node from view where cursor should be moved.
     */
    protected void hoverOn(Node node) {
        Bounds bounds = node.localToScreen(node.getBoundsInLocal());

        double centerX = (bounds.getMinX() + bounds.getMaxX()) / TWO;
        double centerY = (bounds.getMinY() + bounds.getMaxY()) / TWO;

        robot.moveTo(centerX, centerY);

        FXTestUtils.awaitEvents();
    }

    /**
     * Enables or disables node.
     *
     * @param selector id of node.
     */
    protected void setNodeDisabled(String selector, boolean flag) {
        Node control = getNodeBySelector(selector);
        control.setDisable(flag);
    }

    /**
     * Makes node visible or invisible.
     *
     * @param selector id of node.
     */
    protected void setNodeVisible(String selector, boolean flag) {
        Node control = getNodeBySelector(selector);
        control.setVisible(flag);
    }

    /**
     * Looks up for node by styleclass and selector.
     *
     * @param selector id of node.
     * @return node.
     */
    private Node getNodeBySelector(String selector) {
        return robot.lookup(selector).query();
    }

    /**
     * Looks up for button by styleclass and selector.
     *
     * @param selector id of button.
     * @return button.
     */
    protected Button getButtonBySelector(String selector) {
        return robot.lookup(selector).queryButton();
    }

    @Override
    public void setupStage() {
        FXTestUtils.launchApp(MainTest.class, "");

        try {
            stage = targetWindow(MainTest.getStageFuture().get(25, TimeUnit.SECONDS));
            FXTestUtils.bringToFront(stage);
        } catch (Exception e) {
            throw new RuntimeException("Unable to show stage", e);
        }
    }

    @Override
    protected Parent getRootNode() {
        if (stage == null) {
            setupStage();
        }

        return stage.getScene().getRoot();
    }
}
