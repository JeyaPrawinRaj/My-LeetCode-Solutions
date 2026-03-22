class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the end of valid elements in nums1
        int p1 = m - 1;
        // Pointer for the end of nums2
        int p2 = n - 1;
        // Pointer for the very last position in nums1
        int p = m + n - 1;

        // While there are elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            // Compare the largest available elements and place the larger one at the back
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are leftover elements in nums2, copy them over
        // (Note: Leftover elements in nums1 are already in the correct place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
