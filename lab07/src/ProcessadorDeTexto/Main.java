package src.ProcessadorDeTexto;

// Testing the filters
public class Main {
    public static void main(String[] args) {
        ReaderInterface reader = new TextFileReader("../doc/example.txt");
        reader = new NormalizationFilter(reader);
        reader = new VowelFilter(reader);
        reader = new CapitalizationFilter(reader);
        reader = new VowelFilter(new TermFilter(reader));

        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
