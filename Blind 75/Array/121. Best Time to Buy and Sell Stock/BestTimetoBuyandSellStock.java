//0 ms solution
public int maxProfit(int[] prices) {
    int max = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < min)
            min = prices[i];
        else
            max = Math.max(max, prices[i] - min);
    }
    return max;
}

// Kandane's algorithm
public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for(int i = 1; i < prices.length; i++) {
        maxCur = Math.max(0, maxCur + prices[i] - prices[i-1]);
        maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
}
