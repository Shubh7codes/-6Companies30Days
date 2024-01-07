public class Solution {
    private long[][] dp;

    private long count(int currentVertex, int target, int k) {
        if (k == 0 && currentVertex == target)
            return 1;
        if (k == 0)
            return 0;

        if (dp[currentVertex + 1000][k] != -1)
            return dp[currentVertex + 1000][k];

        long a = count(currentVertex + 1, target, k - 1);
        a += count(currentVertex - 1, target, k - 1);

        return dp[currentVertex + 1000][k] = a % 1000000007;
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new long[4001][1001];
        for (int i = 0; i <= 4000; i++)
            for (int j = 0; j <= 1000; j++)
                dp[i][j] = -1;

        long ans = count(startPos, endPos, k);
        return (int) (ans % 1000000007);
    }
}
