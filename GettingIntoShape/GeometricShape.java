/**
 * Abstract class GeometricShape focuses on the shape's
 * name, perimeter, and area. Comparable methods allow
 * shapes to be compared.
 * 
 * @author Susan King
 * @author Divya Bhupathi
 * @version September 16, 2023   // Created the template.
 * @version November 7, 2024 // recently edited
 */
public abstract class GeometricShape implements Comparable, AnotherComparable, Nearable
{
    /**
     * The acceptable epsilon (aka delta) constant
     */
    public static final double EPSILON = 1.0e-5;  
    
    /*
     * Label or name of the geometric shape.  Some clients assign a familiar label
     * such as "John"; others might use the labels of the vertices such as "ABC".
     */
    private String label;
    /**
     * Initializes the instance variable label for a GeometricShape.
     * 
     * @param label  the name given to a particular geometric shape
     */
    public GeometricShape( String label )
    {
        this.label = label;
    }
    /**
     * getter for label
     * @return label
     */
    public String getLabel()
    {
        return label;
    }
    /**
     * setter for label
     * @param label lable of shape
     */
    public void setLabel(String label)
    {
        this.label = label;
    }    
    /**
     * Compares current geometric shape with the Object obj.  
     * The comparison depends upon the geometric shape.  
     * For example, circles are compared by their radii.
     * 
     * @param  obj    GeometricShape object with which to compare
     * @return true   if the two shapes are basically the same within 
     *                an EPSILON tolerance; otherwise, 
     *         false
     */ 
    @Override
    public abstract boolean equals(Object obj);
    /**
     * Compares current geometric shape with the Object obj.  
     * The comparison depends upon the geometric shape.  
     * For example, circles are compared by their radii.
     * 
     * @param obj    GeometricShape object with which to compare
     * @return   0   if the two geometric shapes are basically the  
     *               same within an EPSILON tolerance
     *         > 0   if "this" object > than obj's object
     *         < 0   if "this" object < than obj's object
     */ 
    @Override
    public abstract int compareTo(Object obj);
    /**
     * Compares two geometric shapes based upon the areas of 
     * the geometric shapes.
     * 
     * @param obj  the geometric shape being compared
     * 
     * @return   0 if two shapes have the same area within an EPSILON tolerance,
     *         > 0 if "this" shape has an area greater than obj, or
     *         < 0 if "this" shape has an area less than obj
     *         
     * @throws IllegalArgumentException if obj is not a GeometricShape object
     */
    public int compareAnotherWay(Object obj)
    {
        if (obj instanceof GeometricShape)
        {
            GeometricShape gs = (GeometricShape)obj;
            double area = calculateArea();
            double otherArea = gs.calculateArea();
            return compareToNearly(area, otherArea);
        }
        else
        {
            String msg = "Expected Geometric Shape found" + obj.getClass() + "instead";
            throw new IllegalArgumentException("");
        }
    }
    /**
     * Determines if two numbers are within an epsilon difference.
     * 
     * @param x Double object to be tested to be close to another Double object
     * @param y Double object to be tested to be close to another Double object
     * 
     * @return true if the numbers are close to each other; otherwise,
     *         false        
     *         
     * @throws IllegalArgumentException if x or y is not a Double object
     */
    public boolean isNearlyEqual(Object x , Object y)
    {
        return (compareToNearly(x, y) == 0);
    }
    /**
     * Compares two numbers with the consideration of an epsilon difference.
     * 
     * @param x Double object to be tested to be close to another Double object
     * @param y Double object to be tested to be close to another Double object
     * 
     * @return   0   if the two objects are basically the  
     *               same within an EPSILON tolerance
     *         > 0   if the x object > than the y object
     *         < 0   if the x object < than the y object       
     *         
     * @throws IllegalArgumentException if x or y is not a Double object
     */
    public int compareToNearly(Object x , Object y)
    {
        if (x instanceof Double && y instanceof Double)
        {
            double xD = (Double)x;
            double yD = (Double)y;
            double diff = xD - yD;
            double absDiff = Math.abs(diff);
            // Barron's 8th Ed. page 75 and Barron's 9th Ed. page 73 have the following formula
            double acceptableEpsilon = EPSILON * Math.max(Math.abs(xD), Math.abs(yD));
            
            // The remainder of this method is a class activity.
            if (absDiff<=acceptableEpsilon)
            {
                return 0;
            }
            else if (-1.0 < diff && diff < 0.0)
            {
                return -1;
            }
            else if (0.0 < diff && diff < 1.0)
            {
                return 1;
            }
            else
            {
                return (int)(diff);
            }
        }
        else 
        {
            throw new IllegalArgumentException("Needs to be a Double");
        }
    }  
    /**
     * calculates area
     * @return double calculated area
     */
    public abstract double calculateArea();
    /**
     * calculates perimeter
     * @return double calculated perimeter
     */
    public abstract double calculatePerimeter();
    /**
     * checks if it is a polygon but is abstract
     * @return boolean true or false if it is a polygon
     */
    public abstract boolean isPolygon();
    /**
     * Formats the geometric object's class name, the object's 
     * label, its area and its perimeter.
     * 
     * @return a formatted line about the geometric object
     */
    @Override
    public String toString( )
    {
        String className = this.getClass().getName();
        if (className.equals("IsoscelesRightTriangle")) 
        {
            className = "IsoRtTri";
        }
        else if (className.equals("EquilateralTriangle"))
        {
            className = "EquilTri";
        }
        return String.format("%s\t %s\n\t\t\tarea = %8.5f\tperimeter = %8.5f ",
                             className, 
                             getLabel( ),
                             calculateArea( ),
                             calculatePerimeter( ) );
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
    public abstract int hashCode();
}