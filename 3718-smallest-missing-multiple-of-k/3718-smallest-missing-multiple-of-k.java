import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Step 1: Store elements in a HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        // Step 2: Check multiples of k starting from k
        int multiple = k;
        while (numSet.contains(multiple)) {
            multiple += k;
        }
        
        // Step 3: Return the first missing positive multiple
        return multiple;
    }
}
