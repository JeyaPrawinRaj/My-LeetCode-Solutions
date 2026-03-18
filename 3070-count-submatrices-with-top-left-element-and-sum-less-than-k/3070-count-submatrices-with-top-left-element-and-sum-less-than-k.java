class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // Use a 2D Prefix Sum approach to calculate sums of submatrices starting at (0,0)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Add top neighbor's sum
                if (r > 0) {
                    grid[r][c] += grid[r - 1][c];
                }
                // Add left neighbor's sum
                if (c > 0) {
                    grid[r][c] += grid[r][c - 1];
                }
                // Subtract the top-left diagonal neighbor (added twice in the steps above)
                if (r > 0 && c > 0) {
                    grid[r][c] -= grid[r - 1][c - 1];
                }

                // If the sum is within limits, increment the count
                if (grid[r][c] <= k) {
                    count++;
                } else {
                    // Since elements are non-negative, any larger submatrix 
                    // in this row will also exceed k.
                    break;
                }
            }
        }

        return count;
    }
}