package T1.src.generator;

//  Simple class to be used as a variable type to avoid using 2D arrays elsewhere
public class SoupIndex {
    int valueX;
    int valueY;

    SoupIndex(int vX, int vY) {
        this.valueX = vX;
        this.valueY = vY;
    }

    public Integer getX() {
        return this.valueX;
    }

    public Integer getY() {
        return this.valueY;
    }
}
