public class JogoDoGalo implements JGaloInterface{
    private char[][] board;
    private char player1;
    private char player2;
    private char winner;
    private int num_jogadas;

    public JogoDoGalo(String[] args){
        this.board = new char[3][3];
        if(args.length == 1){
            this.player1 = args[0].charAt(0);
            if(this.player1 == 'O'){
                this.player2 = 'X';    
            }
            else{
                this.player2 = 'O';
            }
        }
        else{
            this.player1 = 'X';
            this.player2 = 'O';
        }
        this.winner = ' ';
        this.num_jogadas = 0;
    }

    public char getActualPlayer(){
        int n = this.num_jogadas % 2;
        if(n==0){
            return player1;
        }
        return player2;
    }

    public boolean setJogada(int lin, int col){
        lin--;
        col--;
        char player = getActualPlayer();
        System.out.println(board[lin][col]);
        if(lin < 0 || lin > 3 || col < 0 || col > 3 || board[lin][col] == 'X' || board[lin][col] == 'O'){
            return false;
        }
        board[lin][col] = player;
        num_jogadas++;
        return true;
    }

    public boolean isFinished(){
        //linhas e colunas
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '\u0000'){
                this.winner = board[i][0];
                return true;
            }
            else if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '\u0000'){
                this.winner = board[0][i];
                return true;
            }
        }

        //duas diagonais
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '\u0000'){
            this.winner = board[0][0];
            return true;
        }
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '\u0000'){
            this.winner = board[0][2];
            return true;
        }

        //todas as posiçoes estao ocupadas : empate
        if(num_jogadas == 9){
            this.winner = ' ';
            return true;
        }
        return false;
    }

    public char checkResult(){
        return this.winner;
    }
}
