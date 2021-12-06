package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import executor.Level;
import executor.Location;
import executor.animal.Pig;

class LevelTest {

	Location location = new Location();
	Pig pig = new Pig(location, 0, false, true);
	Level level = new Level("", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

	// Testing level objective
	@Test
	@DisplayName("Level Objective Test")
	void levelObjectiveTest() {
		level.addAnimal(pig);
		level.addLocation(location);
		assertEquals(true, level.levelTwoObjective(), "Test whether a level sees its objective as being completed.");
	}

}
