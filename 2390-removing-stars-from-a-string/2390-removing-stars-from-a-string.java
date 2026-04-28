class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Remove the last character added (LIFO)
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                // Add non-star characters to our "stack"
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
