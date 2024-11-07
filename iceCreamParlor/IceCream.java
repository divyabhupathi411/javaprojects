
/**
 * Practice Arrays and Classes with Ice Cream and Ice Cream Parlor
 * 
 * @author Susan King
 * @author Martin Baynes
 * @author Alexandra Michael modified for Checkstyle
 * @version July 6, 2018
 */
public class IceCream
{
    // instance variables 
    private String name;
    private String [ ]ingredients;
    private int calories;

    /**
     * Default constructor for objects of class IceCream.
     */
    public IceCream()
    {
        // initialise instance variables
        name = "Vanilla";
        ingredients= new String[]{"milk", 
                                  "vanilla extract", 
                                  "condensed milk", 
                                  "salt", 
                                  "heavy cream"};
        calories = 157;
    }
    
    /**
     * Constructor for objects of class IceCream.
     * 
     * @param nam    the name or flavor of the ice cream
     * @param ingred the array of ingredients that make up the ice cream
     * @param cal    the calories in 1/2 cup of ice cream
     */
    public IceCream(String nam, String[] ingred, int cal)
    {
        name = nam;
        ingredients = ingred;
        calories = cal;
    }

    /**
     * Retrieve the name or flavor of the ice cream.
     * 
     * @return     the name of the ice cream
     */
    public String getName( )
    {
        return name;
    }
    
    /**
     * Change the name or flavor of the ice cream.
     * 
     * @param nam    the new name of the ice cream
     */
    public void setName(String nam)
    {
        name = nam;
    }
    
    /**
     * Retrieve the ingredients in the ice cream.
     * 
     * @return a list of the ingredients of the ice cream
     */
    public String[] getIngredients( )
    {
        return ingredients;
    }
    
    /**
     * Change the list of ingredients of the ice cream.
     * 
     * @param ingred   the new list of ingredients of the ice cream
     */
    public void setIngredients(String [] ingred)
    {
        ingredients = ingred;
    }
    
    /**
     * Retrieve the calories of the ice cream.
     * 
     * @return     the calories of the 1/2 cup of ice cream
     */
    public int getCalories( )
    {
        
        return calories;
    }
    
    /**
     * Change the number of calories of the ice cream.
     * 
     * @param cal   the new calory count of the ice cream
     */
    public void setCalories(int cal)
    {
        calories = cal;
    }
    /**
     * Determine whether a particular item is part of the
     * name.  This can be used to avoid allergens or to 
     * find favorite flavors.
     * 
     * @param item the food item attempting to be located
     * 
     * @return true if item is found in the name; otherwise,
     *         false
     */
    public boolean isNameFound(String item)
    {
        // change code here
        return false;
    }
    
    /**
     * Determine whether a particular item is in the list of
     * ingredients.  This can be used to avoid food allergies 
     * or to find favorite flavors.
     * 
     * @param item the food item attempting to be located
     * 
     * @return true if item is found in the ingredient list; otherwise,
     *         false
     */
    public boolean isIngredientFound(String item)
    {
        item = item.toLowerCase();
        // add code here
        return false;
    }
    
    /**
     * Print the ice cream information.
     */
    public void printIceCream( )
    {
        System.out.println("Name: " + getName());
        System.out.println("\tCalories for 1/2 cup:  " + getCalories());
        System.out.println("\tIngredients:");
        if (ingredients == null)
        {
            System.out.println("\t\t\tIngredient list is empty");   
            return;
        }
        for (int i=0 ; i < ingredients.length ; i++)
        {
            System.out.println("\t\t" + ingredients[i]);
        }
    }
}
