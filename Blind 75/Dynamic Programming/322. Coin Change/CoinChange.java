// 1 DP solution with pruning 
// Solution 1, coins outer loop, average 92ms
// Making coins the outer loop saves the extra "if" and quite some time. 
public int coinChange(int[] coins, int ammount) {
	Arrays.sort(coins);
	int[] dp = new int[ammount + 1];
	Arrays.fill(dp, ammount + 1);
	dp[0] = 0;
	for (int coin: coins) {
		for (int i = coin; i <= ammount; i++)
			dp[i] = Math.min(dp[i], dp[i - coin] + 1);
	}
	return dp[ammount] > ammount ? -1 : dp[ammount];

}

// Solution 1, coins outer loop, with "if"
public int coinChange(int[] coins, int amount) {
	Arrays.sort(coins); // sorted the coins for pruning
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int j = 0; j < coins.length; j++) {
        for (int i = 0; i <= amount; i++) {
            if (i - coins[j] >= 0) 
				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}

//1 DP with diff loop for pruning
// Solution 2, amount outer loop, average 180ms
public int coinChange(int[] coins, int amount) {
	Arrays.sort(coins);
	int[] dp = new int[amount + 1];
	Arrays.fill(dp, amount + 1);
	dp[0] = 0;
	
	for (int i = 0; i <= amount; i++) {
		for (int j = 0; j < coins.length; j++) {
			if (i - coins[j] >= 0) 
				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			else if(i - coins[j] < 0)
				break;
		}
	}
	
	return dp[amount] > amount ? -1 : dp[amount];
}