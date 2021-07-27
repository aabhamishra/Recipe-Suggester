import java.util.ArrayList;
import java.util.Hashtable;
public class RecipeHashTable {

	public HashTableMap<String, Recipe> map;
	
	public RecipeHashTable() {
		makeHashTable();
	}
	
	/**
	 * Initializes the hash table with recipe objects, using the recipe name as the key
	 */
	private void makeHashTable() {
		map = new HashTableMap<String, Recipe>();
		map.put("Omelette", new Recipe("Omelette", "Egg, cheese, onion, ham, bellpepper"));
		map.put("PB and J", new Recipe("PB and J", "Bread, peanutbutter, jelly"));
		map.put("Sheet Pan Tofu", new Recipe("Sheet Pan Tofu", "Tofu, broccoli, soysauce, rice"));
		map.put("Chicken Parmesan", new Recipe("Chicken Parmesan", "chicken, pasta, tomato sauce, cheese"));
		map.put("Quesadillas", new Recipe("Quesadillas", "tortilla, cheese, chicken"));
		map.put("Chocolate Chip Cookies",  new Recipe("Chocolate Chip Cookies", "butter, sugar, egg, flour, chocolate"));
		map.put("Sauteed Spinach", new Recipe("Sauteed Spinach", "spinach, onion, garlic, butter, soysauce, salt"));
		map.put("Fried Rice", new Recipe("Fried Rice", "rice, egg, carrots, onions, garlic, soysauce, chicken"));
		map.put("Sandwhich", new Recipe("Sandwhich", "Bread, cheese, ham"));
		map.put("Salad", new Recipe("Salad", "Lettuce, tomato, carrots, broccoli, ranch, bellpepper"));
		map.put("Spinach Stuffed Chicken", new Recipe("Spinach Stuffed Chicken", "Chicken, butter, spinach, garlic, cheese"));
		map.put("Beef Tacos", new Recipe("Beef Tacos", "Tortilla, beef, cheese, lettuce, tomato, tomatoSauce, onion"));
		map.put("Madeleine", new Recipe("Madeleine", "Butter, flour, sugar, egg, lemon"));
		map.put("Linguine", new Recipe("Linguine", "Pasta, tomato, lemon, garlic, cheese, salt"));
		map.put("Breakfast Meal", new Recipe("Breakfast Meal", "Egg, ham, bread, jelly"));
		map.put("Grilled Cheese", new Recipe("Grilled Cheese", "Bread, Cheese"));
		map.put("Chocolate Peanut Butter Bars", new Recipe("Chocolate Peanut Butter Bars", "butter, peanut butter, sugar, chocolate"));
		map.put("Beef and Broccoli", new Recipe("Beef and Broccoli", "Beef, broccoli, onion, soy sauce, rice"));
		map.put("Chicken Breast", new Recipe("Chicken Breast", "chicken, garlic, salt, cheese"));
		map.put("Rice and Egg", new Recipe("Rice and Egg", "Rice, egg, salt"));
		map.put("Chicken Fajitas", new Recipe("Chicken Fajitas", "lemon, chicken, bellpepper, tortilla, salt. onion"));
		map.put("Garlic Spaghetti", new Recipe("Garlic Spaghetti", "garlic, spaghetti, cheese, butter, salt, lemon"));
		map.put("Chili", new Recipe("Chili","beef, onion, tomato sauce, beans, garlic, salt"));
		map.put("Stuffed Peppers", new Recipe("Stuffed Peppers", "beef, bellpepper, cheese, rice"));
		map.put("Homemade Flatbread Pizza", new Recipe("Homemade Flatbread Pizza", "Flour, salt, tomatosauce, cheese"));
		map.put("Chicken Lettuce Wraps", new Recipe("Chicken Lettuce Wraps", "chicken, lettuce, soysauce, onion, bellpepper, garlic"));
		map.put("Beef Tostadas", new Recipe("Beef Tostadas", "tortilla, beef, beans, tomato, cheese"));
		map.put("Lentil Stew", new Recipe("Lentil Stew", "Lentil, Tomato, Onion, Garlic, Butter"));
		map.put("Ratatouille", new Recipe("Ratatouille", "onion, bellpepper, zucchini, garlic, tomato, rice"));
		map.put("Roasted Potatoes", new Recipe("Roasted Potatoes", "Potato, salt, butter, tomatoes"));
		
	}

	/**
	* Iterates through the hash table to find the recipe with the greatest amount of flags and returns it
	* @return Recipe - Returns the recipe with the most number of flags
	*/
		public Recipe getLargestFlag() {
		ArrayList<String> temp = new ArrayList<>();
		Recipe highestFlag = null;
		Recipe current = null;
		
		temp.add("Omelette");
		temp.add("PB and J");
		temp.add("Sheet Pan Tofu");
		temp.add("Chicken Parmesan");
		temp.add("Quesadillas");
		temp.add("Chocolate Chip Cookies");
		temp.add("Sauteed Spinach");
		temp.add("Fried Rice");
		temp.add("Sandwhich");
		temp.add("Salad");
		temp.add("Spinach Stuffed Chicken");
		temp.add("Beef Tacos");
		temp.add("Madeleine");
		temp.add("Linguine");
		temp.add("Breakfast Meal");
		temp.add("Grilled Cheese");
		temp.add("Chocolate Peanut Butter Bars");
		temp.add("Beef and Broccoli");
		temp.add("Chicken Breast");
		temp.add("Rice and Egg");
		temp.add("Chicken Fajitas");
		temp.add("Garlic Spaghetti");
		temp.add("Chili");
		temp.add("Stuffed Peppers");
		temp.add("Homemade Flatbread Pizza");
		temp.add("Chicken Lettuce Wraps");
		temp.add("Beef Tostadas");
		temp.add("Lentil Stew");
		temp.add("Ratatouille");
		temp.add("Roasted Potatoes");
		
		for (int i = 0; i < temp.size()-1; i++) {
			if (i == 0) {
				if (map.get(temp.get(i)).getFlags() >= map.get(temp.get(i + 1)).getFlags())
					highestFlag = map.get(temp.get(i));
				else {
					highestFlag = map.get(temp.get(i+1));
				}
			}
			else if (i > 1) {
				current = map.get(temp.get(i));
				if (current.getFlags() > highestFlag.getFlags())
					highestFlag = current;
			}
		}
		return highestFlag;
	}
}