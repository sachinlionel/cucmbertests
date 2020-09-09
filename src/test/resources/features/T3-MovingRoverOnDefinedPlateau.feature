Feature: Test initialize and move MarsRover on the mars plateau

  @SmokeTest
  Scenario Outline: Test rover moving inside plateau
    Given A plateau of <dimention_of_plateau> square dimension
    When A rover intialized as given  <rover_x_coordinate> x_cordinate, and <rover_y_coordinate> y_cordinate, in direction "<rover_intila_direction>"
    And Executed rover commands "<rover_commands>"
    Then verify final postion <final_rover_x_coordinate>, <final_rover_y_coordinate>, "<final_rover_direction>"
    Examples:
      | dimention_of_plateau | rover_x_coordinate | rover_y_coordinate | rover_intila_direction | rover_commands        | final_rover_x_coordinate | final_rover_y_coordinate | final_rover_direction |
      | 5                    | 1                  | 2                  | N                      | LMLMLMLMM             | 1                        | 3                        | N                     |
      | 10                   | 4                  | 2                  | W                      | LMLMLMLMM             | 3                        | 2                        | W                     |
      | 100                  | 99                 | 99                 | S                      | MMMMMM                | 99                       | 93                       | S                     |
      | 100                  | 54                 | 80                 | N                      | LMLMLMMMMRMMLMMRLLMMR | 59                       | 79                       | E                     |
      | 5                    | 1                  | 2                  | N                      | LMLMLMLMM             | 1                        | 3                        | N                     |
