package src.ProcessadorDeTexto;

class CapitalizationFilter extends TextFilter {
    ReaderInterface textReader;

    // constructor
    public CapitalizationFilter(ReaderInterface textReader) {
        super(textReader);
    }

    // interface methods

    @Override
    public boolean hasNext() {
        return textReader.hasNext();
    }

    @Override
    public String next() {
        String paragraph = textReader.next();
        String[] words = paragraph.split("\\W+");
        StringBuilder result = new StringBuilder();

        // capitalize the first letter and the last letter of each word
        for (String word : words) {
            if (word.length() > 0) {
                String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result.append(capitalized);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
