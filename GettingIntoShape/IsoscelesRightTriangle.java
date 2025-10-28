/**
 * The IsoscelesRightTriangle class extends the triangle class. It is a specific type of 
 * Triangle where 2 of its three sides are equal.
 *
 * @author Divya Bhupathi
 * @version November 11, 2024
 */
public class IsoscelesRightTriangle extends Triangle
{
    /**
     * Constructor for objects of class IsoscelesRightTriangle
     * @param label the name of the IsoscelesRightTriangle object
     * @param leg the length of the leg that has the same length as one more side
     */
    public IsoscelesRightTriangle(String label, double leg)
    {
        super(label, leg*Math.sqrt(2.0), leg, leg);
    }
    /**
     * Changes the length of the no pair side.
     * @param anotherA  the length of the modified sideA
     */    
    @Override
    public void setSideA(double anotherA)
    {
        orderSides(anotherA, anotherA/Math.sqrt(2), anotherA/Math.sqrt(2));
    }
    /**
     * Changes the length of side with a pair that may be larger than sideA.
     * @param anotherB  the length of the modified sideB
     */   
    @Override
    public void setSideB(double anotherB)
    {
        orderSides(getSideA()*Math.sqrt(2), anotherB, anotherB);
    }
    /**
     * Changes the length of side that has a pair and is less than sideA.
     * @param anotherC  the length of the modified sideC
     */  
    @Override
    public void setSideC(double anotherC)
    {
        setSideB(anotherC);
    }
}