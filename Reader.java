import java.awt.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Adam on 2/6/2016.
 */
public class Reader
{
    private Robot robot;
    private String message;
    Reader()
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
           // e.printStackTrace();
        }
    }

    public String read()
    {

        Mouse.click(3);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
        waitFor(50);
        message = clipBoardString();
        Mouse.click();
        return clipBoardString();
    }

    private String clipBoardString()
    {
        String result = null;
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();

            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch(UnsupportedFlavorException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }catch (Exception e)
        {

        }

        // e.printStackTrace();

        return result;
    }

    private void waitFor(int t)
    {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
