package gradle.cucumber.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mars.Plateau;
import mars.Rover;
import org.junit.Assert;
import rovertestsutils.utils;

public class MovingRoverOnPleateau {

    Rover testRover;
    Plateau testPlateau;
    utils.Direction direction;
    String commandException;

    @Given("Create a rectangular plateau on mars {int}*{int}")
    public void create_A_Rectangular_Plateau_On_Mars(int x, int y) {
        // Create a rover
        this.testPlateau = new Plateau(x, y);
    }

    @Given("A rover intialized at  {int} x_cordinate, and {int} y_cordinate, in direction {string}")
    public void a_rover_intialized_at_x_cordinate_and_y_cordinate_in_direction(Integer x, Integer y, String z) {
        testRover = new Rover();
        direction = utils.getDirection(z);
        Integer directionCode = direction.getLevelCode();
        testRover.setPosition(x, y, directionCode);
    }

    @When("Executed commands for moving {string}")
    public void executed_commands_for_moving(String cmds) {
        try {
            testRover.process(cmds);
        } catch (IllegalArgumentException e) {
            this.commandException = e.getMessage();
        }
    }

    @Then("verify final postion and direction {int}, {int}, {string}")
    public void verify_final_postion_and_direction_N(Integer expectedX, Integer expectedY, String expectedDirection) {
        // Verify X coordinate of rover
        Assert.assertEquals(expectedX, testRover.getX());
        // Verify Y coordinate of rover
        Assert.assertEquals(expectedY, testRover.getY());
        // Verify Direction of rover
        Integer actualDirectionCode = testRover.getDirection();
        utils.Direction actualDirection = utils.getDirectionFromCode(actualDirectionCode);
        Assert.assertEquals(expectedDirection, actualDirection.toString());
    }

    @Then("verify final cordinates are inside plateau, {string}")
    public void verify_final_cordinates_are_inside_plateau(String state) {
        Assert.assertEquals(Boolean.parseBoolean(state), testPlateau.CordinateswithInPlateau(testRover.getX(), testRover.getY()));
    }

    @Then("Verfiy invalid command execution")
    public void verfiy_invalid_command_exection() {
        Assert.assertEquals("Speak in Mars language, please!",this.commandException);
    }
}
