package src.ProcessadorDeTexto;

public class TermFilter extends TextFilter {
    private int wordsRead;
    private String[] paragraph = null;

    // constructor
    public TermFilter(ReaderInterface textReader) {
        super(textReader);
        this.wordsRead = 0;
    }

    // interface methods
    public boolean hasNext() {
        if(super.hasNext()){
            return true;
        } else if(paragraph != null && wordsRead < paragraph.length){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String next() {
        // Separate words with a single space
        if(!hasNext()){
            return null;
        }

        if(super.hasNext()){ // first word
            this.paragraph = super.next().split(" ");
            this.wordsRead = 1;
            return paragraph[0];
        } else if (paragraph != null && wordsRead < paragraph.length){ // its not the first word, will return the next
            this.wordsRead++;
            return paragraph[wordsRead-1];
        } else {
            return null;
        }
    }
}