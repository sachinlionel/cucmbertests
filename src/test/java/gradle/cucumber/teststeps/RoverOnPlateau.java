package gradle.cucumber.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mars.Plateau;
import mars.Rover;
import org.junit.Assert;
import rovertestsutils.utils;


public class RoverOnPlateau {

    Rover testRover;
    Plateau testPlateau;
    utils.Direction direction;

    @Given("Create a rectangular plateau {int}*{int}")
    public void create_A_Rectangular_Plateau_On_Mars(int x, int y) {
        // Create a rover
        this.testPlateau = new Plateau(x, y);
    }

    @Given("A Rover")
    public void a_Rover() {
        this.testRover = new Rover();
    }

    @When("Intitialize Rover with {int} x_cordinate, and {int} y_cordinate, in direction {string}")
    public void intitialize_Rover_with_x_cordinate_with_y_cordinate_in_direction(Integer x, Integer y, String z) {
        // Create Rover and intialize cordinates and direction

        direction = utils.getDirection(z);
        if (!(direction == utils.Direction.INVALID)) {
            Integer directionCode = direction.getLevelCode();
            this.testRover.setPosition(x, y, directionCode);
        }

    }

    @Then("Expect positon to be in plateau {string}")
    public void expect_positon_to_be_in_plateau(String state){
        // Validate the position to be in plateau
        if (!(direction == utils.Direction.INVALID)) {
            Assert.assertEquals(Boolean.parseBoolean(state), testPlateau.CordinateswithInPlateau(testRover.getX(), testRover.getY()));
        }
    }

    @Then("Verfiy coordinates and direction, x = {int}, y = {int}, dir = {string}")
    public void verfiy_coordinates_and_direction_x_y_dir(Integer expectedX, Integer expectedY, String expectedDirection) {
        if (!(direction == utils.Direction.INVALID)) {
            // Verify X coordinate of rover
            Assert.assertEquals(expectedX, testRover.getX());
            // Verify Y coordinate of rover
            Assert.assertEquals(expectedY, testRover.getY());
            // Verify Direction of rover
            Integer actualDirectionCode = testRover.getDirection();
            utils.Direction actualDirection = utils.getDirectionFromCode(actualDirectionCode);
            Assert.assertEquals(expectedDirection, actualDirection.toString());
        }
    }
}
