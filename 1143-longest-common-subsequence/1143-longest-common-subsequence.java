class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int [m+1][n+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(m-1,n-1,text1,text2,dp);
    }
    static int helper(int m,int n,String text1,String text2,int[][]dp){
        if (m < 0 || n < 0) {
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
      if (text1.charAt(m) == text2.charAt(n)) {
            return 1 + helper(m - 1, n - 1, text1, text2,dp);
        }
       int not=helper(m,n-1,text1,text2,dp);
       int take=helper(m-1,n,text1,text2,dp);

       dp[m][n]= Math.max(not, take);
       return dp[m][n];
    }
}