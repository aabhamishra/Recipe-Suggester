
public class Recipe {
	
	private String name;
	private String ingredients;
	private int flags;
	
	public Recipe (String name, String ingredients) {
		this.name = name;
		this.ingredients = ingredients;
		flags = 0;
	}
	
	/**
	 * Getter method for returning the name of the recipe
	 * @return name - returns the name of the recipe
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method for returning the name of the ingredients
	 * @return ingredients - returns all the ingredients needed for the recipe
	 */
	public String getIngredients() {
		return ingredients;
	}
	
	/**
	* Setter method for setting the amount of flags in a recipe
	*/
	public void incFlags() {
		this.flags++;
	}
	
	/**
	* Getter method for the amount of flags in a recipe
	* @return flags - returns the flags value
	*/
	public int getFlags() {
		return this.flags;
	}
}