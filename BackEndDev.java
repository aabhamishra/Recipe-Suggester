

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackEndDev {

	// HashTable object
	RecipeHashTable recipeTable = new RecipeHashTable();
	// Ingredient list returned by front-end
	String[] ingredients = null;
	List<String> recipeList = null;
	
	public BackEndDev() throws FileNotFoundException {
		
		recipeList = readFile("src/List.txt");
		
	}
	
	/**
	 * Stores the list of ingredients inputed by user
	 * @param S
	 */
	public void storeIngred(String S) {
		 ingredients = toIngList(S);
		 raiseFlags();
	}
	/**
	 * This method converts the text file to a list of strings where each recipe has
	 * one line
	 * 
	 * @param fileName - name of file to read from
	 * @return list - array list of strings with one recipe per line
	 * @throws FileNotFoundException
	 */
	private static List<String> readFile(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNextLine()) {
			list.add(s.nextLine());
		}
		s.close();
		return list;
	}

	/**
	 * This method converts the string containing comma separated ingredients to an
	 * array of strings
	 * 
	 * @param s - string of ingredients returned by front end
	 * @return ingList - string array of ingredients user enters
	 */
	private String[] toIngList(String s) {
		String[] ingList = s.split(",");
		return ingList;
	}

	/**
	 * This method uses regex to search through the list of recipes for each
	 * ingredient and incrementing flag for each recipe object if there is a match
	 * for an ingredient
	 * 
	 * @param table
	 * @param list
	 * @param ingList
	 */
	private void raiseFlags() {

		for (String i : recipeList) {
			String recipename = i.split(":")[0];
			String recipeing = i.split(":")[1];
			for (String s : ingredients) {
				
				if (recipeing.toLowerCase().contains(s.toLowerCase())) {
					recipeTable.map.get(recipename).incFlags();
				}

			}
		}
	}


}
