package rovertestsutils;

import mars.Rover;

public class utils {
    public static Direction getDirection(String dir) {
        Direction direction;
        switch (dir){
            case "N":
                direction = utils.Direction.N;
                break;
            case "E":
                direction = utils.Direction.E;
                break;
            case "S":
                direction = utils.Direction.S;
                break;
            case "W":
                direction = utils.Direction.W;
                break;
            default :
                direction = utils.Direction.INVALID;
        }
        return direction;
    }

    public static Direction getDirectionFromCode(Integer code) {
        Direction direction;
        switch (code){
            case 1:
                direction = utils.Direction.N;
                break;
            case 2:
                direction = utils.Direction.E;
                break;
            case 3:
                direction = utils.Direction.S;
                break;
            case 4:
                direction = utils.Direction.W;
                break;
            default :
                direction = utils.Direction.INVALID;
        }
        return direction;
    }

    public enum Direction {
        N(1),  //calls constructor with value 1
        E(2),  //calls constructor with value 2
        S(3),  //calls constructor with value 3
        W(4),   //calls constructor with value 4
        INVALID(5)
        ;
        public final int levelCode;

        Direction(int levelCode) {
            this.levelCode = levelCode;
        }

        public int getLevelCode() {
            return this.levelCode;
        }

    }



}
