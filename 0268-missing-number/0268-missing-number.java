class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Gauss' formula for sum of 0 to n: n * (n + 1) / 2
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}
