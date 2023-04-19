package src.ProcessadorDeTexto;

class CapitalizationFilter extends TextFilter {

    // constructor
    public CapitalizationFilter(ReaderInterface textReader) {
        super(textReader);
    }

    // interface methods

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    public String next() {
        if(super.hasNext()){
            String[] palavras = super.next().split(" ");
            String palavra;
            for(int i = 0; i < palavras.length; i++){
                palavra = palavras[i];

                if(i == 0){
                    palavra = String.valueOf(Character.toUpperCase(palavra.charAt(0)) + palavra.substring(1, palavra.length()));
                }
                if(i == palavras.length -1){
                    palavra = String.valueOf(palavra.substring(0, palavra.length()-1) + Character.toUpperCase(palavra.length()-1));
                }
                if(i != 0 && i != palavras.length-1){
                    palavra = palavra.toLowerCase();
                }
                palavras[i] = palavra;
            }

            return String.join(" ", palavras);
        } else {
            return null;
        }
    }
}
