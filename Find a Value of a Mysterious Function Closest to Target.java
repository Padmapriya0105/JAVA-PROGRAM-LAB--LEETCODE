import java.util.*;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        Set<Integer> validValues = new HashSet<>();
        validValues.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            Set<Integer> nextValues = new HashSet<>();
            nextValues.add(arr[i]);
            ans = Math.min(ans, Math.abs(arr[i] - target));
            
            for (int prev : validValues) {
                int currentAnd = prev & arr[i];
                nextValues.add(currentAnd);
                ans = Math.min(ans, Math.abs(currentAnd - target));
            }
            validValues = nextValues;
        }
        
        return ans;
    }
}
