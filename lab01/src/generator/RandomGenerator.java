package src.generator;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    int rand;

    // simple getter
    public int getRand(){
        return rand;
    }

    // simple setter
    public void setRand(int rand){
        this.rand = rand;
    }

    // generates a random number from 0 to a determinated maximum
    // determined inclusive
    public int generateRand(int max){
        Random r = new Random();
        this.rand = r.nextInt(max+1);
        return this.rand;
    }

    // gets a random integer from an array of them
    public int getRandomNumbFromList(List<Integer> numberList){
        int size = numberList.size();
        int rand = generateRand(size-1);
        return numberList.get(rand);
    }

    // returns a random char from a determined String
    private char getRandomCharFromString(String s){
        int size = s.length();
        int rand = generateRand(size-1);
        return s.charAt(rand);
    }

    // genereates a random char from the alphabet
    public char generateRandomChar(){
        String allAlpha = "QWERTYUIOPASDFGHJKLZXCVBNM";
        return getRandomCharFromString(allAlpha);
    }
}
