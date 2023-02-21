import java.util.List;
import java.util.Random;

public class RandomGenerator {
    // it will generate the position of the first letter
    // also
    // we have 8 possible directions, it will generate a number between 1 and 8 inclusive
    // and identify the direction
    int rand;

    public int getRand(){
        return rand;
    }

    public void setRand(int rand){
        this.rand = rand;
    }

    public int generateRand(int max){
        Random r = new Random();
        this.rand = r.nextInt(max+1);
        return this.rand;
    }

    public int getRandomNumbFromList(List<Integer> numberList){
        int size = numberList.size();
        int rand = generateRand(size-1);
        return numberList.get(rand);
    }

    private char getRandomCharFromString(String s){
        int size = s.length();
        int rand = generateRand(size-1);
        return s.charAt(rand);
    }

    public char generateRandomChar(){
        String allAlpha = "QWERTYUIOPASDFGHJKLZXCVBNM";
        return getRandomCharFromString(allAlpha);
    }
}
