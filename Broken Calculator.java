class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        while (target > startValue) {
            operations++;
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
        }
        return operations + (startValue - target);
    }
}
