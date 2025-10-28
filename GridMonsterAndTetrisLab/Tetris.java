import javax.sound.sampled.*;
import java.io.*;
/**
 * The Tertis class has the main method to run the game. It creates new Tetrads as 
 * blocks and makes the tetris game. It also plays music
 *
 * @author Divya Bhupathi
 * @version 3/12/2025
 */
public class Tetris implements ArrowListener
{
    private MyBoundedGrid<Block> grid;
    private BlockDisplay blockDisplay;
    private Tetrad tetrad;
    private boolean gameOver;
    /**
     * Constructor for objects of class Tetris and sets instance variables
     */
    public Tetris()
    {
        grid = new MyBoundedGrid(20, 10);
        tetrad = new Tetrad(grid);
        gameOver = false;
        blockDisplay = new BlockDisplay(grid);
        blockDisplay.setArrowListener(this);
        blockDisplay.setTitle("Tetris");
        blockDisplay.showBlocks();
    }
    /**
     * Main mentod to run the game and play music
     * @param args the argument parameter
     */
    public static void main (String [] args) throws Exception
    {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("musicTetris.wav")));
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        Tetris tet = new Tetris();
        tet.play();
    }
    /**
     * when up is pressed the tetrad rotates
     */
    public void upPressed()
    {
        if (!gameOver)
        {
            tetrad.rotate();
            blockDisplay.showBlocks();
        }
    }
    /**
     * when down is pressed the tetrad moves down one space
     */
    public void downPressed()
    {
        if (!gameOver)
        {
            tetrad.translate(1, 0);
            blockDisplay.showBlocks();
        }
    }
    /**
     * when left arrow is pressed the tetrad moves left one space
     */
    public void leftPressed()
    {
        if (!gameOver)
        {
            tetrad.translate(0, -1);
            blockDisplay.showBlocks();
        }
    }
    /**
     * when right arrow is pressed the tetrad moves right one space
     */
    public void rightPressed()
    {
        if (!gameOver)
        {
            tetrad.translate(0, 1);
            blockDisplay.showBlocks();
        }
    }
    /**
     * when space is pressed the tetrad hard drops down
     */
    public void spacePressed()
    {
        if (!gameOver)
        {
            for(int i=0; i<20; i++)
            {
                tetrad.translate(1, 0);
            }
            tetrad.translate(3, 0);
            blockDisplay.showBlocks();
        }
    }
    /**
     * play method to simulate a game of tertris for a tertis object
     */
    public void play()
    {
        while (!gameOver)
        {
            try
            {
                Thread.sleep(1000);
                if(tetrad.translate(1, 0))
                {
                    blockDisplay.showBlocks(); 
                }
                else
                {
                    clearCompletedRows();
                    if(tetrad.overLimit())
                    {
                        gameOver = true;
                    }
                    else
                    {
                        tetrad = new Tetrad(grid);
                        blockDisplay.showBlocks();
                    }
                }
            }
            catch(InterruptedException e)
            {
                //ignore
            }
        }
    }
    /**
     * checker for if a row is compleated
     * @param row the row number the method checks
     * @return boolean if the row is compleat or not
     */
    private boolean isCompletedRow(int row)
    {
       
        for (int i=0; i<grid.getNumCols(); i++)
        {
            Location locTest =new Location(row, i);
            if(grid.get(locTest)==null)
            {
                return false;
            }
        }
        return true;
    }
    /**
     * clears a row by removing the blocks from it
     * @param row the row number to clear
     */
    private void clearRow(int row)
    {
        for(int i=0; i<grid.getNumCols(); i++)
        {
            Location loc = new Location(row, i);
            Block block = grid.get(loc);
            block.removeSelfFromGrid();
        }
        for(int i=row-1; i>=0; i--)
        {
            for(int col=0; col<grid.getNumCols(); col++)
            {
                Location ogLoc = new Location(i, col);
                Location newLoc = new Location(i+1, col);
                Block bl = grid.get(ogLoc);

                if(bl != null)
                {
                    bl.moveTo(newLoc);
                }
            }
        }
    }
    /**
     * checks if the row is compleat and then if so clears the row
     */
    private void clearCompletedRows()
    {
        for (int i=0; i<grid.getNumRows(); i++)
        {
            if(isCompletedRow(i))
            {
                clearRow(i);
            }
        }
    }
}