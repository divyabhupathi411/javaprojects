/**
 * The class EquilateralTriangle extends Triangle and has all equal sides.
 * @author Divya Bhupathi
 * @version November 11, 2024
 */
public class EquilateralTriangle extends Triangle
{
    /**
     * Constructor for objects of class EquilateralTriangle
     * @param label the label of the Equilateral Triangle
     * @param leg length of all the sides of the triangle
     */
    public EquilateralTriangle(String label, int leg)
    {
        super(label, leg, leg, leg);
    }
    /**
     * Changes the length of sideA.
     * @param anotherA  the length of sideA that will be the length of all sides
     */    
    @Override
    public void setSideA(double anotherA)
    {
        orderSides(anotherA, anotherA, anotherA);
    }
    /**
     * Changes the length of sideA.
     * @param anotherB  the length of sideB that will be the length of all sides
     */   
    @Override
    public void setSideB(double anotherB)
    {
        orderSides(anotherB, anotherB, anotherB);
    }
    /**
     * Changes the length of sideA.
     * @param anotherC  the length of sideC that will be the length of all sides
     */  
    @Override
    public void setSideC(double anotherC)
    {
        orderSides(anotherC, anotherC, anotherC);
    }
}