public class Board {
    public Piece[][] board;
    public int size;

    Board(int size) {
        this.size=size;
        this.board= new Piece[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }

    }
    public Boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean addPiece(Piece piece, int row, int col) {
        if(board[row][col]==null) {
            board[row][col]=piece;
            return true;
        }
        return false;
    }
}
