public class Word {
    String word, direction;
    int word_size, x, y;

    public Word(String word, int word_size, int x, int y, String direction){
        this.word = word;
        this.word_size = word_size;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    //getters
    public String getWord(){
        return word;
    }
    public int getSize(){
        return word_size;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getDirection(){
        return direction;
    }

    //setters
    public void setWord(String word){
        this.word = word;
    }
    public void setSize(int size){
        this.word_size = size;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    @Override
	public String toString() {
		return String.format("%s %d %d,%d %s", word, word_size, x, y, direction);
	}
}
