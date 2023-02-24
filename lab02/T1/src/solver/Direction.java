package lab01.src.solver;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//  List of possible Directions of words to use in the Search
public enum Direction {
    RIGHT (1, 0),
    LEFT (-1, 0),
    DOWN (0, -1),
    UP (0, 1),
    UPRIGHT (1, 1),
    DOWNRIGHT (1, -1),
    DOWNLEFT (-1,-1),
    UPLEFT (-1,1);

    public final Integer x;
    public final Integer y;

    
    //  Get the direction "Name" from a Direction (display purposes only)
    public static String getDirection(int xDir, int yDir) {
        if (xDir == 1) {
            if (yDir == 1)      {return "UpRight";}
            else if (yDir == 0) {return "Right";}
            else if (yDir == -1) {return "DownRight";}
        }
        else if (xDir == 0) {
            if (yDir == 1)      {return "Up";}
            else if (yDir == -1) {return "Down";}
        }

        else if (xDir == -1) {
            if (yDir == 1)      {return "UpLeft";}
            else if (yDir == 0) {return "Left";}
            else if (yDir == -1) {return "DownLeft";}
        }

        return "ERRO!";
    }


    public static List<Direction> getDirectionsList()  {
        List<Direction> directionsValues = new ArrayList<>();
        Collections.addAll(directionsValues, Direction.values());

        return directionsValues;
    }

    Direction(Integer x,Integer y) {
        this.x = x;
        this.y = y;
    }
}
