class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][]dp=new int[n+1][amount+1];
        for(int i = 0;i<=amount;i++) {
           if(i % coins[0] == 0) dp[0][i] = 1;
           else dp[0][i] = 0;
       }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake=dp[i-1][j];
                int Take=0;
                if(coins[i]<=j){
                Take= dp[i][j-coins[i]];
              }
                   dp[i][j]= (notTake+Take);
            }
        }
       return dp[n-1][amount];
    }
}