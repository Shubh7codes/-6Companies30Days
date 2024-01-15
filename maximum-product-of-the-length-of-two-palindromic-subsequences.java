class Solution {
      public int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public int answer(String a) {
        StringBuilder sb = new StringBuilder(a);
        return lcs(a, sb.reverse().toString());
    }

    public int maxProduct(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder x = new StringBuilder();
            StringBuilder y = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    x.append(s.charAt(j));
                } else {
                    y.append(s.charAt(j));
                }
            }
            ans = Math.max(ans, answer(x.toString()) * answer(y.toString()));
        }
        return ans;
    }
}
