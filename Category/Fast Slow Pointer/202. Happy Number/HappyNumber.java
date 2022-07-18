class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (slow == 1)
                return true;
        } while (slow != fast);

        return false;
    }

    private int squareSum(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            res += rem * rem;
            n /= 10;
        }
        return res;
    }
}
