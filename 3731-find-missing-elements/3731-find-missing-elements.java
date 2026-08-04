import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        // Populate the set and establish boundaries in one pass
        for (int num : nums) {
            set.add(num);
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }
        
        List<Integer> missing = new ArrayList<>();
        // Iterate through the full range
        for (int i = minVal; i <= maxVal; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }
        
        return missing;
    }
}
