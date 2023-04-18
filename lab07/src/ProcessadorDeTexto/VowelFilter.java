package src.ProcessadorDeTexto;

import java.util.regex.Pattern;

class VowelFilter extends TextFilter {
    private Pattern pattern;
    ReaderInterface textReader;

    // constructor
    public VowelFilter(ReaderInterface textReader) {
        super(textReader);
        pattern = Pattern.compile("[aeiouAEIOU]");
    }

    // interface methods
    @Override
    public boolean hasNext() {
        return textReader.hasNext();
    }

    @Override
    public String next() {
        // Replace all vowels with an empty string
        String paragraph = textReader.next();
        return pattern.matcher(paragraph).replaceAll("");
    }
}
