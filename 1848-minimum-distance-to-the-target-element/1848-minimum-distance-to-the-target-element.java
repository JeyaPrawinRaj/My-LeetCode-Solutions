class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // Calculate absolute distance
                int currentDistance = Math.abs(i - start);
                
                // Update min if current is smaller
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }
        }
        
        return minDistance;
    }
}
