class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the first position (leftmost)
        result[0] = findFirst(nums, target);
        
        // Find the last position (rightmost)
        result[1] = findLast(nums, target);
        
        return result;
    }
    
    // Binary search to find the first occurrence
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                firstPos = mid;
                right = mid - 1;  // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return firstPos;
    }
    
    // Binary search to find the last occurrence
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastPos = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                lastPos = mid;
                left = mid + 1;  // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastPos;
    }
}