class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >=0; j--) {
                int take = satisfaction[i] * (j+1) + dp[i + 1][j + 1];
                int not = dp[i + 1][j];
                dp[i][j] = Math.max(take, not);
            }
        }

        return dp[0][0];
    }
}
