package JogoDoGalo;

public class JGaloImplementation implements JGaloInterface {

    char[][] board;
    char currentPlayer; 
    boolean isFinished; 
    char winner;
    int moveNumber;

    

    public JGaloImplementation() {
        this.board = new char[3][3]; // '\u0000'
        this.currentPlayer = 'X';
        this.isFinished = false;
        this.winner = ' ';
        this.moveNumber = 0;
    }

    @Override
    public char getActualPlayer() {
        return currentPlayer;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        if ( this.board[lin-1][col-1] == '\u0000' ){
            this.board[lin-1][col-1] = currentPlayer;
            moveNumber++;

            if (isWinnerPlay()){
                this.isFinished = true;
                this.winner = currentPlayer;
            }else{
                if (this.currentPlayer == 'X'){
                    this.currentPlayer = 'O';
                }else{
                    this.currentPlayer = 'X';
                }
            }

            if (moveNumber == 9) {
                this.isFinished = true;
            }
            return true;
        }
        return false;
        
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public char checkResult() {
        return winner;
    }
    
    private boolean isWinnerPlay(){
        if (this.board[1][1] == currentPlayer){
            if ((this.board[0][0]==currentPlayer && this.board[2][2]==currentPlayer) || (this.board[0][2]==currentPlayer && this.board[2][0]==currentPlayer)){
                return true;
            }
        }
        for (int i = 0 ; i < 3 ; i++){
            if (this.board[i][0] == currentPlayer ){
                if (this.board[i][1] == currentPlayer && this.board[i][2] == currentPlayer){
                    return true;
                }
            }
            if (this.board[0][i] == currentPlayer ){
                if (this.board[1][i] == currentPlayer && this.board[2][i] == currentPlayer){
                    return true;
                }
            }
        }
        return false;
    }

    
}
