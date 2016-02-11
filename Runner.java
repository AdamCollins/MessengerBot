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
        long messegeCount = 1;
        int es = 0;
        simpleMessege("Hello, I am back again!");
        while(true)
        {

            Thread.sleep(2500);
            Mouse.move(readPoint);
            String input;
            try{input = reader.read().trim().toLowerCase();}catch (NullPointerException e) {input = "";}
            System.out.println(input);
            if(!input.equals(prevInput)) {
                System.out.println("uniqe messege");
                if (messegeCount % 100 == 0)
                    simpleMessege("Yay! I lasted " + messegeCount + " messeges without dying!");
                if (input.equalsIgnoreCase("[Exit!]")) {
                    simpleMessege("Time to sleep. Goodnight!");
                    waitFor(3000);
                    System.exit(0);
                    return;
                }
                if (input.contains("e")) {
                    if (!input.equals(prevInput)) {
                        es++;
                        if (es % 100 == 0) simpleMessege("You have used the letter 'e' " + es + " times");
                    }
                }
                if (input.equals("[2048]".trim())) {
                    try {
                        game.isRunning();
                    } catch (Exception e) {
                        Game game = new Game(readPoint, writePoint);
                    }
                } else if (input.contains("nsfw")) {
                    simpleMessege("*unzips pants*");
                } else if (input.contains("[loop]")) {
                    System.out.println(input.substring(9));
                    int n = 0;
                    if (input.length() > 6) n = Integer.parseInt(input.charAt(7) + "");
                    Mouse.move(writePoint);
                    Mouse.click();
                    for (int i = 0; i < n; i++){
                        writer.type(input.substring(9));
                        writer.newLine();
                    }
                } else if (input.contains(" bot")) {
                    if (input.contains("computer")) simpleMessege("Im not a computer I am a real boy!");
                    else if (Math.random() > 0.5) simpleMessege("Don't talk to me like im not here.");
                    else simpleMessege("I can hear you you know.");
                } else if (input.contains("sad")) {
                    simpleMessege("MessangerBot is sad when you are sad");
                } else if (input.contains("japan") || input.contains("taiwan")) {
                    Mouse.move(writePoint);
                    Mouse.click();
                    writer.type("Taiwan #1!");
                } else if (input.contains("goodnight")) {
                    simpleMessege("<3");
                } else if(input.contains("messengerbot") && !input.contains(":"))
                {
                    simpleMessege("That's my name; don't wear it out.");
                }
                else if (input.contains("hello?"))
                {
                    int option = (int)(Math.random()*5);
                    if(option==0)simpleMessege("Hello");
                    else if(option==1)simpleMessege("Hi! How are you?");
                    else if(option==2)simpleMessege("Hello! I am MessengerBot.");
                    else if(option==3)simpleMessege("\"Is it me you're looking for?\" - Lionel Richie" );
                    else simpleMessege("*Beep Boop* I am a r0b0t!");
                }
                else if (input.contains("love you")) {
                    if (Math.random() * 10 > 8) simpleMessege("Do you love Messanger bot?");
                } else if (input.contains("sara") && !input.contains("*") && !input.contains("typing")) {
                    if (Math.random() * 30 > 27) simpleMessege("Sarah*");
                }
                else if(input.contains("im"))
                {
                    simpleMessege("Hi, " + input.substring(input.indexOf("im"))  + ", im MessengerBot");
                }


                messegeCount++;
            }
            writer.escape();
            //
            prevInput = input;
        }
    }

    public static void simpleMessege(String m)
    {
        Mouse.move(writePoint);
        Mouse.click();
        writer.type("MessengerBot: ");
        writer.type(m);
        writer.newLine();
    }

    private static void waitFor(int t)
    {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
