package gradle.cucumber.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mars.Plateau;
import mars.Rover;
import org.junit.Assert;
import rovertestsutils.utils;

public class MovingRoverOnDefinedPlateau {

    Rover testRover;
    Plateau testPlateau;
    utils.Direction direction;

    @Given("A plateau of {int} square dimension")
    public void a_plateau_of_square_dimension(Integer x) {
        // Create a rover
        this.testPlateau = new Plateau(x, x);

    }

    @When("A rover intialized as given  {int} x_cordinate, and {int} y_cordinate, in direction {string}")
    public void a_rover_intialized_as_given_x_cordinate_and_y_cordinate_in_direction(Integer x, Integer y, String z) {
        testRover = new Rover();
        direction = utils.getDirection(z);
        Integer directionCode = direction.getLevelCode();
        testRover.setPosition(x, y, directionCode);
    }

    @When("Executed rover commands {string}")
    public void executed_rover_commands(String cmds) {
        testRover.process(cmds);
    }

    @Then("verify final postion {int}, {int}, {string}")
    public void verify_final_postion(Integer expectedX, Integer expectedY, String expectedDirection) {
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
