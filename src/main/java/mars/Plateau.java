package mars;

public class Plateau {
    Integer x;
    Integer y;

    public Plateau(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public boolean CordinateswithInPlateau(Integer x, Integer y) {
        return (x <= this.x && y <= this.y && x >= 0 && y >= 0) ? true : false;
    }
}
