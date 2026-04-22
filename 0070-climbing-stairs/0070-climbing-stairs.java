class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int first = 1;  // Ways to reach 1st step
        int second = 2; // Ways to reach 2nd step
        
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}
