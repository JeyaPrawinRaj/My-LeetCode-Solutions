class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        
        // Helper function or boolean array for fast lookup
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = isVowel['e'] = isVowel['i'] = isVowel['o'] = isVowel['u'] = true;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel[s.charAt(i)]) currentVowels++;
        }
        maxVowels = currentVowels;

        // Slide the window across the rest of the string
        for (int i = k; i < s.length(); i++) {
            if (maxVowels == k) return k; // Optimization: found maximum possible
            
            if (isVowel[s.charAt(i)]) currentVowels++;     // Entering
            if (isVowel[s.charAt(i - k)]) currentVowels--; // Leaving
            
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
