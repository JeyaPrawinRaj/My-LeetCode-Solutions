class Solution {
    public int maxSubArray(int[] nums) {
         int maxSum = nums[0];
        int currentSum = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to start a new subarray or extend the existing one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}