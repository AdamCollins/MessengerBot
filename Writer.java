import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Adam on 2/6/2016.
 */
public class Writer
{
    private Robot robot;
    Writer()
    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public void type(String s)
    {
        for(char key: s.toCharArray()) pressKey(key);

    }

    private void pressKey(char key)
    {

        switch (key)
        {
            case '*':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
            case ':':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
            case '#':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
            case '<':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
            case '\'':
            {
                robot.keyPress(KeyEvent.VK_QUOTE);
                robot.keyRelease(KeyEvent.VK_QUOTE);
                return;
            }
            case '?':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
            case '!':
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                return;
            }
        }

            waitFor(20);
           try {
               if (Character.isUpperCase(key)) {
                   robot.keyPress(KeyEvent.VK_SHIFT);
                   robot.keyPress((int) key);
                   robot.keyRelease((int) key);
                   robot.keyRelease(KeyEvent.VK_SHIFT);
               } else {
                   key = Character.toUpperCase(key);
                   robot.keyPress((int) key);
                   robot.keyRelease((int) key);
               }
           }catch (Exception e){return;}


    }

    private void waitFor(int t)
    {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void escape()
    {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void newLine()
    {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
