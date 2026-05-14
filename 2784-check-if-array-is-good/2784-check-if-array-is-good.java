import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        if (n < 1) return false;
        
        Arrays.sort(nums);
        
        // Check elements from index 0 to n-1 match 1, 2, ..., n
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        
        // Check the last duplicate element matches n
        return nums[n] == n;
    }
}
