import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class runProgram {
	public static void main(String[] args) throws IOException {
		String temp = args[0];
		BackEndDev B = new BackEndDev();
		
		B.storeIngred(temp);
		Recipe R = B.recipeTable.getLargestFlag();
		System.out.println("<html><body><br>The recipes that you can make are: " + R.getName() + "</body></html>");
                String string = R.getName().replaceAll("\\s+", "");
                System.out.println("<html><body><br><img src=\"images/"+string.toLowerCase()+".jpg\" alt=\""+string.toLowerCase()+"\"></body></html>");
	}
}
