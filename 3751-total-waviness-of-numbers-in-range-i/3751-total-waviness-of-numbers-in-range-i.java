class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        
        for (int num = num1; num <= num2; num++) {
            String s = Integer.toString(num);
            if (s.length() < 3) {
                continue;
            }
            
            for (int i = 1; i < s.length() - 1; i++) {
                char curr = s.charAt(i);
                char prev = s.charAt(i - 1);
                char next = s.charAt(i + 1);
                
                // Check if current digit is a peak or a valley
                if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                    totalWaviness++;
                }
            }
        }
        
        return totalWaviness;
    }
}
