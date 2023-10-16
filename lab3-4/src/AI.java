public class AI {
    private final char[][] board; // Змінна для представлення гри

    public AI(char[][] chart) {
        this.board = chart;
    }

    public void makeAIMove() {
        int bestMove = getAIMove();
        int row = bestMove / MapRendering.MAP_SIZE;
        int col = bestMove % MapRendering.MAP_SIZE;
        board[row][col] = MapRendering.O_CHAR;
    }

    public int getAIMove() {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            int row = i / MapRendering.MAP_SIZE;
            int col = i % MapRendering.MAP_SIZE;

            if (board[row][col] == MapRendering.EMPTY_FIELD) {
                board[row][col] = MapRendering.O_CHAR;
                int score = minimax(board, 0, false);
                board[row][col] = MapRendering.EMPTY_FIELD;

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    // Minimax алгоритм
    private int minimax(char[][] board, int depth, boolean isMaximizing) {

        if (RulesChecking.checkWin(MapRendering.O_CHAR)) {
            return 1;
        } else if (RulesChecking.checkWin(MapRendering.X_CHAR)) {
            return -1;
        } else if (RulesChecking.checkDraft()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                int row = i / MapRendering.MAP_SIZE;
                int col = i % MapRendering.MAP_SIZE;

                if (board[row][col] == MapRendering.EMPTY_FIELD) {
                    board[row][col] = MapRendering.O_CHAR;
                    int score = minimax(board, depth + 1, false);
                    board[row][col] = MapRendering.EMPTY_FIELD;
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                int row = i / MapRendering.MAP_SIZE;
                int col = i % MapRendering.MAP_SIZE;

                if (board[row][col] == MapRendering.EMPTY_FIELD) {
                    board[row][col] = MapRendering.X_CHAR;
                    int score = minimax(board, depth + 1, true);
                    board[row][col] = MapRendering.EMPTY_FIELD;
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

}
