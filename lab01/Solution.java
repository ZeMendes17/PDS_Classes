import java.util.List;

public class Solution {
    char[][] wordSearch;
    String[] words;

    public Solution(char[][] wordSearch, String[] words){
        this.wordSearch = wordSearch;
        this.words = words;
    }

    // getters
    public char[][] getWordSearch(){
        return wordSearch;
    }
    public String[] getWords(){
        return words;
    }

    //setters
    public void setWordSearch(char[][] wordSearch){
        this.wordSearch = wordSearch;
    }
    public void setWords(String[] words){
        this.words = words;
    }

    public List<Word> solve(char[][] wordSearch, String[] words){
        // aqui vai ser implementado o metodo para resolver o problema em si
        // possivel solução:
        // ir verificando letra a letra, tentar ir para todas as direçoes, ir removendo as palavras de uma lista temporaria de acordo com a letra
        // se voltar a 0 adicionar denovo as palavras a lista e continuar
        // guardar:
        // tamanho da palavra
        // posição da primeira letra
        // que direção segue
    }
}
