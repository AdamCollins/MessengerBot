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
        Thread.sleep(5000);
        game = null;
        readPoint = new Point(335, 578); //MUST be set in right pos. Use FindMousePos to set.
        writePoint = new Point(317, 648);//MUST be set in right pos. Use FindMousePos to set.
        readChat();
    }

    private static void readChat() throws InterruptedException {
        reader = new Reader();
        writer = new Writer();
        String prevInput = " ";
        long startTime = System.currentTimeMillis();
        long messageCount = 0;
        int es = 0;
        simpleMessage("Hello, I am back again!");
        while(true)
        {

            Thread.sleep(2500);
            Mouse.move(readPoint);
            String input;
            try{input = reader.read().trim().toLowerCase();}catch (NullPointerException e) {input = "";}
            System.out.println(input);

            if(messageCount%100==0) simpleMessage("Yay! I lasted " + messageCount + " messages without dying!");

            if(input.contains("e"))
            {
                if(!input.equals(prevInput))
                {
                    es++;
                    if (es % 100 == 0) simpleMessage("You have used the letter 'e' " + es + " times");
                }
            }

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
               simpleMessage("*unzips pants*");
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
            else if(input.contains(" bot"))
            {
                if(input.contains("computer")) simpleMessage("Im not a computer I am a real boy!");
                else
                if(Math.random()>0.5)simpleMessage("Don't talk to me like im not here.");
                else simpleMessage("I can hear you you know.");
            }
            else if(input.contains("sad"))
            {
                simpleMessage("MessangerBot is sad when you are sad");
            }
            else if (input.contains("japan") || input.contains("taiwan"))
            {
                Mouse.move(writePoint);
                Mouse.click();
                writer.type("Taiwan #1!");
            }
            else if(input.contains("goodnight"))
            {
                simpleMessage("<3");
            }
            else if(input.contains("love you"))
            {
                if(Math.random()*10>8) simpleMessage("Do you love Messanger bot?");
            }
            else if(input.contains("sara") && !input.contains("*") && !input.contains("typing"))
            {
                if(Math.random()*30>27)simpleMessage("Sarah*");
            }
            else if(input.equalsIgnoreCase("[Exit!]"))
            {
                simpleMessage("Time to sleep. Goodnight!");
                System.exit(0);
                return;
            }
            writer.escape();
            if(!input.equals(prevInput)) messageCount++;
            prevInput = input;
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
