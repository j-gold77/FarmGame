# FarmGame
A game simulating a farm environment which accepts English input from the user
and translates it into method calls that execute actions in the in-game farm.
Made for COMP354 - Section E - Group G
--------------------------------------------------------------------------------------------
Purpose:
To teach young kids how to program in an object-oriented environment.
The usage of Java will help relate object-oriented concepts to the end user
through our coding simulation. Most of the architecture in our program is based
on the basics of OOP principles, the ones the user is intended to learn, such
as list manipulation and conditional logic.
--------------------------------------------------------------------------------------------
Dependencies:
This program is requires Java Runtime Environment 13.0.2 
Jupiter JUnit 5 is the testing framework.
Eclipse IDE was used to write the code, compile, and execute it.
--------------------------------------------------------------------------------------------
Instructions:
To run this program, execute the provided executable jar file called
"FarmGame.jar": Open CMD, command prompt terminal, and write "java -jar ABSOLUTEFILEPATH",
where ABSOLUTEFILEPATH is the absolute file path location of the file, ending with FarmGame.jar

If the above does not work, use an IDE such as Eclipse and create a new project in the
directory called "FarmGame". Then run the Driver.java file found in FarmGame/src/executor/driver.java

The test cases can also be executed through an IDE such as Eclipse, all the files that
relate to testing can be found in the FarmGame/src/test folder.

If none of the above works, sample execution of each level is provided in .txt files,
found in the Sample Output folder.
Most of the game functionality and programming principles are demonstrated and tested
in the levels found in the sample output.
--------------------------------------------------------------------------------------------
File Structure:
All the source code is found inside "FarmGame/src"
The main components of the program are seperated into their own Java packages, mainly:
Display, Interpreter, Executor:

Display:
The Displayable folder contains parts of the software responsible for for displaying any outputs of the prgram to the user. The Display java file includes code to display status to the user on different components on the farm, such as farmers, locations and animals. The Displayble java file acts as an interface for the displayable folder. The TEaching java file displays instructions on how to successfully run and complete the level chosen by the user, making this software a fun educatonal tool for the user.

Interpreter:
The Interpreter folder contains parts of the software responsible for translating the user's input into commands that the software can understand and process. The Feedback java file instantiates a Feedback message to determine if the user's input was successful and the Interpreter java file processes the user's input, which is taken as a string, and makes comparisons with specific conditions to determine which command to execute and if the user's input is a valid sentence.

Executor:
The Executor folder contains contains parts of the software responsible for executing the software's main functionality. It includes all the main classes related to the FarmGame software program, and a level system is also implemented into the design. The Animal folder contains the Animal class along with its subclasses Chicken, Cow and Pig. These classes are used to instantiate the animals living on the generated farm. The Farmer java file instantiates the farmers on the generated farm and is responsible for calling various methods that have different effects on animals, whether to move them from one location to another, feed them etc. The Location java file instantiates different locations on the generated farm, all holding a maximum capacity for farmers and animals. The software allows movement between various locations. The Level java file instantiates the level chosen by the user, generating the premise, farmers, animals, and locations assoiated to the level chosen. Finally, the Driver functions as the primary driver for running the software, letting the user pick and choose a level they would like to play and enter commands based on the level that they have chosen.


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
