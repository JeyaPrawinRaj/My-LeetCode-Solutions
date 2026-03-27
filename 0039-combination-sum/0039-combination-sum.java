import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting helps to stop early (pruning) if the number is already too big
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return; // Base case: exceeded the target
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < nums.length; i++) {
                // Optimization: if the current number is greater than the remainder,
                // no need to check the rest since the array is sorted.
                if (nums[i] > remain) break; 
                
                tempList.add(nums[i]);
                // Notice: 'i' is passed as the start index instead of 'i + 1'
                // because we can reuse the same element.
                backtrack(result, tempList, nums, remain - nums[i], i);
                
                // Backtrack: remove the last added element to try other paths
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}