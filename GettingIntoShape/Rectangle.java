/**
 * A rectangle object has four sides that are valid
 * for a rectangle.  Perimeter and area can be calculated.
 * The algorithms of the equals method and the Comparable 
 * method compareTo uses the length and width.
 * 
 * @author Susan King 
 * @version September 16, 2023   // Created the template.
 * @author Divya Bhupathi
 * @version November 11, 2024
 */
public class Rectangle extends Polygon
{
    private double length;
    private double width;
    /**
     * Constructor for objects of class Rectangle.
     * @param name  name of the rectangle
     * @param len   side length of rectangle
     * @param wid   other side length of rectangle
     * @throws IllegalArgumentException if the width or length is not valid
     */
    public Rectangle(String name, double len, double wid)
    {
        super(name, 4);
        length = len;
        width = wid; 
        if (length <= 0)
        {
            throw new IllegalArgumentException("Length is not legal for a rectangle");
        }
        else if(width <= 0)
        {
            throw new IllegalArgumentException("Width is not legal for a rectangle");
        }
    }
    /**
     * gets the length of the rectangle.
     * @return length returns length
     */    
    public double getLength()
    {
        return length;
    }
    /**
     * gets the width of the rectangle.
     * @return width returns width
     */    
    public double getWidth()
    {
        return width;
    }
    /**
     * Changes the length of the rectangle
     * @param length  the length of the rectangle
     * @throws IllegalArgumentException if length was less than or equal to zero
     */    
    public void setLength(double length)
    {
        if (length>0)
        {
            this.length = length;
        }
        throw new IllegalArgumentException("Length is not legal for a rectangle");
    }
    /**
     * Changes the width of the rectangle.
     * @param width  the width of the ractangle
     * @throws IllegalArgumentException if width was less than or equal to zero
     */  
    public void setWidth(double width)
    {
        if (width>0)
        {
            this.width = width;
        }
        throw new IllegalArgumentException("Width is not legal for a rectangle");
    }
    /**
     * Calculates the perimiter of the Rectangle
     * @return perimiter of the rectangle
     */  
    @Override
    public double calculatePerimeter()
    {
        return length*2 + width*2;
    }
    /**
     * Calculates the area of the Rectangle
     * @return area of the ractangle
     */  
    public double calculateArea()
    {
        return length*width;
    }
    /**
     * Tests if the two rectangle's side are similar, within an epsilon,
     * which is defined in GeometricShape.
     * @param obj   the Rectangle object to determine if similar to this object
     * @return true if the sides have the same length; otherwise,
     *         false
     */
    @Override
    public boolean equals (Object obj)
    {
        if (obj instanceof Rectangle)
        {
            Rectangle oT = (Rectangle)(obj);
            double testWidth = oT.getWidth();
            double testLength = oT.getLength();
            return (isNearlyEqual(length, testLength)
                && isNearlyEqual(width, testWidth));  
        }
        return false;
    }
    /**
     * Compares current rectangle's length and width with the 
     * Object obj's length and width. The comparisons use 
     * the epislon formula that is defined in GeometricShape.
     * The comparison is done using the following algorithm.
     * 
     * Rule 1. If length and widths are considered equal, a zero is returned.
     * 
     * Rule 2. If not, then the two rectangle's lengths are compared.
     *         If they are not considered equal, the return is negative if the
     *         current rectangle's length is shorter than obj's length;
     *         otherwise, the return is positive.
     *         
     * Rule 3. If not, then the two rectangle's widths are compared.
     *         The return is negative if the current rectangle's width is 
     *         shorter than obj's width; otherwise, the return is positive.
     *         
     * @param obj   the Rectangle object to be compared
     * 
     * @return  0  if the two rectangles have the same length and width within an epsilon,
     *             which is defined in GeometricShape.
     *         >0  as defined by the algorithm explained above.
     *         <0  as defined by the algorithm explained above.
     *       -999  if obj is not a Rectangle
     */
    public int compareTo(Object obj)//check code
    {
        if(obj instanceof Rectangle)
        {
            if(equals(obj))
            {
                return 0;
            }
            int diff = compareToNearly(length, ((Rectangle)obj).getLength());
            if(diff != 0)
            {
                return diff; 
            }
            return compareToNearly(width, ((Rectangle)obj).getWidth());
        }
        else
        {
            return -999;
        }
    }
    /**
     * checks if it is a regular shape
     * @return if it is a regular shape
     */ 
    public boolean isRegular()
    {
        if(width == length)
        {
            return true;
        }
        return false; 
    }
    /**
     * Formats the class name, the rectangle's name, area, perimeter, 
     * as well as the width and length of the rectangle.  In addition,
     * it includes whether it is a regular rectangle (square) and that it
     * has four sides.
     * @return formatted information about the rectangle
     */
    @Override
    public String toString ( )
    {
        String str = "\n\t\t\tlength = %8.5f\twidth = %8.5f" + 
                     "\n\t\t\tside count = %d\t\tregular: %b";
        return super.toString( ) + 
               String.format( str,
                              getLength( ),
                              getWidth( ),
                              getNumSides( ),
                              isRegular( ));
    }
    /**
     * Hashcode is beyond the scope of this lab
     * Objects that are considered equal must have equivalent hashcodes.
     * Though unequal objects may or may not have different hashcodes.
     * @return  the hash code for this object
     * @throws UnsupportedOperationException    hashcode is not yet implemented
     */
    @Override
    public int hashCode()
    {
        throw new java.lang.UnsupportedOperationException("Hashcode is beyond" 
            + " the scope of this class");
    }
}