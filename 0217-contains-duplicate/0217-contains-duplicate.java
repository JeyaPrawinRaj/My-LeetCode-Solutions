class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Use a HashSet for O(1) average lookup time
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // .add() returns false if the element is already present
            if (!seen.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}
