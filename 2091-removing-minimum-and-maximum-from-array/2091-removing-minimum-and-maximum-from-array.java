class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int minIdx = 0;
        int maxIdx = 0;

        // Find indices of min and max in a single pass
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[minIdx]) {
                minIdx = k;
            }
            if (nums[k] > nums[maxIdx]) {
                maxIdx = k;
            }
        }

        // Assign i to the smaller index and j to the larger index
        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Strategy 1: Remove both from the front
        int delFront = j + 1;

        // Strategy 2: Remove both from the back
        int delBack = n - i;

        // Strategy 3: Remove i from front and j from back
        int delBoth = (i + 1) + (n - j);

        // Return the minimum deletions among the three choices
        return Math.min(delFront, Math.min(delBack, delBoth));
    }
}
