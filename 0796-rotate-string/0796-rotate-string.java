class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Strings must be the same length to be rotations
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Step 2: Concatenate s with itself and check if goal exists in it
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
