class Solution {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int MOD = 1_000_000_007;
        
        // Precompute combinations for 3-letter and 4-letter keys
        long[] f3 = new long[n + 1];
        long[] f4 = new long[n + 1];
        f3[0] = 1; f4[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 3 && i - k >= 0; k++) f3[i] = (f3[i] + f3[i - k]) % MOD;
            for (int k = 1; k <= 4 && i - k >= 0; k++) f4[i] = (f4[i] + f4[i - k]) % MOD;
        }

        long ans = 1;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && pressedKeys.charAt(j) == pressedKeys.charAt(i)) j++;
            int count = j - i;
            char key = pressedKeys.charAt(i);
            // Keys 7 and 9 have 4 possible characters; others have 3
            if (key == '7' || key == '9') ans = (ans * f4[count]) % MOD;
            else ans = (ans * f3[count]) % MOD;
        }
        
        return (int) ans;
    }
}
