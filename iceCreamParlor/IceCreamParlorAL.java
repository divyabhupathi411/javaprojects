import java.util.ArrayList;
/**
 * Provides an inventory for IceCreamParlor using ArrayList of  IceCream
 * IceCreamParlorAL class has differnt methods for differnt flavors of Ice 
 * Creams stored in a ArrayList
 * 
 * @author Susan King 
 * @author Martin Baynes
 * @author Alexandra Michael modified for Checkstyle
 * @author Divya Bhupathi
 * 
 * @version October 20, 2024
 */
public class IceCreamParlorAL
{
    // instance variables
    private String parlorName;
    private ArrayList<IceCream> inventory;

    /**
     * Constructor for objects of class IceCreamParlorAL
     */
    public IceCreamParlorAL()
    {
        parlorName = "BICP -- Best Ice Cream Parlor";
        inventory = new ArrayList<IceCream>();
        inventory.add(new IceCream());
        inventory.add(new IceCream ("Skinny Butter Pecan", 
                new String[] {"milk", "cream", "sugar", "pecans", "butter" }, 
                120));
        inventory.add(new IceCream("Chocolate Double Fudge", 
                new String[] {"chocolate", "milk", "vanilla extract", 
                    "condensed milk", "salt", "heavy cream"},
                180));
        inventory.add(new IceCream("Strawberry Cheesecake", 
                new String[]{"milk", "cream", "sugar", "cheesecake", "strawberries" },
                150));
        inventory.add(new IceCream("Moose Track", 
                new String[]{"milk", "cream", "sugar", "peanut butter",
                    "chocolate fudge", "caramel"}, 
                175));
        inventory.add(new IceCream("Lite Mint Chocolate Chip", 
                new String[] {"milk", "cream", "sugar", "chocolate chips", "mint"}, 
                120));
        inventory.add(new IceCream("Java Chip", 
                new String[] {"milk", "cream", "sugar", "chocolate chips", "coffee base"}, 
                150));
        inventory.add(new IceCream("Madagascar Vanilla Bean", 
                new String[] {"milk", "cream", "sugar", "vanilla bean"}, 
                160));
        inventory.add(new IceCream("Chocolate Chip Cookie Dough", 
                new String[] {"milk", "cream", "sugar", "chocolate chips", "cookie dough"}, 
                170));
    }

    /**
     * Retrieve the parlor's name.
     * 
     * @return     the name of the parlor
     */
    public String getParlorName( )
    {
        return parlorName;
    }

    /**
     * Change the parlor's name.  New owners!
     * 
     * @param nam    the new name of the parlor
     */
    public void setParlorName(String nam)
    {
        parlorName = nam;
    }

    /**
     * Retrieve the inventory of ice cream in the parlor's
     * pantry.
     * 
     * @return     the parlor's inventory of ice cream
     */
    public ArrayList<IceCream> getInventory( )
    {
        return inventory;
    }

    /**
     * Change the list of ice cream in the inventory.
     * 
     * @param invent    the new list of ice cream
     */
    public void setInventory(ArrayList<IceCream> invent)
    {
        inventory = invent;
    }

    /**
     * Get average calories of the ice cream in the parlor.
     * 
     * @return average calories
     */
    public double getAverageCaloriesInInventory()
    {
        int sum = 0;
        for(int i=0; i<inventory.size();i++)
        {
            sum += ((inventory.get(i)).getCalories());
        }
        return (double)sum/inventory.size();
    }

    /**
     * Get minimum calories of the ice cream inventoryin the parlor.
     * 
     * @return minimum calories
     */
    public int getMinimumCaloriesInInventory()
    {
        int min = (inventory.get(0)).getCalories();
        for(int i=0; i<inventory.size();i++)
        {
            if ((inventory.get(i)).getCalories()< min)
            {
                min = (inventory.get(i)).getCalories();
            }
        }
        return min;
    }

    /**
     * Count ice creams with the least calories.
     * 
     * @precondition  at least one ice cream in the inventory
     * 
     * @return the number of ice creams with the fewest calories
     */
    public int countLowCalIceCreams()
    {
        int minCal= getMinimumCaloriesInInventory();
        int counter = 0;
        for(int i=0; i<inventory.size();i++)
        {
            if (minCal == (inventory.get(i)).getCalories())
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Retrieve ice creams with the least calories.
     * 
     * @precondition  at least one ice cream in the inventory
     * 
     * @return the array of ice cream objects with the fewest
     *         number of calories
     */
    public ArrayList<IceCream> locateLowCalIceCreams()
    {
        ArrayList<IceCream> lowCalVarieties = new ArrayList<IceCream>();
        int minCal= getMinimumCaloriesInInventory();
        for(int i=0; i<inventory.size();i++)
        {
            if (minCal == (inventory.get(i)).getCalories())
            {
                lowCalVarieties.add(inventory.get(i));
            }
        }

        return lowCalVarieties;
    }

    /**
     * Retrieve ice creams with a specific ingredient listed as
     * part of the ingredient's string.  This
     * method includes both counting and retrieving into one
     * method for demonstration purpose.
     * 
     * @param ingredient    the word being searched for in the 
     *                      ice creams' ingredients
     * @return a list of ice creams that are made with "ingredient"
     */
    public ArrayList<IceCream> locateIngredientMatches(String ingredient)
    {
        ArrayList<IceCream> match = new ArrayList<IceCream>();
        for(int i=0; i<inventory.size();i++)
        {
            if (inventory.get(i).isIngredientFound(ingredient))
            {
                match.add(inventory.get(i));
            }
        }
        return match;
    }

    /**
     * Retrieve ice creams with a specific word within its name.
     *  
     * @param word  the word that is being search in the ice creams' names
     * @return the array of ice cream objects with word in their name
     */
    public ArrayList<IceCream> locateNameAndWordMatches(String word)
    {
        ArrayList<IceCream> match = new ArrayList<IceCream>();
        for(int i=0; i<inventory.size();i++)
        {
            if (inventory.get(i).isNameFound(word))
            {
                match.add(inventory.get(i));
            }
        }
        return match;
    }

    /**
     * Print out the inventory for the parlor.
     */
    public void printInventory( )
    {
        System.out.println(parlorName + "'s Inventory");
        printIceCreams(inventory);
    }

    /**
     * Print out an array of ice creams.
     * 
     * @param iceCreams  the list of all the ice creams to be printed
     */
    public void printIceCreams(ArrayList<IceCream> iceCreams)
    {
        for (IceCream iceCreamSelected:iceCreams)
        {
            iceCreamSelected.printIceCream();
        }
    }

    /**
     * This method tests many of the programming
     * skills associated with arrays of objects that 
     * are not String objects.
     * 
     * @param args  the information being input from the command line
     */
    public static void main(String[] args)
    {
        IceCreamParlorAL iScream = new IceCreamParlorAL();
        iScream.printInventory();

        System.out.println("\n\nAVERAGE CALORIES = " + iScream.getAverageCaloriesInInventory());

        System.out.println("\n\nMATCH FOR CHOCOLATE IN NAME");
        iScream.printIceCreams(iScream.locateNameAndWordMatches("chocolate"));

        System.out.println("\n\nMATCH FOR SUGAR");
        iScream.printIceCreams(iScream.locateIngredientMatches("sugar"));

        System.out.println("\n\nMATCH FOR CHOCOLATE IN INGREDIENTS");
        iScream.printIceCreams(iScream.locateIngredientMatches("chocolate"));

        System.out.println("\n\nLOW CALORIES");
        iScream.printIceCreams(iScream.locateLowCalIceCreams());        

    }
}
