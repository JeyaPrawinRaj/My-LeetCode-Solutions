class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        
        long maxVal = f;
        
        // Calculate subsequent F(k) using the transition formula
        for (int i = n - 1; i > 0; i--) {
            f = f + sum - (long) n * nums[i];
            maxVal = Math.max(maxVal, f);
        }
        
        return (int) maxVal;
    }
}
