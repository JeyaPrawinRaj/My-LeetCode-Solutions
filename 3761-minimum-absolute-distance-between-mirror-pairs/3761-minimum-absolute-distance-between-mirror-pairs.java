import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // key: reverse(nums[i]), value: index i
        Map<Integer, Integer> lastSeenReverse = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // If current nums[j] matches a previously stored reverse(nums[i])
            if (lastSeenReverse.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - lastSeenReverse.get(nums[j]));
            }

            // Calculate reverse of current number and store its index
            int reversed = reverse(nums[j]);
            lastSeenReverse.put(reversed, j);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}
