import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
/**
 * Test the various GeometricShape classes.  
 * 
 * @author Susan King
 * @version September 16, 2023   // Modifications for CheckStyle
 */
public class GeometricShapeFileTester
{
    /**
     * Tests the GeometricShapes logic.
     * 
     * @param args information past via the command line
     */
    public static void main (String [ ] args) throws FileNotFoundException 
    {
        File file = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        int errorCounter = 0;
        try 
        {
            Triangle betty = new Triangle("betty", 1.0 , 2.0, 10.0);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println( "\nFirst: " +  e );
            System.out.println("\tCorrectly identified a triangle in "
                + "which the longest side > sum of other two sides");
        }

        try 
        {
            Rectangle fred = new Rectangle("Mr.Negative", -3 , -1.5);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println("\nSecond: " +   e );
            System.out.println("\tCorrectly identified negative sides for a rectangle");
        }

        try 
        {
            Rectangle zero = new Rectangle("zero", 3.0 , 0.0);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println("\nThird " +  e );
            System.out.println("\tCorrectly identified a width of 0 for a rectangle");
        } 

        try 
        {
            Triangle fred = new Triangle("Mr.Negative", -3.0 , -1.5 , -2.0);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println("\nFourth " +   e );
            System.out.println("\tCorrectly identified negative sides for a triangle");
        }

        try 
        {
            Triangle zero = new Triangle("zero", 3.0 , 1.5 , 0.0);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println( "\nFifth " +  e );
            System.out.println("\tCorrectly identified a length of 0");            
        } 

        try 
        {
            Circle betty = new Circle("pie", 0.0);
            errorCounter ++;
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println( "\nSixth: " +  e );
            System.out.println("\tCorrectly identified a radius of 0 ");
        }

        try 
        {
            IsoscelesRightTriangle one = new IsoscelesRightTriangle("one", 1 );
            one.setSideC(Math.sqrt(2));
            if (one.isNearlyEqual((Double)one.getSideA(), (Double)2.0) && 
                one.isNearlyEqual((Double)one.getSideB(), (Double)Math.sqrt(2)))
            {
                System.out.println("\nIsosceles right triangle correctly processed setSideC");
            }
            else
            {
                errorCounter++;
                System.out.println("\nIsosceles right triangle did not correctly process " +
                    "setSideC");
            }
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println(e);            
        } 

        try 
        {
            Triangle two = new EquilateralTriangle("two", 2 );
            two.setSideB(8);
            if (two.isNearlyEqual((Double)two.getSideA(), (Double) 8.0) && 
                two.isNearlyEqual((Double)two.getSideB(), (Double) 8.0) &&
                two.isNearlyEqual((Double)two.getSideC(), (Double) 8.0))
            {
                System.out.println("\nEquilateral triangle correctly processed setSideB");
            }
            else
            {
                errorCounter++;
                System.out.println("\nEquilateral triangle did not correctly process setSideB");
            }
        } 
        catch (IllegalArgumentException e)
        {    
            System.out.println( e );
        } 

        try 
        {
            IsoscelesRightTriangle one = new IsoscelesRightTriangle("three", 3.0 );
            one.setSideA(5);
            if (one.isNearlyEqual((Double)one.getSideA(), (Double)5.0) && 
                one.isNearlyEqual((Double)one.getSideB(), (Double)5.0/Math.sqrt(2.0)))
            {
                System.out.println("\nIsosceles right triangle correctly processed setSideA");
            }
            else
            {
                errorCounter++;
                System.out.println("\nIsosceles right triangle did not correctly process "
                    + "setSideA");
            }
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println(e);            
        } 

        Triangle alex = new Triangle("alex", 4.0001, 5, 6.);
        try 
        {
            Object testObject = new Object( );
            int x = alex.compareTo(testObject);
            if (x != -999)
            {
                errorCounter ++;
            }
            System.out.println("\nalex.compareTo(testObject) should return -999;"
                + " it returned " + x);
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println( e );
        }

        Rectangle rex = new Square ("rex", 7.0898154);
        try 
        {
            Object testObject = new Object( );
            int x = rex.compareTo(testObject);
            if (x != -999)
            {
                errorCounter ++;
            }
            System.out.println("\nrex.compareTo(testObject) should return -999;"
                + " it returned " + x);
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println( e );
        }

        Circle round = new Circle("round", 4);
        try 
        {
            System.out.println("\n\n" + alex);
            System.out.println(round);
            int y= alex.compareAnotherWay(round);
            System.out.println("\talex.compareAnotherWay(round) should"
                + " return a negative number; it returned " + y);
            if (y >= 0)
            {
                errorCounter ++;
            }
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println( e );
        }

        try 
        {
            System.out.println("\n\n" + rex);
            System.out.println(round);
            int y= rex.compareAnotherWay(round);
            System.out.println("\trex.compareAnotherWay(round) should return a 0; "
                + "it returned " + y);
            if (y != 0)
            {
                errorCounter ++;
            }
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println( e );
        }

        ArrayList<GeometricShape> geo = new ArrayList<GeometricShape>( );
        geo.add(new Triangle("alex", 4.0001, 5, 6.));
        geo.add(new Triangle("almost", 4.00011, 5, 6));
        geo.add(new EquilateralTriangle("bob", 7));
        geo.add(new IsoscelesRightTriangle("cathy", 6.5142336));
        geo.add(new Triangle("derek", 6.5142336, 6.5142336, 9.21252));
        geo.add(new Rectangle("edward", 6.3, 4.5));
        geo.add(new Rectangle("fred", 4.5 , 6.3));
        geo.add(new Rectangle("gail", 6.3 , 4.5));
        geo.add(new Rectangle("helena", 14.17963, 14.17963));
        geo.add(new Square("iris", 5.077706));
        geo.add(new Rectangle("jerome", 5, 5.15665));
        geo.add(new Circle("kate", 8));
        System.out.println("\n\n");
        for (GeometricShape g: geo)
        {
            System.out.println("\n\n\n");
            System.out.println(g);

            String className = g.getClass().getName();
            if (className.equals("IsoscelesRightTriangle"))
            {
                className = "IsoRtTri";
            }
            else if (className.equals("EquilateralTriangle"))
            {
                className = "EquilTri";
            }
            System.out.printf("%-10s\t%-15s\t%-10s\t%-7s %s\n", 
                g.getLabel( ), className, 
                ".compareTo", ".equals", " .compareAnotherWay");
            for (GeometricShape s: geo)
            {
                className = s.getClass().getName();
                if (className.equals("IsoscelesRightTriangle")) 
                {
                    className = "IsoRtTri";
                }
                else if (className.equals("EquilateralTriangle"))
                {
                    className = "EquTri";
                }
                System.out.printf("  %-8s\t%-15s\t%4d\t\t%-6b\t%4d\n",
                    s.getLabel( ),
                    className,
                    g.compareTo(s),
                    g.equals(s),
                    g.compareAnotherWay(s) );
            }
        }

        System.out.println("\n\nError count = " + errorCounter);
    }
}