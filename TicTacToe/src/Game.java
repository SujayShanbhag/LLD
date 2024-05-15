import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public Board playingBoard;
    public Queue<Player> players;

    Game() {
        playingBoard = new Board(3);
        players = new LinkedList<>();
        Player player1= new Player("P1",new Piece(PieceType.X));
        Player player2 = new Player("P2",new Piece(PieceType.O));
        players.add(player1);
        players.add(player2);
    }
    public void start() {
        while(!playingBoard.isFull())
        {
            playingBoard.printBoard();
            Player playerTurn = players.peek();

            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            if(!playingBoard.addPiece(playerTurn.playingPiece, inputRow, inputColumn)) {
                System.out.println("Incorrect position chosen, try again");
                continue;
            }

            if(isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType)) {
                System.out.print("Player " + playerTurn.name + " won");
                return;
            }
            players.remove();
            players.add(playerTurn);
        }
        playingBoard.printBoard();
        System.out.print("Its a Tie!!!! ");
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i = 0; i< playingBoard.size; i++) {

            if(playingBoard.board[row][i] == null || playingBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i = 0; i< playingBoard.size; i++) {

            if(playingBoard.board[i][column] == null || playingBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i = 0, j = 0; i< playingBoard.size; i++,j++) {
            if (playingBoard.board[i][j] == null || playingBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i = 0, j = playingBoard.size-1; i< playingBoard.size; i++,j--) {
            if (playingBoard.board[i][j] == null || playingBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
