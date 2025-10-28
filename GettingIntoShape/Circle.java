/**
 * A Circle object has a radius that is valid.
 * Perimeter and area are calculated.  
 * The algorithms of the equals method and the Comparable 
 * method compareTo use the radii.
 * 
 * @author Susan King 
 * @author Divya Bhupathi
 * @version September 16, 2023   // Created the template
 * @version November 7, 2024 // recently edited
 */
public class Circle extends GeometricShape
{
    // instance variable
    private double radius;
    /**
     * Constructor for objects of class Circle.
     * 
     * @param label name of the circle
     * @param r     radius
     * @throws IllegalArgumentException if r is less than or 
     *         equal to zero
     */
    public Circle(String label, double r)
    {
        super(label);
        radius = r;
        if (radius <= 0)
        {
            throw new IllegalArgumentException("Radius needs to be positive");
        }
    }
    /**
     * Constructor for unit circle object of class Circle.
     * "this" circle has a radius of length one.
     * 
     * @param label name of the circle
     */
    public Circle(String label)
    {
        this(label, 1.0);
    }
    /**
     * getter of radius
     * @return radius
     */
    public double getRadius()
    {
        return radius;
    }
    /**
     * Sets the length of the radius.
     * 
     * @param r the length of the new radius and r > 0
     * @throws IllegalArgumentException if radius is <= 0
     */    
    public void setRadius( double r )
    {
        if (r>0)
        {
            radius = r; 
        }
        else
        {
            throw new IllegalArgumentException("Invalid side radius");
        }
    }
    /**
     * it calculates the perimeter
     * @return the perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return 2 * radius * Math.PI;
    }
    /**
     * it calculates the area
     * @return the area
     */
    @Override
    public double calculateArea()
    {
        return radius * Math.PI * radius;
    }
    /**
     * checks if it is a polygon but circle is not polygon
     * @return false as a circle has no sides
     */
    @Override
    public boolean isPolygon()
    {
        return false;
    }
    /**
     * Compares current circle's radius with the Object obj's
     * radius.
     * 
     * @param obj   Circle object with which to compare
     * @return  0   if the two circles have the same radii within 
     *              an epsilon,  which is defined in GeometricShape
     *        > 0   if "this" radius > than obj's radius
     *        < 0   if "this" radius < than obj's radius
     *        -999  if obj is not a circle
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Circle)
        {
            return compareToNearly(getRadius(), ((Circle)obj).getRadius());
        }
        else
        {
            return -999;
        }
    }
    /**
     * Tests if the two circles have radii that are equal, 
     * within an EPSILON, which is defined in GeometricShape.
     * 
     * @param obj   Circle object to test if its radius is 
     *              "nearly equal" to "this" radius
     * @return true if the radii have "nearly equal" lengths; otherwise,
     *         false
     */
    public boolean equals (Object obj)
    {
        return (compareTo(obj) == 0);
    }
    /**
     * Formats the class name, the circle's label, area, perimeter, 
     * and radius for the circle.
     * 
     * @return formatted information about the circle
     */
    @Override
    public String toString ()
    {
        return super.toString( ) + 
               String.format("\n\t\t\tradius = %10.5f", this.getRadius());
    }
    /**
     * Hashcode is beyond the scope of this lab
     * Objects that are considered equal must have equivalent hashcodes.
     * Though unequal objects may or may not have different hashcodes.
     *
     * @return  the hash code for this object
     *
     * @throws UnsupportedOperationException    hashcode is not yet implemented
     */
    @Override
    public int hashCode()
    {
        throw new java.lang.UnsupportedOperationException("Hashcode is beyond" 
            + " the scope of this class");
    }
}
