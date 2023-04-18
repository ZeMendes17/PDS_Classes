package src.ProcessadorDeTexto;

import java.util.regex.Pattern;

class NormalizationFilter extends TextFilter {
    private Pattern pattern;
    ReaderInterface textReader;

    // constructor
    public NormalizationFilter(ReaderInterface textReader) {
        super(textReader);
        pattern = Pattern.compile("[^\\p{ASCII}]+");
    }

    // interface methods
    @Override
    public boolean hasNext() {
        return textReader.hasNext();
    }

    @Override
    public String next() {
        // Remove all accents from the text
        String paragraph = textReader.next();
        return pattern.matcher(paragraph).replaceAll("");
    }
}
