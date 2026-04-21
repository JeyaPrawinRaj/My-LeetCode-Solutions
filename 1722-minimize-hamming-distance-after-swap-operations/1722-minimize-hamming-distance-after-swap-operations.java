import java.util.*;

class Solution {
    int[] p; // Parent array for Union-Find
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length, res = 0;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        
        for (int[] s : allowedSwaps) p[find(s[0])] = find(s[1]);

        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                  .merge(source[i], 1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> counts = groups.get(find(i));
            if (counts.getOrDefault(target[i], 0) > 0) {
                counts.put(target[i], counts.get(target[i]) - 1);
            } else {
                res++;
            }
        }
        return res;
    }

    int find(int i) {
        return p[i] == i ? i : (p[i] = find(p[i]));
    }
}
