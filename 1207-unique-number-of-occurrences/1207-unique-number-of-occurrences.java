import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if all frequencies are unique
        // Adding counts to a Set will automatically filter out duplicates
        Set<Integer> uniqueCounts = new HashSet<>(counts.values());

        // If the size of the set matches the size of the map, 
        // it means all frequencies were unique.
        return counts.size() == uniqueCounts.size();
    }
}
