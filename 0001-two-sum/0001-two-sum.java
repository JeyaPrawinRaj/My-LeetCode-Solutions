import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: value -> index
        Map<Integer, Integer> prevMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            // If the complement exists in the map, we found the pair
            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }
            
            // Otherwise, store the current number and its index
            prevMap.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though the problem says one always exists)
        return new int[] {};
    }
}
