
import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTestSuiteBrock {
  static RecipeHashTable map;
  static BackEndDev backEnd;

  /**
   * Creates a BackEndDev() and RecipeHashTable() instance to use in each test
   * 
   * @throws FileNotFoundException
   */
  @BeforeEach
  void setUp() throws FileNotFoundException {
    backEnd = new BackEndDev();
    map = new RecipeHashTable();
  }

  /**
   * Test method for when there is an invalid recipe name Should throw a NoSuchElementException.
   */
  @Test
  void testInvalidName() {
    try {
      map.map.get("Sheet Pin Tofu"); // check miss spelling the second word
      fail();
    } catch (NoSuchElementException e) {
      return;
    }
    try {
      map.map.get("ChickenParmesan"); // check no space
      fail();
    } catch (NoSuchElementException e) {
      return;
    }
    try {
      map.map.get("galic spaghetti"); // check miss spelling the first word
      fail();
    } catch (NoSuchElementException e) {
      return;
    }

  }

  /**
   * Tests that the recipe object initializes and stores data correctly
   */
  @Test
  void testRecipeObjInit() {
    map.map.put("Sheet Pan Tofu", new Recipe("Sheet Pan Tofu", "Tofu, Broccoli, SoySauce, Rice"));
    map.map.put("Beef and Broccoli",
        new Recipe("Beef and Broccoli", "Beef, Broccoli, Onion, SoySauce, Rice"));
    map.map.put("Rice and Egg", new Recipe("Rice and Egg", "Rice, Egg, Salt"));
    // check if the added Ingredients equal the correct ingredients
    if (!map.map.get("Sheet Pan Tofu").getIngredients().equals("Tofu, Broccoli, SoySauce, Rice")) {
      fail();
    } else if (!map.map.get("Beef and Broccoli").getIngredients()
        .equals("Beef, Broccoli, Onion, SoySauce, Rice")) {
      fail();
    } else if (!map.map.get("Rice and Egg").getIngredients().equals("Rice, Egg, Salt")) {
      fail();
    }

  }

  /**
   * Tests the number of flags raised for the ingredients listed the recipes have the correct number
   * of flags
   */
  @Test
  void testNumberFlags() {

    backEnd.storeIngred("PeanutButter, Bread");

    if (backEnd.recipeTable.map.get("PB and J").getFlags() != 2) { // There are two matches
      fail();
    } else if (backEnd.recipeTable.map.get("Ratatouille").getFlags() != 0) { // No ingredient match
      fail();
    } else if (backEnd.recipeTable.map.get("Sandwhich").getFlags() != 1) { // Sandwich spelt wrong
      fail();
    }
  }

  /**
   * Tests that the get highest flag method returns the recipe with the most matching ingredients
   * 
   * @throws FileNotFoundException
   * 
   */
  @Test
  void testGetHighestFlag() throws FileNotFoundException {

    backEnd.storeIngred("Chicken, Pasta, TomatoSauce, Cheese");

    if (!backEnd.recipeTable.getLargestFlag()
        .equals(backEnd.recipeTable.map.get("Chicken Parmesan"))) {
      fail();
    }
    setUp();
    // Check with an extra ingredient
    backEnd.storeIngred("Butter, PeanutButter, Sugar, Chocolate, Rice");
    if (!backEnd.recipeTable.getLargestFlag()
        .equals(backEnd.recipeTable.map.get("Chocolate Peanut Butter Bars:"))) {
      fail();
    }

    setUp();
    // check with not all ingredients
    backEnd.storeIngred(" Garlic, Spaghetti, Cheese, Butter, Salt");

    if (!backEnd.recipeTable.getLargestFlag()
        .equals(backEnd.recipeTable.map.get("Garlic Spaghetti"))) {
      fail();
    }



    return;

  }



}
