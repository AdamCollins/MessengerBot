//import jdk.nashorn.internal.IntDeque;
//import jdk.nashorn.internal.ir.annotations.Ignore;

import java.awt.*;

/**
 * Created by Adam on 2/6/2016.
 */
public class Runner
{
    private static Reader reader;
    private static Writer writer;
    private static Point readPoint;
    private static Game game;
    private static Point writePoint;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("OK. Love you sara".contains("sara"));
        Thread.sleep(5000);
        game = null;
        readPoint = new Point(733, 853);
        writePoint = new Point(722, 941);
        //readChat();
    }

    private static void readChat() throws InterruptedException {
        reader = new Reader();
        writer = new Writer();
        while(true)
        {
            Thread.sleep(2500);
            Mouse.move(readPoint);
            String input;
            try{input = reader.read().trim().toLowerCase();}catch (NullPointerException e) {input = "";}
            System.out.println(input);
            if(input.equals("[2048]".trim()))
            {
                try {
                    game.isRunning();
                }catch (Exception e) {
                    Game game = new Game(readPoint, writePoint);
                }
            }
            else if(input.contains("nsfw"))
            {
                Mouse.move(writePoint);
                Mouse.click();
                writer.type("MessangerBot: ");
                writer.type("*unzips pants*");
                writer.newLine();
            }
            else if(input.contains("[loop]"))
            {
                System.out.println(input.substring(9));
                int n = 0;
                if(input.length()>6)n =Integer.parseInt(input.charAt(7)+"");
                Mouse.move(writePoint);
                Mouse.click();
                for (int i = 0; i<n; i++)
                {
                    writer.type(input.substring(9));
                    writer.newLine();
                }
            }
            else if (input.contains("japan") || input.contains("taiwan"))
            {
                Mouse.move(writePoint);
                Mouse.click();
                writer.type("Taiwan #1!");
            }
            else if(input.contains("sara") && !input.contains("*") && !input.contains("typing"))
            {
                simpleMessage("Sarah*");
            }
            else if(input.equalsIgnoreCase("[Exit!]"))
            {
                System.exit(0);
            }
            writer.escape();

        }
    }

    public static void simpleMessage(String m)
    {
        Mouse.move(writePoint);
        Mouse.click();
        writer.type("MessangerBot: ");
        writer.type(m);
        writer.newLine();
    }
}
