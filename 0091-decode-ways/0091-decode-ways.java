class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // dp[i] stores the number of ways to decode the string of length i
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty string has 1 way to be decoded (doing nothing)
        dp[1] = 1; // We already checked that s[0] != '0'

        for (int i = 2; i <= n; i++) {
            // Check the single digit (s[i-1])
            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check the two digits (s[i-2]s[i-1])
            int doubleDigit = Integer.parseInt(s.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}