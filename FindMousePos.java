import java.awt.*;

/**
 * Created by Adam on 2/7/2016.
 */
public class FindMousePos
{
    public static void main(String[] args) throws InterruptedException {
        while (true)
        {
            Thread.sleep(2000);
            System.out.println(MouseInfo.getPointerInfo().getLocation());
        }
    }
}
