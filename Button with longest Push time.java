class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int res = events[0][0];
        int maxTime = events[0][1];

        for (int i = 1; i < events.length; i++) {
            int duration = events[i][1] - events[i - 1][1];
            int index = events[i][0];

            if (duration > maxTime || (duration == maxTime && index < res)) {
                maxTime = duration;
                res = index;
            }
        }

        return res;
    }
}
