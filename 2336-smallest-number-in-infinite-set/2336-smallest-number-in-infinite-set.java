import java.util.*;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> addedBack;
    private HashSet<Integer> inSet;
    private int currentSmallest;

    public SmallestInfiniteSet() {
        addedBack = new PriorityQueue<>();
        inSet = new HashSet<>();
        currentSmallest = 1; // Starts at 1
    }
    
    public int popSmallest() {
        // If there are numbers added back, they are smaller than currentSmallest
        if (!addedBack.isEmpty()) {
            int smallest = addedBack.poll();
            inSet.remove(smallest);
            return smallest;
        }
        // Otherwise, return the next sequential number
        return currentSmallest++;
    }
    
    public void addBack(int num) {
        // Only add back if it's smaller than our current pointer and not already present
        if (num < currentSmallest && inSet.add(num)) {
            addedBack.offer(num);
        }
    }
}
