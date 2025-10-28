/**
 * A Polygon object is a multiple-sided object.
 * Perimeter and area can be calculated.  Additional
 * methods permit getting the number of sides and 
 * whether a figure is a polygon.
 * 
 * @author Susan King 
 * @author Divya Bhupathi
 * @version September 16,2023    // Created the template.
 * @version November 7, 2024 // recently edited
 */
public abstract class Polygon extends GeometricShape
{
    private int sideCount;
    /**
     * Constructor for objects of class Polygon.
    * 
     * @param label     polygon's label, probably vertices
     * @param sideCount the number of sides in the polygon
     */
    public Polygon(String label, int sideCount)
    {
        super(label);
        this.sideCount = sideCount;
    }
    /**
     * checks if it is a polygon
     * @return boolean true because all poylgons are polygons 
     */
    @Override
    public boolean isPolygon()
    {
        return true;
    }    
    /**
     * checks if the polygon is regular and abstract because it depends on the polygon.
     * @return a boolean for if it is regular meaning sides and angles are the same length
     */
    public abstract boolean isRegular();
    /**
     * gets number of sides
     * @return number of sides
     */
    public int getNumSides()
    {
        return sideCount;
    }
}