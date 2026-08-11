import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingInteger(int[] nums) {
        // 1. Calculate the sum of the longest sequential prefix
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }
        
        // 2. Add elements to a HashSet for O(1) containment checks
        Set<Integer> presenceSet = new HashSet<>();
        for (int num : nums) {
            presenceSet.add(num);
        }
        
        // 3. Increment prefixSum until it's not present in the set
        while (presenceSet.contains(prefixSum)) {
            prefixSum++;
        }
        
        return prefixSum;
    }
}
