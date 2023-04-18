package src.ProcessadorDeTexto;

import java.util.regex.Pattern;

public class TermFilter extends TextFilter {
    private Pattern pattern;
    ReaderInterface textReader;

    // constructor
    public TermFilter(ReaderInterface textReader) {
        super(textReader);
        pattern = Pattern.compile("\\W+");
    }

    // interface methods
    @Override
    public boolean hasNext() {
        return textReader.hasNext();
    }

    @Override
    public String next() {
        // Separate words with a single space
        String paragraph = textReader.next();
        return pattern.matcher(paragraph).replaceAll(" ");
    }
}