# COMP-354-A1
A game simulating a farm environment which accepts English input from the user
and translates it into method calls that execute actions in the in-game farm.
--------------------------------------------------------------------------------------------
Purpose:
To teach young kids how to program in an object-oriented environment.
The usage of Java will help relate object-oriented concepts to the end user
through our coding simulation. Most of the architecture in our program is based
on the basics of OOP principles, the ones the user is intended to learn, such
as polymorphism, list manipulation, and conditional logic.
--------------------------------------------------------------------------------------------
Dependencies:
This program is written in Java.
Jupiter JUnit 5 is the testing framework.
Eclipse IDE was used to write the code, compile, and execute it.
--------------------------------------------------------------------------------------------
Instructions:
To run this program, execute the provided executable jar file called "FarmGame.jar".
If the above does not work, use an IDE such as Eclipse and create a new project in the
directory called "FarmGame".
The test cases can also be executed through an IDE such as Eclipse, all the files that
relate to testing can be found in the FarmGame/src/test folder.
If none of the above works, sample execution of each level is provided in .txt files.
--------------------------------------------------------------------------------------------
File Structure:
All the source code is found inside "FarmGame/src"
The main components of the program are seperated into their own Java packages, mainly:
Display, Interpreter, Executor:

Display:
...
Interpreter:
...
Executor:
...

The Driver.java file is where the main function is, and where the level selection happens.
The sample output can be found in the Sample Output folder.
--------------------------------------------------------------------------------------------
Testing:
The JUnit tests are in the FarmGame/src/test folder, they include the test cases.
There are 3 main tests: CowTest, InterpreterTest, LevelTest:

CowTest:
CowTest involves tests relating to unit testing and testing animal functions.

LevelTest:
Final step of executor testing, by this point all executor objects have been tested,
and whether they result in a completed level is being tested.

InterpreterTest:
Involves most integration tests, as the interpreter is a wrapper that functions around
the executor component. Tests things such as validation of English input and
validation of functions with the in-game state.
--------------------------------------------------------------------------------------------