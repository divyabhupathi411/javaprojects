/**
 * A Triangle object has three sides that are valid
 * for a triangle.  The following relationship is maintained:
 * sideA >= sideB >= sideC. Perimeter and area are calculated.
 * The algorithms of the equals method and the Comparable 
 * method compareTo uses the three side lengths.
 * 
 * @author  Susan King
 * @version September 16, 2023   // Created the template.
 * @author Divya Bhupathi
 * @version November 11, 2024
 */
public class Triangle extends Polygon
{
    /** 
     * The three side lengths of the triangle
     */
    private double sideA;
    private double sideB;
    private double sideC;
    /**
     * Constructor for objects of class Triangle.
     * @postcondition  sideA >= sideB >= sideC
     * @param name name of the triangle, probably vertices
     * @param m    one of the side lengths of the triangle
     * @param n    another of the side lengths of the triangle
     * @param p    last of the side lengths of the triangle
     */
    public Triangle(String name, double m, double n, double p)
    {
        super(name, 3);
        orderSides(m, n, p);
    }
    /**
     * Order the side lengths so that sideA >= sideB >= sideC.
     * @param a    one of the side lengths of the triangle
     * @param b    another of the side lengths of the triangle
     * @param c    last of the side lengths of the triangle
     * @postcondition   sideA >= sideB >= sideC
     * @throws IllegalArgumentException if the sides do not make a valid triangle
     */
    public void orderSides(double a, double b, double c)
    {
        sideA = Math.max(Math.max(a, b), c);
        sideC = Math.min(Math.min(a, b), c);
        sideB = (a+b+c)-sideA-sideC;
        if (sideA > sideB+sideC || sideA <= 0 || sideB <= 0 || sideC <= 0)
        {
            throw new IllegalArgumentException("Invalid side lengths");
        }
    }
    /**
     * gets the length of the longest side.
     * @return sideA returns sideA
     */    
    public double getSideA()
    {
        return sideA;
    }
    /**
     * gets the length of the middle side.
     * @return sideB returns side B
     */    
    public double getSideB()
    {
        return sideB;
    }
    /**
     * gets the length of the shortest side.
     * @return sideC returns side C
     */
    public double getSideC()
    {
        return sideC;
    }
    /**
     * Changes the length of the longest side.
     * @param anotherA  the length of the modified sideA
     */    
    public void setSideA(double anotherA)
    {
        orderSides(anotherA, sideB, sideC);
    }
    /**
     * Changes the length of the middle side.
     * @param anotherB  the length of the modified sideB
     */    
    public void setSideB(double anotherB)
    {
        orderSides(sideA, anotherB, sideC);
    }
    /**
     * Changes the length of the shortest side.
     * @param anotherC  the length of the modified sideC
     */    
    public void setSideC(double anotherC)
    {
        orderSides(sideA, sideB, anotherC);
    }
    /**
     * calculates Perimeter of the Triangle.
     * @return the Perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return sideA + sideB + sideC;
    }
    /**
     * calculates area of the Triangle.
     * @return the area
     */    
    public double calculateArea()
    {
        double s = (sideA + sideB + sideC)/2;
        return (Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC)));
    }  
    /**
     * Tests if the two triangles are similar, within an EPSILON,
     * which is defined in GeometricShape.
     * @param obj       Triangle object to test if similar
     * @return true     if the sides have the same length; otherwise,
     *         false
     */
    public boolean equals (Object obj)
    {
        if (obj instanceof Triangle)
        {
            Triangle oT = (Triangle)(obj);
            double otherA = oT.getSideA();
            double otherB = oT.getSideB();
            double otherC = oT.getSideC();
            return (isNearlyEqual(sideA, otherA)
                && isNearlyEqual(sideB, otherB)
                && isNearlyEqual(sideC, otherC)); 
        }
        return false;
    }
    /**
     * Compares the current triangle's side lengths with 
     * the Object obj's side lengths. The comparisons use 
     * the epislon formula that is defined in GeometricShape.
     * The comparison is done using the following algorithm.
     * 
     * Step 1. If all three side lengths are considered equal, a zero is returned.
     * 
     * Step 2. If not, then the two triangle's longest sides are compared.
     *         If they are not considered equal, the return is negative if the
     *         current triangle's longest side is shorter than obj's longest side;
     *         otherwise, the return is positive.
     *    
     * Step 3. If not, then the two triangle's medium-length sides are compared.
     *         If they are not considered equal, the return is negative if the
     *         current triangle's medium-length side is shorter than obj's medium-length;
     *         otherwise, the return is positive.
     *         
     * Step 4. If not, then the two triangle's shortest sides are compared.
     *         The return is negative if the current triangle's sortest side is 
     *         shorter than obj's shortest side; otherwise, the return is positive.
     * 
     * @param obj Triangle object with which to compare
     * 
     * @return   0  if the two triangles have the same side lengths within an epsilon,
     *              which is defined in GeometricShape.
     *         > 0  as defined by the algorithm explained above.
     *         < 0  as defined by the algorithm explained above.
     *         -999 if obj is not a Triangle
     */
    public int compareTo(Object obj)
    { 
        if(obj instanceof Triangle)
        {
            if(equals(obj))
            {
                return 0;
            }
            int diff = compareToNearly(sideA, ((Triangle)obj).getSideA());
            if(diff != 0)
            {
                return diff; 
            }
            diff = compareToNearly(sideB, ((Triangle)obj).getSideB());
            if(diff != 0)
            {
                return diff;
            }
            return compareToNearly(sideC, ((Triangle)obj).getSideC());
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
        if(sideA == sideB && sideB == sideC)
        {
            return true;
        }
        return false; 
    }
    /**
     * Formats the class name, the triangle's label, area, perimeter, 
     * and the three sides of the triangle plus whether it is regular
     * and that it has three sides.
     * @return formatted information about the triangle
     */
    @Override
    public String toString ( )
    {
        String str = "\n\t\t\ta = %8.5f\tb = %8.5f\tc = %8.5f" +
            "\n\t\t\tside count = %d\t\tregular: %b";
        return super.toString( ) + 
        String.format(  str,
            getSideA( ),
            getSideB( ),
            getSideC( ),
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