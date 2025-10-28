import java.awt.Color;
import java.util.ArrayList;
/**
 * Tetrad Class to make objects for each tetrad. A tetrad is a set of 4 blocks 
 * that are in a certian configuration to represent stacking peices in the game
 * tetris.
 * @author Divya Bhupathi
 * @version 3/24/2025
 */
public class Tetrad
{
    private MyBoundedGrid<Block> grid;
    private Block[] arrayBlocks;
    private Location[] locs;
    /**
     * Constructor for objects of class Tetrad and sets instance variables
     * @param grid the grid
     */
    public Tetrad(MyBoundedGrid<Block> grid)
    {
        arrayBlocks = new Block[4];
        locs = new Location[4];
        this.grid = grid;
        int choice = (int)(Math.random()*7) + 1;
        if(choice == 1)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.RED);
            }
            locs[1] = new Location(0, 4);
            locs[0] = new Location(1, 4);//rotate block
            locs[2] = new Location(2, 4);
            locs[3] = new Location(3, 4);
        }
        else if(choice == 2)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.GRAY);
            }
            locs[1] = new Location(0, 3);
            locs[0] = new Location(0, 4);//rotate block
            locs[2] = new Location(0, 5);
            locs[3] = new Location(1, 4);
        }
        else if(choice == 3)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.CYAN);
            }
            locs[1] = new Location(0, 4);
            locs[0] = new Location(0, 5);//rotate block
            locs[2] = new Location(1, 4);
            locs[3] = new Location(1, 5);
        }
        else if(choice == 4)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.YELLOW);
            }
            locs[1] = new Location(0, 4);
            locs[0] = new Location(1, 4);//rotate block
            locs[2] = new Location(2, 4);
            locs[3] = new Location(2, 5);
        }
        else if(choice == 5)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.MAGENTA);
            }
            locs[1] = new Location(0, 5);
            locs[0] = new Location(1, 5);//rotate block
            locs[2] = new Location(2, 5);
            locs[3] = new Location(2, 4);
        }
        else if(choice == 6)
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.BLUE);
            }
            locs[2] = new Location(1, 4);
            locs[1] = new Location(0, 5);
            locs[0] = new Location(1, 5);//rotate block
            locs[3] = new Location(0, 6);
        }
        else
        {
            for (int i=0; i<4; i++)
            {
                arrayBlocks[i] = new Block();
                arrayBlocks[i].setColor(Color.GREEN);
            }
            locs[1] = new Location(0, 4);
            locs[0] = new Location(0, 5);//rotate block
            locs[2] = new Location(1, 5);
            locs[3] = new Location(1, 6);
        }
        addToLocations(grid, locs);
    }
    /**
     * sets the entered locations to the tertead locs array
     * @param grid the grid
     * @param locs Array of Locations
     */
    private void addToLocations(MyBoundedGrid<Block> grid, Location[] locs)
    {
        for(int i=0; i<4; i++)
        {
            arrayBlocks[i].putSelfInGrid(grid, locs[i]);
        }
    }
    /**
     * removes the blocks in the tetrad which are at locs
     * @return Location[] array of Locations where the blocks were removed
     */
    private Location[] removeBlocks()
    {
        for (int i=0; i<4; i++)
        {
            locs[i] = arrayBlocks[i].getLocation();
            arrayBlocks[i].removeSelfFromGrid();
        }
        return locs;
    }
    /**
     * checks if the locations in the array are empty
     * @param locs a array of Locations to check
     * @param grid the grid
     * @return boolean if the locations are empty
     */
    private boolean areEmpty(MyBoundedGrid<Block> grid, Location[] locs)
    {
        for (int i=0; i<locs.length; i++)
        {
            if(!grid.isValid(locs[i]) || grid.get(locs[i]) != null)
            {
                return false;
            }
        }
        return true;
    }
    /**
     * Changes the position of the tetrad if possible
     * @param deltaRow the change in the row
     * @param deltaCol the change in the collum
     * @return boolean if the tetrad was able to move
     */
    public boolean translate(int deltaRow, int deltaCol)
    {
        Location[] locs = removeBlocks();
        Location[] newLoc = new Location[4];
        for (int i=0; i<4; i++)
        {
            newLoc[i] = new Location(locs[i].getRow()+deltaRow, 
                locs[i].getCol()+deltaCol);
        }
        if(areEmpty(grid, newLoc))
        {
            addToLocations(grid, newLoc);
            return true;
        }
        addToLocations(grid, locs);
        return false;
    }
    /**
     * rotates the tetrad
     * @return boolean if the tetrad was able to rotate
     */
    public boolean rotate()
    {
        
        Location[] locs = removeBlocks();
        Location[] newLoc = new Location[4];
        Location locOg = locs[0];
        for (int i=0; i<4; i++)
        {
            newLoc[i] = new Location(locOg.getRow()-locOg.getCol()
                +locs[i].getCol(), locOg.getRow()+locOg.getCol()
                -locs[i].getRow());
        }
        if(areEmpty(grid, newLoc))
        {
            addToLocations(grid, newLoc);
            return true;
        }
        addToLocations(grid, locs);
        return false;
    }
    /**
     * sees if the the tetrad stops over or at the limit which is the top row
     * @return if the tetrad stops above or on the top row
     */
    public boolean overLimit()
    {
        for (int i=0; i<4; i++)
        {
            if(locs[i].getRow()==0)
            {
                return true;
            }
        }
        return false;
    }
}