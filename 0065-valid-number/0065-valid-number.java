class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign must be at index 0 or right after 'e' or 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // Exponent can't repeat, and must follow a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure digits follow the exponent
            } else if (c == '.') {
                // Dot can't repeat and can't be in the exponent part
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character (like 'a') is invalid
                return false;
            }
        }

        return seenDigit; 
    }
}