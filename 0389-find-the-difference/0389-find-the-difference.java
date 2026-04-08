class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        
        // XOR all chars in s
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        
        // XOR all chars in t
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        
        return result;
    }
}
