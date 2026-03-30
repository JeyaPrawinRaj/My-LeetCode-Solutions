class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        
        // Iteratively build the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            for (int j = 0; j < res.length(); j++) {
                // If the next character is the same, increment count
                if (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                } else {
                    // Otherwise, append count and the character
                    sb.append(count).append(res.charAt(j));
                    count = 1; // Reset count for the next digit
                }
            }
            res = sb.toString();
        }
        
        return res;
    }
}
