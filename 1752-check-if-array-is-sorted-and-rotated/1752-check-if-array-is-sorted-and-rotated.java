class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Use modulo (%) to smoothly check the last element against the first element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // If there is more than 1 drop, it cannot be a sorted rotated array
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
