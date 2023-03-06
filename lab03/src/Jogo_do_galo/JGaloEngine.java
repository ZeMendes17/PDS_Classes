package src.Jogo_do_galo;

public class JGaloEngine implements JGaloInterface{
    char currentPlayer; // ou 'O'
    boolean finished;
    char board[][];
    int numberOfPlays;

    // constructor if the first player is specified -> X or O
    public JGaloEngine(char currentPlayer){
        this.currentPlayer = currentPlayer; // ou 'O'
        finished = false;
        board = new char[3][3];
        numberOfPlays = 0;
    }

    // constructor if the first player is not specified -> always 'X'
    public JGaloEngine(){
        this.currentPlayer = 'X'; // ou 'O'
        finished = false;
        board = new char[3][3];
        numberOfPlays = 0;
    }

    @Override
    // gets the current player
    public char getActualPlayer() {
        return currentPlayer;
    }

    @Override
    // does the play, returning true if it is possible and false if not
    // also switches from X to O
    public boolean setJogada(int lin, int col) {
        --lin;
        --col;

        if(numberOfPlays >= 9 || lin > 2 || col > 2 || board[lin][col] != '\0'){
            return false;
        }
        else{
            if(numberOfPlays % 2 == 0){
                board[lin][col] = currentPlayer;
                currentPlayer = 'O';
            } else{
                board[lin][col] = currentPlayer;
                currentPlayer = 'X';
            }

            numberOfPlays++;
            if(numberOfPlays >= 9)
                finished = true;

            return true;
        }
    }

    @Override
    // checks if the game has finnished returning true if so
    public boolean isFinished() {
        if(!Character.isWhitespace(checkResult()))
            return true;

        return finished;
    }

    @Override
    // final result, if someone has won or it is a draw
    public char checkResult() {
        int i;
        char winner = ' ';

        for (i = 0; i < 3; i++) {
            
            // check coluns first
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                if(board[0][i] != '\0')
                    winner = board[0][i];
            }
            // check lines after
            else if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if(board[i][0] != '\0')
                    winner = board[i][0];
            }
            // check downLeft diagonal
            else if (board[0][0] == board[1][1] && board [1][1] == board[2][2]) {
                if(board[0][0] != '\0')
                winner = board[0][0];
            }
            // check downRight diagonal
            else if (board[0][2] == board[1][1] && board [1][1] == board[2][0]) {
                if(board[0][2] != '\0')
                    winner = board[0][2];
            }
            
        }
        return winner;
    }

}