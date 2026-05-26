import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lowercaseChars = new HashSet<>();
        Set<Character> uppercaseChars = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseChars.add(c);
            } else {
                uppercaseChars.add(c);
            }
        }
        
        int specialCount = 0;
        for (char c : lowercaseChars) {
            if (uppercaseChars.contains(Character.toUpperCase(c))) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}
