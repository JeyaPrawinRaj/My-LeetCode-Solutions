class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Base case: n=0 starts with 0
        result.add(0);
        
        for (int i = 0; i < n; i++) {
            // The number of elements currently in the list
            int size = result.size();
            // The value of the bit we are adding (2^i)
            int bitToAdd = 1 << i;
            
            // Iterate backwards through the existing list
            for (int j = size - 1; j >= 0; j--) {
                // Mirror the element and add the new bit
                result.add(result.get(j) | bitToAdd);
            }
        }
        
        return result;
    }
}
