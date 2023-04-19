package src.ProcessadorDeTexto;

import java.text.Normalizer;;

class NormalizationFilter extends TextFilter {

    // constructor
    public NormalizationFilter(ReaderInterface textReader) {
        super(textReader);
    }

    // interface methods
    public String next() {
        // Remove all accents from the text
        String paragraph = super.next();
        paragraph = Normalizer.normalize(paragraph, Normalizer.Form.NFKD);
        paragraph = paragraph.replaceAll("[^\\p{ASCII}]", "");
        paragraph = paragraph.replaceAll("[.!?\\-,]", "");
        return paragraph;
    }
}
