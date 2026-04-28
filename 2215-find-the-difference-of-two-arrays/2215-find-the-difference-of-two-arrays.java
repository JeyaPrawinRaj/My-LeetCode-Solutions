import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        
        // Find elements in set1 not in set2
        for (int n : set1) {
            if (!set2.contains(n)) {
                result.get(0).add(n);
            }
        }
        
        // Find elements in set2 not in set1
        for (int n : set2) {
            if (!set1.contains(n)) {
                result.get(1).add(n);
            }
        }
        
        return result;
    }
}
