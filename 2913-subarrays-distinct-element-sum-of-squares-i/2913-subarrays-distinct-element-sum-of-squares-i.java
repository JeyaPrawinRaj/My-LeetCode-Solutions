import java.util.List;
import java.util.HashSet;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSumOfSquares = 0;
        int n = nums.size();
        
        // Iterate through all possible starting indices of subarrays
        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctElements = new HashSet<>();
            
            // Expand the subarray from index i to j
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                
                int distinctCount = distinctElements.size();
                totalSumOfSquares += distinctCount * distinctCount;
            }
        }
        
        return totalSumOfSquares;
    }
}
