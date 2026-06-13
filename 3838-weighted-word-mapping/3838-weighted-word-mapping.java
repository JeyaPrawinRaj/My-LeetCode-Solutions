class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            long totalWeight = 0;
            
            // Calculate the total weight of the current word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                totalWeight += weights[ch - 'a'];
            }
            
            // Find the remainder modulo 26
            int remainder = (int) (totalWeight % 26);
            
            // Map the remainder to reverse alphabetical order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a')
            char mappedChar = (char) ('z' - remainder);
            
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}
