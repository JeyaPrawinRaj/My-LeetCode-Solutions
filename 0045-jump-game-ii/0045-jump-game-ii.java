class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        // We don't need to process the last element because 
        // once we reach or pass it, we are done.
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point reachable from current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range for the current jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
                
                // Optimization: if we can already reach the end, break early
                if (currentJumpEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}