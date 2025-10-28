
/**
 * Discuss Polymorphism with regards to Interface, Abstract Class, Concrete Class,
 * and the GeometricShape Lab.
 * 
 * @author Marina Peregrino 
 * @version December 17, 2019
 *  
 * @author Susan King
 * @version September 16, 2023   // Modifications for CheckStyle
 */
public class PolymorphismReview
{
    /**
     * Allows students to tests ploymorphism concepts - one line at a time.
     * 
     * @param args information past via the command line
     */
    public static void main(String[] args)
    {
        /* REMOVE THIS COMMENT WHEN READY TO REVIEW POLYMORPHISM
        GeometricShape geo = new Circle("c");  
        // geo has type of GeoShape and refers to a Circle, 
        // the object stored in g must be of type GeoShape

        Nearable n  = new Circle("c"); 
        Circle c = n;  // Why does this not work? 
        //     n refers to a circle       
        //     but  n is Nearable 
        //     so cast (Circle) n
        Circle c =(Circle) n;   

        // all of these variables know the Nearable methods.  
        geo.isNearlyEqual(1.0, 1.1);    // GeinetricShape implements Nearable
        n.isNearlyEqual(1.0, 1.1);      // Nearable 
        c.isNearlyEqual(1.0, 1.1);      // parent implements Nearable 

        geo.toString();  
        // the object that geo points to will perform toString, in its own way.  
        n.toString();  // n has type Nearable, and refers to an Object that implements it.  
        c.toString();

        // geo and n both refer to Circles 
        geo.getRadius(); 
        n.getRadius();
        c.getRadius(); //only this way works even though n and c refer to exact same object

        // Notice the order of precedence for casting
        int i = (int)c.getRadius();
        double radius = geo.getRadius();
        // need to cast geo make it legible
        double radius = ((Circle)geo).getRadius();
        int j = (int) radius;  
        int ugly = (int)((Circle)geo).getRadius();

        // geo is GeometricShape 
        Nearable nr = geo; 
        // nr has type Nearable and refers to a GeometricShape, 
        // which is actually a circle

        Nearable na = new Square("s", 1.0); // this works same as above 
 
        // Which of the following will compile and run? 
        // Which can be edited to make them work? 
        GeometricShape ya = na;  // Can you edit to make it work?  

        Circle roundPeg = na;  //Why does this fail?  
        Circle roundPeg = (GeometricShape) na ;
        
        GeometricShape yan = (GeometricShape) na;  //this repair works

        
        // Variable declaration of type:
        //    Interface
        //    Abstract
        //    Concrete
        Nearable near;
        GeometricShape geoSh;
        Rectangle r;
        Square sq;

        // Which of the following are acceptable assignment statments? 
        //       = new Interface of same type 
        //       = new Abstract class  of same type 
        //       = new Concrete class of same type 
        //       = new Child class of same type 
        near  = new Nearable();
        geoSh = new GeometricShape();
        r     = new Rectangle ("r", 1.0, 2.0);
        sq    = new Square ("s", 1.5);

        // Which of the following are acceptable assignment statments? 
        //       = new Interface of another type 
        //       = new Abstract class  of another type 
        //       = new Concrete class of another type 
        //       = new Child class of another type 

        // Concrete Class:  Rectangle  
        r     = new Rectangle ("r", 1.0, 2.0);
        near  = r;
        geoSh = r;
        r     = r; 
        sq    = (Square) r;  // Does it compiles? Will it run?
                             // An example of ClassCastException

        // Child Class:  Square 
        sq    = new Square ("s", 1.5);
        near  = sq;
        geoSh = sq;
        r     = sq; 
        sq    = sq;

        // Abstract Class: GeometricShape
        near  = geoSh;
        geoSh = geoSh;
        r     = geoSh; 
        sq    = geoSh;

        // Need to cast. 
        sq = (Square) geoSh;
        r  = (Square) geoSh;
        r  = (Rectangle) geoSh;

        // Iterface: Nearable
        near  = near;
        geoSh = near;
        r     = near; 
        sq    = near;

        // Need to cast correctly.  
        geoSh = (GeometricShape) near;
        r     = (GeometricShape) near;
        r     = (Rectangle) near;
        sq    = (Rectangle) near;
        sq    = (Square) near;

        System.out.println("Polymorphism is useful and fun");
        /*   */
    }
}
