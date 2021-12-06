package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import executor.Location;
import executor.Farmer;
import executor.Level;
import executor.animal.Animal;
import executor.animal.Cow;
import executor.animal.Pig;
import interpreter.Interpreter;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The type Interpreter test.
 */
class InterpreterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    ArrayList<Location> locations = new ArrayList<Location>();
    ArrayList<Farmer> farmers = new ArrayList<Farmer>();
    ArrayList<Animal> animals = new ArrayList<Animal>();

    /**
     * Sets up before class.
     *
     * @throws Exception the exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    /**
     * Tear down.
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        locations.clear();
        farmers.clear();
        animals.clear();
    }

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Test input length.
     */
    @Test
    @DisplayName("Testing sentence minimum length of 3 ")
    void testInputLength() {
        String sentence = "Paul milks";
        Level level = new Level(sentence, locations, farmers, animals);
        Interpreter.interpretSentence(sentence,level);

        assertEquals("Invalid Sentence: Sentences must be at least 3 words long!", outputStreamCaptor.toString().trim());

    }

    /**
     * Validate farmer name.
     */
    @Test
    @DisplayName("Second part of sentence must contain farmer that exists")
    void validateFarmerName() {
        Location farm = new Location("Farm");
        Farmer mike = new Farmer("Mike", farm);
        Pig pig = new Pig();
        String sentence = "Farmer Paul cleans the pig";
        Level level = new Level(sentence, locations, farmers, animals);
        level.addFarmer(mike);
        Interpreter.interpretSentence(sentence,level);

        assertEquals("Invalid Sentence: The second part of the sentence must be the name of a farmer that exists!", outputStreamCaptor.toString().trim());

    }

    /**
     * Validate animal name.
     */
    @Test
    @DisplayName("Third part should contain an animal that we created")
    void validateAnimalName() {
        Location farm = new Location("Farm");
        Farmer jake = new Farmer("Jake", farm);
        Cow cow = new Cow();
        String sentence = "Farmer Jake eats";
        Level level = new Level(sentence, locations, farmers, animals);
        level.addLocation(farm);
        level.addFarmer(jake);
        level.addAnimal(cow);
        Interpreter.interpretSentence(sentence,level);

        assertEquals("Invalid Sentence: The third part of the sentence must be an action (moves, speaks, nurses, feeds, cleans, milks)!", outputStreamCaptor.toString().trim());

    }

    /**
     * Integration farmer move same place.
     */
    @Test
    @DisplayName("Farmer should not be able to move to the place where the farmer is already at")
    void IntegrationFarmerMoveSamePlace() {

        Location farm = new Location("Farm");
        Location house = new Location("House");
        Farmer chris = new Farmer("Chris", farm);
        String sentence = "Farmer Chris moves to the farm";
        Level level = new Level(sentence, locations, farmers, animals);
        level.addLocation(house);
        level.addLocation(farm);
        level.addFarmer(chris);
        Interpreter.interpretSentence(sentence,level);
        assertEquals("Source and Target locations are the same, farmer cannot move!", outputStreamCaptor.toString().trim());
    }

    /**
     * Integration farmer move.
     */
    @Test
    @DisplayName("Farmer should be able to move somewhere")
    void IntegrationFarmerMove() {

        ArrayList<Location> locations = new ArrayList<Location>();
        ArrayList<Farmer> farmers1 = new ArrayList<Farmer>();
        ArrayList<Animal> animals2 = new ArrayList<Animal>();

        Location farm = new Location("Farm", 0, farmers, animals);
        Location house = new Location("House", 1, farmers1, animals2);
        Farmer chris = new Farmer("Chris", farm);
        farmers.add(chris);
        house.addFarmer(chris);
        String sentence = "Farmer Chris moves to the House";
        locations.add(farm);
        locations.add(house);
        Level level = new Level(sentence, locations, farmers, animals);
        level.addLocation(house);
        level.addLocation(farm);
        level.addFarmer(chris);
        Interpreter.interpretSentence(sentence,level);
        assertEquals("House", chris.getLocation().getName());
    }

}