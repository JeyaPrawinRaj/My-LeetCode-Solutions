class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the last digit and move backwards
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If current digit is 9, set it to 0 and continue (carry over)
            digits[i] = 0;
        }
        
        // If we reach here, all digits were 9 (e.g., 999 -> 1000)
        // We need a new array with size n+1
        int[] result = new int[n + 1];
        result[0] = 1;  // First digit is 1, rest are 0 by default
        
        return result;
    }
}