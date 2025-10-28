/**
 * This is the Square class which extends the Rectangle class as it is  just a regular 
 * rectangle.
 * 
 * @author Divya Bhupathi
 * @version November 11, 2024
 */
public class Square extends Rectangle
{
    /**
     * Constructor for objects of class Square with 1 parameter, label and a a unit square
     * @param label label of the square
     */
    public Square(String label)
    {
        this(label, 1);
    }
    /**
     * Constructor for objects of class Square with 2 parameters so it calls super to 
     * use the constructor from Rectangle
     * @param label label of the square
     * @param side length of the side of the square
     */
    public Square(String label, double side)
    {
        super(label, side, side);
    }
    /**
     * setter for the length
     * @param length side length of the square
     */    
    @Override
    public void setLength(double length)
    {
        if (length>0)
        {
            super.setLength(length);
            super.setWidth(length);
        }
        else
        {
            throw new IllegalArgumentException("Length is not legal for a square");
        }
    }
    /**
     * setter for width
     * @param width side length of the square (same as length)
     */ 
    @Override
    public void setWidth(double width)
    {
        if (width>0)
        {
            super.setWidth(width);
            super.setLength(width);
        }
        else
        {
            throw new IllegalArgumentException("Width is not legal for a square");
        }
    }
}