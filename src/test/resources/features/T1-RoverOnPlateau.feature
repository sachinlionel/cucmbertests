Feature: Test MarsRover facing and positioning initialisation on a mars rectangular plateau

  Background: Create a rectangular plateau on mars
    Given Create a rectangular plateau 5*5

  Scenario Outline: test for Rover direction facing and positioning initialisation are in within plateau
    Given A Rover
    When Intitialize Rover with <rover_x_coordinate> x_cordinate, and <rover_y_coordinate> y_cordinate, in direction "<rover_initial_direction>"
    Then Expect positon to be in plateau "<rover_position_is_in_plateau>"
    And Verfiy coordinates and direction, x = <rover_x_coordinate>, y = <rover_y_coordinate>, dir = "<rover_initial_direction>"
    Examples:
      | rover_x_coordinate | rover_y_coordinate | rover_initial_direction | rover_position_is_in_plateau |
      | 0                  | 0                  | N                       | true                         |
      | 1                  | 2                  | E                       | true                         |
      | 5                  | 5                  | S                       | true                         |
      | 6                  | 5                  | W                       | false                        |
      | -1                 | -1                 | B                       |                              |
      | -1                 | 0                 | N                       |                              |

