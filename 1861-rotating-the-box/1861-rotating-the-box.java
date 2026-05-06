class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Simulate Gravity for each row
        for (int i = 0; i < m; i++) {
            // Keep track of the rightmost available empty position
            int emptyPos = n - 1; 
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    // Move stone to the empty position
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyPos] = '#';
                    emptyPos--;
                } else if (boxGrid[i][j] == '*') {
                    // Obstacle blocks stones; reset empty position to the left of it
                    emptyPos = j - 1;
                }
            }
        }

        // Step 2: Rotate the box 90 degrees clockwise
        // New dimensions: rows = n, columns = m
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (i, j) in original maps to (j, m - 1 - i) in rotated
                rotatedBox[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotatedBox;
    }
}
