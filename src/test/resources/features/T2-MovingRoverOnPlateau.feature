Feature: Test moving MarsRover on the mars plateau

  Background: Create a rectangular plateau on mars
    Given Create a rectangular plateau on mars 5*5

  Scenario Outline: Test rover moving inside plateau
    Given A rover intialized at  <rover_x_coordinate> x_cordinate, and <rover_y_coordinate> y_cordinate, in direction "<rover_initial_direction>"
    When Executed commands for moving "<rover_commands>"
    Then verify final postion and direction <final_rover_x_coordinate>, <final_rover_y_coordinate>, "<final_rover_direction>"
    Examples:
      | rover_x_coordinate | rover_y_coordinate | rover_initial_direction | rover_commands | final_rover_x_coordinate | final_rover_y_coordinate | final_rover_direction |
      | 0                  | 0                  | N                       | LRLRM          | 0                        | 1                        | N                     |
      | 3                  | 3                  | E                       | LRLRRMM        | 3                        | 1                        | S                     |
      | 3                  | 5                  | W                       | LRLRRMM        | 3                        | 7                        | N                     |
      | 4                  | 4                  | S                       | LRLRRMRM       | 3                        | 5                        | N                     |

  Scenario Outline: Test rover dirfting of plateau
    Given A rover intialized at  <rover_x_coordinate> x_cordinate, and <rover_y_coordinate> y_cordinate, in direction "<rover_initial_direction>"
    When Executed commands for moving "<rover_commands>"
    Then verify final cordinates are inside plateau, "<cordinates_inside_plateau>"
    Examples: Note: plateau on mars is 5*5
      | rover_x_coordinate | rover_y_coordinate | rover_initial_direction | rover_commands | cordinates_inside_plateau |
      | 0                  | 0                  | N                       | LRLRM          | true                      |
      | 5                  | 5                  | N                       | LRLR           | true                      |
      | 3                  | 3                  | S                       | LLMMMMM        | false                     |
      | 5                  | 5                  | N                       | LRLRM          | false                     |
      | -1                 | -1                 | N                       | LRLRM          | false                     |
      | 5                  | -5                 | E                       | MMMMM          | false                     |

  Scenario Outline: test for Rover commands
    Given A rover intialized at  <rover_x_coordinate> x_cordinate, and <rover_y_coordinate> y_cordinate, in direction "<rover_initial_direction>"
    When Executed commands for moving "<rover_commands>"
    Then Verfiy invalid command execution
    Examples:
      | rover_x_coordinate | rover_y_coordinate | rover_initial_direction | rover_commands |
      | 0                  | 0                  | N                       | LLLLC          |
      | 1                  | 0                  | S                       | RMLLLX         |
      | 0                  | 4                  | N                       | MX             |
      | 5                  | 0                  | N                       | XRR            |
      | 5                  | 0                  | N                       | @_+@           |
      | 5                  | 0                  | N                       | 1290           |
      | 5                  | 0                  | N                       | L R M          |




