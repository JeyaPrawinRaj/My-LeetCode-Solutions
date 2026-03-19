public class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        
        // prefixX[i+1][j+1] stores the count of 'X' in submatrix (0,0) to (i,j)
        int[][] prefixX = new int[R + 1][C + 1];
        int[][] prefixY = new int[R + 1][C + 1];
        int count = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int valX = (grid[r][c] == 'X') ? 1 : 0;
                int valY = (grid[r][c] == 'Y') ? 1 : 0;

                // Inclusion-Exclusion formula for 2D prefix sums
                prefixX[r + 1][c + 1] = valX + prefixX[r][c + 1] + prefixX[r + 1][c] - prefixX[r][c];
                prefixY[r + 1][c + 1] = valY + prefixY[r][c + 1] + prefixY[r + 1][c] - prefixY[r][c];

                // Check conditions: Equal X and Y counts AND at least one X
                if (prefixX[r + 1][c + 1] == prefixY[r + 1][c + 1] && prefixX[r + 1][c + 1] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
