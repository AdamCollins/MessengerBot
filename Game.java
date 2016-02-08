import java.awt.*;

/**
 * Created by Adam on 2/6/2016.
 */
public class Game {
    private int[][] board;
    private Writer writeOut;
    private Reader reader;
    private Point type, read;
    private boolean isRunning;
    Game(Point readPoint, Point writePoint) {

        isRunning = true;
        board = new int[4][4];
        type = writePoint;
        writeOut = new Writer();
        reader = new Reader();

        read = readPoint;
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearBoard();
        addTile();
        addTile();
        playGame();


    }


    private void copyMessage() {
        Mouse.move(read);
        String m = reader.read();
        Mouse.move(type);
        Mouse.click();
        writeOut.type(m);
    }


    private void playGame()
    {
        Mouse.move(type);
        String move = " ";
        String prevMove = "[";
        printBoard();
        while (!move.equals("exit"))
        {

            waitFor(1000);
            Mouse.move(read);
            move = reader.read().trim().toLowerCase();
            if (move.charAt(0) != '[' && !move.equals(prevMove))
            {
                switch (move)
                {
                    case "up":
                        shiftUp();
                        break;
                    case "down":
                        shiftDown();
                        break;
                    case "left":
                        shiftLeft();
                        break;
                    case "right":
                        shiftRight();
                        break;
                    case "exit":
                        break;
                    default: {
                    }
                }
            }
            if (!move.equals(prevMove) && move.charAt(0) != '[' && !move.equals("exit")) {
                printBoard();
                prevMove = move;
            }

        }
        isRunning = false;
    }


    private  void shiftUp()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int r = 1; r <= 3; r++)
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    if (board[r][c] == board[r - 1][c] || board[r - 1][0] == 0)
                    {
                        board[r - 1][c] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private  void shiftDown()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int r = 2; r >= 0; r--)
            {
                for (int c = 0; c < board[0].length; c++)
                {
                    if (board[r][c] == board[r + 1][c] || board[r + 1][c] == 0)
                    {
                        board[r + 1][c] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private  void shiftLeft()
    {
        for (int shift = 0; shift < board.length; shift++)
        {
            for (int c = 1; c < board[0].length; c++)
            {
                for (int r = 0; r < board.length; r++)
                {
                    if (board[r][c] == board[r][c - 1] || board[r][c - 1] == 0)
                    {
                        board[r][c - 1] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }

    private void shiftRight()
    {
        for (int shift = 0; shift < board[0].length; shift++)
        {
            for (int c = 2; c >= 0; c--)
            {
                for (int r = 0; r < board.length; r++)
                {
                    if (board[r][c] == board[r][c + 1] || board[r][c + 1] == 0)
                    {
                        board[r][c + 1] += board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
        addTile();
    }



    private  void clearBoard()
    {
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                board[r][c] = 0;
            }
        }
    }


    private void printBoard()
    {
        Mouse.move(type);
        Mouse.click();
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length; c++)
            {
                writeOut.type("[");
                if(board[r][c]!=0)writeOut.type(String.format("%3d",board[r][c]));
                else writeOut.type("    ");

                writeOut.type("]");
            }
            writeOut.newLine();
        }
        writeOut.newLine();
    }

    private void addTile()
    {
        int r = (int) (Math.random() * 4);
        int c = (int) (Math.random() * 4);
        if (board[r][c] == 0)
        {
            if ((int) (Math.random() * 10) == 9)
                board[r][c] = 4;
            else
                board[r][c] = 2;
        } else
        {
            addTile();
        }
    }

    private void waitFor(int t)
    {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning()
    {
        return isRunning;
    }
}




/*

    HelloThere



*/




