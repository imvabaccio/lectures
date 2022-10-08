public class Queens {
    // abstraction
    public boolean isSafe(int[][] board, int i, int j) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] == 1)
                return false;
        }
        for (int col = 0; col < board.length; col++) {
            if (board[i][col] == 1)
                return false;
        }

        int row = i;
        int col = j;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1)
                return false;
            row--;
            col--;
        }

        row = i;
        col = j;

        while (row >= 0 && col < board.length) {
            if (board[row][col] == 1)
                return false;
            row--;
            col++;
        }

        return true;
    }

    public boolean solve(int[][] board, int row) {
        if (row == board.length)
            return true;

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;
                if (solve(board, row + 1)) {
                    return true;
                }

                board[row][i] = 0;
            }
        }
        return false;
    }

    public void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
