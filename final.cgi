#!/bin/bash

echo "Content-type: text/html"
echo ""
echo "<html>
 <head>
	<style>
		body {
                        background-color: lightblue;
                }
                table {
                        text-align: center;
                        background-color: pink;
                }
                table, th, td {
                        border: 3px solid purple;
			border-collapse: collapse;
                }
                textarea {
                        resize: none;
                }
	</style>
	<title>Cooking Instruction Website</title>
	<script> <!--
		<!--When a button is clicked, check if it was submit.-->
		<!--If the button was submit, load the text in the textArea into the search bar and load the page.-->
		<!--If the button was not submit, add the button name into the textArea.-->
		
		function handleButtonClick(name) {
			let textArea = document.querySelectorAll(\"textarea\");
			if (name == \"Submit\") {
				var url = document.location.hash;
				document.location = url + \"?\"+textArea[0].innerHTML;
				console.log(textArea[0].innerHTML);
				return;
			}
		
                        textArea[0].innerHTML += name + \",\"+ \"\n\";
                }
	</script>
	<link type=\"text/css\" rel=\"stylesheet\" href=\"http://35.202.221.83/cgi-bin/style.css\">
 </head>
 <body>
 <p>This website will tell you the foods you're able to make with the ingredients you select.<br> To begin, select the ingredients you would like to use.</p><br>
	 <h3>Ingredients</h3>
	 
	 <table>
		 <tr>
			 <td><button id=\"Egg\" onclick=\"handleButtonClick(this.id);\">Egg</button></td>
			 <td><button id=\"Cheese\" onclick=\"handleButtonClick(this.id);\">Cheese</button></td>
			 <td><button id=\"Onion\" onclick=\"handleButtonClick(this.id);\">Onion</button></td>
			 <td><button id=\"Ham\" onclick=\"handleButtonClick(this.id);\">Ham</button></td>
			 <td><button id=\"Spinach\" onclick=\"handleButtonClick(this.id);\">Spinach</button></td>
                         <td><button id=\"Garlic\" onclick=\"handleButtonClick(this.id);\">Garlic</button></td>
		 </tr>
		 <tr>
			 <td><button id=\"BellPepper\" onclick=\"handleButtonClick(this.id);\">Bell Pepper</button></td>
			 <td><button id=\"Bread\" onclick=\"handleButtonClick(this.id);\">Bread</button></td>
			 <td><button id=\"PeanutButter\" onclick=\"handleButtonClick(this.id);\">Peanut Butter</button></td>
			 <td><button id=\"Jelly\" onclick=\"handleButtonClick(this.id);\">Jelly</button></td>
			 <td><button id=\"Carrots\" onclick=\"handleButtonClick(this.id);\">Carrots</button></td>
                         <td><button id=\"Lettuce\" onclick=\"handleButtonClick(this.id);\">Lettuce</button></td>
		 </tr>
		 <tr>
			 <td><button id=\"Tofu\" onclick=\"handleButtonClick(this.id);\">Tofu</button></td>
                         <td><button id=\"Broccoli\" onclick=\"handleButtonClick(this.id);\">Broccoli</button></td>
                         <td><button id=\"SoySauce\" onclick=\"handleButtonClick(this.id);\">Soy Sauce</button></td>
                         <td><button id=\"Rice\" onclick=\"handleButtonClick(this.id);\">Rice</button></td>
			 <td><button id=\"Tomato\" onclick=\"handleButtonClick(this.id);\">Tomato</button></td>
                         <td><button id=\"Ranch\" onclick=\"handleButtonClick(this.id);\">Ranch</button></td>
		 </tr>
		 <tr>
			 <td><button id=\"Chicken\" onclick=\"handleButtonClick(this.id);\">Chicken</button></td>
                         <td><button id=\"Pasta\" onclick=\"handleButtonClick(this.id);\">Pasta</button></td>
                         <td><button id=\"TomatoSauce\" onclick=\"handleButtonClick(this.id);\">Tomato Sauce</button></td>
                         <td><button id=\"Tortilla\" onclick=\"handleButtonClick(this.id);\">Tortilla</button></td>
			 <td><button id=\"Beef\" onclick=\"handleButtonClick(this.id);\">Beef</button></td>
                         <td><button id=\"Lemon\" onclick=\"handleButtonClick(this.id);\">Lemon</button></td>
		 </tr>
		 <tr>
		 	 <td><button id=\"Butter\" onclick=\"handleButtonClick(this.id);\">Butter</button></td>
                         <td><button id=\"Sugar\" onclick=\"handleButtonClick(this.id);\">Sugar</button></td>
                         <td><button id=\"Flour\" onclick=\"handleButtonClick(this.id);\">Flour</button></td>
                         <td><button id=\"Chocolate\" onclick=\"handleButtonClick(this.id);\">Chocolate</button></td>
			 <td><button id=\"Jelly\" onclick=\"handleButtonClick(this.id);\">Jelly</button></td>
			 <td><button id=\"Salt\" onclick=\"handleButtonClick(this.id);\">Salt</button></td>
		 </tr>
	</table>
	<br>
	<textarea disabled id=\"textarea\" rows=\"10\" cols=\"40\"></textarea>
	<br>
	<button id=\"Submit\" onclick=\"handleButtonClick(this.id);\">Submit</button>
 </body>
</html>"

java runProgram $QUERY_STRING