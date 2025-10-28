import java.util.ArrayList;
/**
 * Tests the Triangle class portion of the GettingIntoShape project.
 * 
 * @author Susan King
 * @author Marina Peregrino
 * @version December 5, 2019
 */
public class TriangleTester
{
    /**
     * Tests the GeometricShapes' Triangle class.
     * 
     * @param args information past via the command line
     */
    public static void main (String [ ] args) 
    {
        double fourPlus = 4 + Math.pow(10, -5); //close enough to 4 
        double fourTooBig  = 4 + Math.pow(10, -2); // not "close enough" to 4

        /* Check constructors. */
        ArrayList<GeometricShape> triangles = new ArrayList<GeometricShape>(); 
        triangles.add(new Triangle ("A", 1, 2, 3));
        triangles.add(new Triangle ("Bee", 1, 2, 3));  //the same as a
        triangles.add(new Triangle ("four", 4, 5, 6)); //bigger than a
        triangles.add(new Triangle ("four-ish", fourPlus, 4, 5));  //about the same as four 
        triangles.add(new Triangle ("four-too-big", fourTooBig, 4, 5)); 
        //too big to be the same as four
        
        /* Check for a bad parameter. */
        try
        {
            System.out.println("\n\nTry creating a negative radius Triangle." );

            GeometricShape negative = new Triangle ("negative", -1, -2, -5);
        }        
        catch (IllegalArgumentException e)
        {
            System.out.println( "\tCorrectly rejects a negative radius: \n\t"+ e );
        }
        
        /* Check toString. */
        System.out.println ("\ntoString:\n");
        for (GeometricShape c : triangles)
        {
            System.out.println (c);
        }
        
        /* Check equals. */
        System.out.println ("\nequals: ");
        for (int j=0; j < triangles.size(); j++)
        {
            GeometricShape c = triangles.get(j);
            for (int i=j; i < triangles.size(); i++)
            {
                GeometricShape other = triangles.get(i);
                System.out.println ("\t"+ c.getLabel() +" equals " 
                                    + other.getLabel() + "? " 
                                    + c.equals (other)  );
            }
            System.out.println ("");
        }

        /* Check compareTo. */
        System.out.println ("\ncompareTo: ");
        for (int j=0; j < triangles.size(); j++)
        {
            GeometricShape c = triangles.get(j);
            for (int i=j; i < triangles.size(); i++)
            {
                GeometricShape other = triangles.get(i);
                System.out.println ("\t"+ c.getLabel() +" compareTo " 
                                    + other.getLabel() + ": " 
                                    + c.compareTo (other)  );
            }
            System.out.println ("");
        }

        /* Check compareAnotherWay. */
        System.out.println ("\ncompareAnotherWay: ");
        for (GeometricShape c : triangles)
        {
            for (GeometricShape other : triangles)
            {
                System.out.println ("\t"+ c.getLabel() +" compareAnotherWay "
                                    + other.getLabel()+ ": " 
                                    + c.compareAnotherWay(other));
            }
            System.out.println ("");
        }
    }
}