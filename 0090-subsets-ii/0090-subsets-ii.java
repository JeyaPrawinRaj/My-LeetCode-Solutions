import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to handle duplicates
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // 2. Skip duplicates: 
            // If the current element is the same as the previous one
            // AND we are not at the start of the current recursive branch
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Standard backtracking: add, recurse, remove
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
