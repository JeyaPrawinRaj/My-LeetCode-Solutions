class Solution {
    public void nextPermutation(int[] nums) {
         int n = nums.length;
        
        // Step 1: Find the pivot (first decreasing element from right)
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        // If no pivot found, array is in descending order
        // Just reverse the entire array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Step 2: Find the successor (smallest element larger than pivot from right)
        int successor = -1;
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                successor = i;
                break;
            }
        }
        
        // Step 3: Swap pivot and successor
        swap(nums, pivot, successor);
        
        // Step 4: Reverse the suffix after pivot
        reverse(nums, pivot + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}