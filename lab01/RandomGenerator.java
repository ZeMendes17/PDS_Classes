import java.util.Random;

public class RandomGenerator {
    // it will generate the position of the first letter
    // also
    // we have 8 possible directions, it will generate a number between 1 and 8 inclusive
    // and identify the direction
    int x, y;
    Directions direction;

    public RandomGenerator(int x, int y){
        this.x = x;
        this.y = y;
    }
    public RandomGenerator(Directions direction){
        this.direction = direction;
    }

    // getters
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Directions getDirection(){
        return direction;
    }

    //setters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDirection(Directions direction){
        this.direction = direction;
    }

    private int RandomNumber(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

}
