/**
 * This interface has one purposes that may be used to compare two objects for being less 
 * than, greater than or equal to another 
 * 
 * The other method compareAnotherWay is similar to the Comparable method compareTo
 * Just as with compareTo, this method can be used to 
 * impose an order to objects of each class that implements this interface.
 * 
 * @author Susan King
 * @version November 16, 2023   // Created the template
 */
public interface AnotherComparable
{
    /**
     * Compares two objects' quantities.   
     *  
     * @param  other    an object to be tested as close to this object
     * 
     * @return   0   if the two objects are basically the  
     *               same within an EPSILON tolerance
     *         > 0   if this  > than other
     *         < 0   if this  < than other 
     */ 
    int compareAnotherWay(Object other);
}
