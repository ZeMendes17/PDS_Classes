
// import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import startypes.StarType;
import startypes.*;

public class StarFlyweightFactory {
    static int CANVAS_SIZE = 1200;
    private static Map<Character, StarType> flyweights = new HashMap<>();;

    // public StarFlyweightFactory() {
    //     flyweights = new HashMap<>();
    // }

    
    public static Star createStar(char type) {
        int x = random(0, CANVAS_SIZE);
        int y = random(0, CANVAS_SIZE);

        StarType star = flyweights.get(type);

        if(star == null){
            switch (type) {
                case 'O' : star = new OStar(); break;
                case 'A' : star = new AStar(); break;
                case 'B' : star = new BStar(); break;
                case 'F' : star = new FStar(); break;
                case 'G' : star = new GStar(); break;
                case 'K' : star = new KStar(); break;
                case 'M' : star = new MStar(); break;
                }
                flyweights.put(type, star);
        }

        return new Star(star, x, y);
    }

	private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
