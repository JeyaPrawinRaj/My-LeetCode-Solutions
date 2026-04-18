class Solution {
    public int mirrorDistance(int n) {
        // Convert to String, reverse it, and parse back to int
        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        int reversedN = Integer.parseInt(reversedStr);
        
        // Return absolute difference
        return Math.abs(n - reversedN);
    }
}
