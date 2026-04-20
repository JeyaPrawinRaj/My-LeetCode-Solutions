class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0;
        int right = n - 1;

        // Compare everything against the first house (index 0)
        // Find the rightmost house that has a different color
        while (colors[n - 1] == colors[0]) {
            n--;
        }
        int dist1 = n - 1;

        // Compare everything against the last house (index colors.length - 1)
        // Find the leftmost house that has a different color
        int lastIdx = colors.length - 1;
        while (colors[left] == colors[lastIdx]) {
            left++;
        }
        int dist2 = lastIdx - left;

        return Math.max(dist1, dist2);
    }
}
