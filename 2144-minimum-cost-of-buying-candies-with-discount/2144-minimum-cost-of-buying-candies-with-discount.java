import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // Step 1: Sort the array to access elements from largest to smallest
        Arrays.sort(cost);
        
        int totalCost = 0;
        int n = cost.length;
        
        // Step 2: Iterate from the end of the sorted array
        for (int i = n - 1; i >= 0; i--) {
            // Count the position from the back (1-indexed for convenience)
            int positionFromBack = n - i;
            
            // Every 3rd item from the back is free! Skip adding it to totalCost
            if (positionFromBack % 3 == 0) {
                continue;
            }
            
            // Otherwise, we must pay for it
            totalCost += cost[i];
        }
        
        return totalCost;
    }
}
