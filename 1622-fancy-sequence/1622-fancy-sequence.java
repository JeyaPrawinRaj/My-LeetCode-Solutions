class Fancy {
    private List<Long> nums;
    private long mult;
    private long add;
    private static final long MOD = 1_000_000_007;

    public Fancy() {
       nums = new ArrayList<>();
        mult = 1;
        add = 0; 
    }
    
    public void append(int val) {
        // Reverse the current transformations to store a "neutral" value
        // val = (stored * mult + add) % MOD  => stored = (val - add) * inv(mult) % MOD
        long valToStore = (val - add + MOD) % MOD;
        valToStore = (valToStore * modInverse(mult, MOD)) % MOD;
        nums.add(valToStore);
    }
    
    public void addAll(int inc) {
         add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
         mult = (mult * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
         if (idx >= nums.size()) return -1;
        // Apply current global mult and add to the stored neutral value
        long res = (nums.get(idx) * mult + add) % MOD;
        return (int) res;

    }
    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long x, long y, long m) {
        long res = 1;
        x %= m;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % m;
            y = y >> 1;
            x = (x * x) % m;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */