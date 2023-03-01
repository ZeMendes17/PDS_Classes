package src.solver;
import java.util.List;

// class used to print the found words in the WS
public class PrintWS {
    List<Word> words;
    char[][] wordSearch;

    // contructor
    public PrintWS(List<Word> words, char[][] wordSearch){
        this.words = words;
        this.wordSearch = wordSearch;
    }

    //getters
    public List<Word> getWords(){
        return words;
    }

    public char[][] getWordSearch(){
        return wordSearch;
    }

    //setters
    public void setWords(List<Word> words){
        this.words = words;
    }

    public void setWordSearch(char[][] wordSearch){
        this.wordSearch = wordSearch;
    }

    // display WS into the terminal
    public void print(){
        int size = wordSearch.length;
        char[][] result = new char[size][size];
        // fills all the positions with '.'
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                result[i][j] = '.';

        // for the words in this list it will insert them in the correct position
        for(Word w : words){
            System.out.println(w);

            // get the coordinates, size and direction of that word
            int row = w.getX();
            int col = w.getY();
            int wordSize = w.getSize();
            Directions direction = w.getDirection();

            // inserts them in the WS
            for(int i = 0; i < wordSize; i++){
                result[row][col] = wordSearch[row][col];
                if(direction.equals(Directions.Up)){
                    row--;
                }else if(direction.equals(Directions.Down)){
                    row++;
                }else if(direction.equals(Directions.Right)){
                    col++;
                }else if(direction.equals(Directions.Left)){
                    col--;
                }else if(direction.equals(Directions.UpRight)){
                    row--;
                    col++;
                }else if(direction.equals(Directions.UpLeft)){
                    row--;
                    col--;
                }else if(direction.equals(Directions.DownLeft)){
                    row++;
                    col--;
                }else if(direction.equals(Directions.DownRight)){
                    row++;
                    col++;
                }
            }
        }
        // prints out the WS alredy filled
        System.out.println();
        for(char[] c : result){
            for(char cc : c)
                System.out.print(cc + " ");
            System.out.println();
        }
    }
}
