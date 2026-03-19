import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map for Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentVal = romanMap.get(s.charAt(i));

            // Step 2: Compare current value with the next value
            if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                // Subtract if a smaller value precedes a larger one (e.g., IV = 4)
                total -= currentVal;
            } else {
                // Otherwise, add the value
                total += currentVal;
            }
        }
        return total;
    }
}
