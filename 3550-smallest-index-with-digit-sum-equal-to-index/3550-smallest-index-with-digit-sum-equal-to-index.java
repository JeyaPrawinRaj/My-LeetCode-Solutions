class Solution {
    public int smallestIndex(int[] nums) {
        // Iterate through the array sequentially to find the smallest index first
        for (int i = 0; i < nums.length; i++) {
            if (getDigitSum(nums[i]) == i) {
                return i; // Return the first matching index found
            }
        }
        return -1; // Return -1 if no such index exists
    }

    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
