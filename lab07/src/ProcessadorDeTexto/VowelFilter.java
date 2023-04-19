package src.ProcessadorDeTexto;

class VowelFilter extends TextFilter {

    // constructor
    public VowelFilter(ReaderInterface textReader) {
        super(textReader);
    }

    public String next() {
        // Replace all vowels with an empty string
        String paragraph = super.next();
        paragraph = paragraph.replaceAll("[aeiouAEIOU]+", "");
        return paragraph;
    }
}
