import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int left = 0;
        int right = costs.length - 1;
        
        // Min-heaps for the leftmost and rightmost candidates
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        long totalCost = 0;
        
        for (int i = 0; i < k; i++) {
            // Fill left heap until it has 'candidates' elements or meets the right pointer
            while (leftHeap.size() < candidates && left <= right) {
                leftHeap.offer(costs[left++]);
            }
            // Fill right heap until it has 'candidates' elements or meets the left pointer
            while (rightHeap.size() < candidates && left <= right) {
                rightHeap.offer(costs[right--]);
            }
            
            // Get the smallest values from both heaps (default to infinity if empty)
            int val1 = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int val2 = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();
            
            // Priority given to leftHeap in case of a tie (as per smallest index rule)
            if (val1 <= val2) {
                totalCost += leftHeap.poll();
            } else {
                totalCost += rightHeap.poll();
            }
        }
        
        return totalCost;
    }
}
