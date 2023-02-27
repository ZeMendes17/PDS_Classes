package src.solver;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    char[][] wordSearch;
    List<String> words;

    public Solution(char[][] wordSearch, List<String> words){
        this.wordSearch = wordSearch;
        this.words = words;
    }

    // getters
    public char[][] getWordSearch(){
        return wordSearch;
    }
    public List<String> getWords(){
        return words;
    }

    //setters
    public void setWordSearch(char[][] wordSearch){
        this.wordSearch = wordSearch;
    }
    public void setWords(List<String> words){
        this.words = words;
    }

    public List<Word> solve(char[][] wordSearch, List<String> words){

        List<Word> result = new ArrayList<>();

        List<Word> right = rightWords(wordSearch);
        for(Word w : right)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);

        List<Word> left = leftWords(wordSearch);
        for(Word w : left)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);

        List<Word> up = upWords(wordSearch);
        for(Word w : up)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);

        List<Word> down = downWords(wordSearch);
        for(Word w : down)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);

        List<Word> upLeft = upLeftWords(wordSearch);
        for(Word w : upLeft)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);                    

        List<Word> upRight = upRightWords(wordSearch);
        for(Word w : upRight)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);     
                    
        List<Word> downLeft = downLeftWords(wordSearch);
        for(Word w : downLeft)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);                    

        List<Word> downRight = downRightWords(wordSearch);
        for(Word w : downRight)
            for(String s : words)
                if(w.getWord().equals(s))
                    result.add(w);  
                    
        // now at last we need to see only validate, for example, FARO and FAROL, on same pos only FAROL is the solution
        List<Word> removeWords = new ArrayList<>();
        for(Word w : result){
            for(Word ww : result){
                int wRow = w.getX();
                int wwRow = ww.getX();
                int wCol = w.getY();
                int wwCol = ww.getY();
                
                if(wRow == wwRow && wCol == wwCol && w.getWord().contains(ww.getWord()) && !w.getWord().equals(ww.getWord())){
                    removeWords.add(ww);
                }
            }
        }

        for(Word w : removeWords)
            result.remove(w);
            
        return result;
    }

    public List<Word> rightWords(char[][] wordSearch){
        int row, inicial, last;
        int size = wordSearch.length;
        Word word;
        List<Word> words = new ArrayList<>();
        Directions direction = Directions.Right;

        for(row = 0; row < size; row++){
            String rowString = new String(wordSearch[row]);

            for(inicial = 0; inicial < size - 2; inicial++){
                for(last = inicial+3; last <= size; last++){
                    String tempWord = rowString.substring(inicial, last);
                    word = new Word(tempWord, tempWord.length(), row, inicial, direction);
                    words.add(word);
                }
            }
        }
        return words;
    }

    public List<Word> leftWords(char[][] wordSearch){
        int row, inicial, last;
        int size = wordSearch.length;
        Word word;
        List<Word> words = new ArrayList<>();
        Directions direction = Directions.Left;

        for(row = 0; row < size; row++){
            String rowString = new String(wordSearch[row]);

            for(inicial = 0; inicial < size - 2; inicial++){
                for(last = inicial+3; last <= size; last++){
                    String tempWord = rowString.substring(inicial, last);
                    String addWord = new StringBuilder(tempWord).reverse().toString();
                    word = new Word(addWord, tempWord.length(), row, last-1, direction);
                    words.add(word);
                }
            }
        }
        return words;
    }
    
    public List<Word> downWords(char[][] wordSearch){
        int col, inicial, last;
        int size = wordSearch.length;
        Word word;
        List<Word> words = new ArrayList<>();
        Directions direction = Directions.Down;
        StringBuilder colSB = new StringBuilder();

        for(col = 0; col < size; col++){
            for(char[] tempCharArr : wordSearch)
                colSB.append(tempCharArr[col]);
            String colString = colSB.toString();
            colSB = new StringBuilder();

            for(inicial = 0; inicial < size - 2; inicial++){
                for(last = inicial+3; last <= size; last++){
                    String tempWord = colString.substring(inicial, last);
                    word = new Word(tempWord, tempWord.length(), inicial, col, direction);
                    words.add(word);
                }
            }
        }
        return words;
    }

    public List<Word> upWords(char[][] wordSearch){
        int col, inicial, last;
        int size = wordSearch.length;
        Word word;
        List<Word> words = new ArrayList<>();
        Directions direction = Directions.Up;
        StringBuilder colSB = new StringBuilder();

        for(col = 0; col < size; col++){
            for(char[] tempCharArr : wordSearch)
                colSB.append(tempCharArr[col]);
            String colString = colSB.reverse().toString();
            colSB = new StringBuilder();

            for(inicial = 0; inicial < size - 2; inicial++){
                for(last = inicial+3; last <= size; last++){
                    String tempWord = colString.substring(inicial, last);
                    word = new Word(tempWord, tempWord.length(), size-1-inicial, col, direction);
                    words.add(word);
                }
            }
        }
        return words;
    }

    public List<Word> upLeftWords(char[][] wordSearch){
        int row, nextRow, col, nextCol;
        int size = wordSearch.length;
        StringBuilder tempWord = new StringBuilder();
        String str;
        Word word;
        Directions direction = Directions.UpLeft;
        List<Word> words = new ArrayList<>();

        for(row = size-1; row >= 2; row--){
            for(col = size-1; col >= 2; col--){
                tempWord.append(wordSearch[row][col]);
                nextRow = row-1;
                nextCol = col-1;
                while(nextRow >= 0 && nextCol >= 0){
                    tempWord.append(wordSearch[nextRow][nextCol]);
                    nextRow--;
                    nextCol--;

                    str = tempWord.toString();
                    if(str.length() >= 3){
                        word = new Word(str, str.length(), row, col, direction);
                        words.add(word);
                    }
                }
                tempWord = new StringBuilder();
            }
        }
        return words;
    }

    public List<Word> upRightWords(char[][] wordSearch){
        int row, nextRow, col, nextCol;
        int size = wordSearch.length;
        StringBuilder tempWord = new StringBuilder();
        String str;
        Word word;
        Directions direction = Directions.UpRight;
        List<Word> words = new ArrayList<>();

        for(row = size-1; row >= 2; row--){
            for(col = 0; col < size; col++){
                tempWord.append(wordSearch[row][col]);
                nextRow = row-1;
                nextCol = col+1;
                while(nextRow >= 0 && nextCol < size){
                    tempWord.append(wordSearch[nextRow][nextCol]);
                    nextRow--;
                    nextCol++;

                    str = tempWord.toString();
                    if(str.length() >= 3){
                        word = new Word(str, str.length(), row, col, direction);
                        words.add(word);
                    }
                }
                tempWord = new StringBuilder();
            }
        }
        return words;
    }

    public List<Word> downLeftWords(char[][] wordSearch){
        int row, nextRow, col, nextCol;
        int size = wordSearch.length;
        StringBuilder tempWord = new StringBuilder();
        String str;
        Word word;
        Directions direction = Directions.DownLeft;
        List<Word> words = new ArrayList<>();

        for(row = 0; row < size; row++){
            for(col = size-1; col >= 2; col--){
                tempWord.append(wordSearch[row][col]);
                nextRow = row+1;
                nextCol = col-1;
                while(nextRow < size && nextCol >= 0){
                    tempWord.append(wordSearch[nextRow][nextCol]);
                    nextRow++;
                    nextCol--;

                    str = tempWord.toString();
                    if(str.length() >= 3){
                        word = new Word(str, str.length(), row, col, direction);
                        words.add(word);
                    }
                }
                tempWord = new StringBuilder();
            }
        }
        return words;
    }

    public List<Word> downRightWords(char[][] wordSearch){
        // first starting with the cols
        int row, nextRow, col, nextCol;
        int size = wordSearch.length;
        StringBuilder tempWord = new StringBuilder();
        String str;
        Word word;
        Directions direction = Directions.DownRight;
        List<Word> words = new ArrayList<>();

        for(row = 0; row < size; row++){
            for(col = 0; col < size; col++){
                tempWord.append(wordSearch[row][col]);
                nextRow = row+1;
                nextCol = col+1;
                while(nextRow < size && nextCol < size){
                    tempWord.append(wordSearch[nextRow][nextCol]);
                    nextRow++;
                    nextCol++;

                    str = tempWord.toString();
                    if(str.length() >= 3){
                        word = new Word(str, str.length(), row, col, direction);
                        words.add(word);
                    }
                }
                tempWord = new StringBuilder();
            }
        }
        return words;
    }
}