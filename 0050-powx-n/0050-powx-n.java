class Solution {
    public double myPow(double x, int n) {
        long power = n;  // convert to long to avoid overflow
        
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        
        double result = 1;
        
        while (power > 0) {
            
            if (power % 2 == 1) {   // if odd
                result *= x;
            }
            
            x *= x;        // square the base
            power /= 2;    // divide power by 2
        }
        
        return result;
    }
}