run: compile
	
	

compile:
	
	javac -source 1.7 -target 1.7 -cp . BackEndDev.java
	javac -source 1.7 -target 1.7 -cp . HashTableMap.java
	javac -source 1.7 -target 1.7 -cp . KeyValue.java
	javac -source 1.7 -target 1.7 -cp . MapADT.java
	javac -source 1.7 -target 1.7 -cp . Recipe.java
	javac -source 1.7 -target 1.7 -cp . RecipeHashTable.java
	javac -source 1.7 -target 1.7 -cp . runProgram.java
	javac -source 1.7 -target 1.7 -cp . result.java
test: compile
	    javac -cp .:junit5.jar ProjectFourTestSuite.java
	    java -jar junit5.jar -cp . --scan-classpath -n ProjectFourTestSuite

clean:
	$(RM) *.class
