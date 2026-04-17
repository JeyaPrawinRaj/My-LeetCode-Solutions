class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Start DFS if the first letter matches
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: all characters found
        if (index == word.length()) return true;

        // Check boundaries, character mismatch, or if already visited
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
            board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mask the current cell (mark as visited)
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        // Backtrack: restore the original character
        board[r][c] = temp;

        return found;
    }
}
