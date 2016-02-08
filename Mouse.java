import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Adam on 2/6/2016.
 */
public class Mouse
{

    static void click()
    {
        try {
           Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            Thread.sleep(50);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static void click(int n)
    {
        Robot robot = null;
        try {
            robot = new Robot();
            for (int i = 0; i < n; i++){
                robot.mousePress(InputEvent.BUTTON1_MASK);
                Thread.sleep(20);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void move(int x, int y)
    {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.mouseMove(x,y);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    static void move(Point p)
    {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.mouseMove(p.getX(),p.getY());
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
