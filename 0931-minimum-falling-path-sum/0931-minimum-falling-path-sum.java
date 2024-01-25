class Solution {
    static int helper(int i, int j, int[][] matrix,int[][]dp) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return (int) Math.pow(10, 9);
        }

        if (i == m - 1) {
            return matrix[m - 1][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

        int rightDiagonal = matrix[i][j] + helper(i + 1, j + 1, matrix,dp);
        int leftDiagonal = matrix[i][j] + helper(i + 1, j - 1, matrix,dp);
        int diagonal = matrix[i][j] + helper(i + 1, j, matrix,dp);

        dp[i][j]= Math.min(rightDiagonal, Math.min(leftDiagonal, diagonal));
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        
        int result = Integer.MAX_VALUE;
        int m=matrix.length;
        int n = matrix[0].length;
        int [][]dp=new int [m+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        for (int j = 0; j < n; j++) {
            result = Math.min(result, helper(0, j, matrix,dp));
        }

        return result;
    }
}