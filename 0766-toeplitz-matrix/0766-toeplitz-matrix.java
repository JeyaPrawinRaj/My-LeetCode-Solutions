class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from (1,1) to avoid Out Of Bounds errors when checking top-left
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                // If the current element doesn't match its top-left neighbor
                if (matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
