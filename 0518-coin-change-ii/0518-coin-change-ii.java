class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][]dp=new int[n+1][amount+1];
        for(int[]row:dp){
        Arrays.fill(row,-1);
        }
        return helper(n-1,amount,coins,dp);
    }
    static int helper(int i,int amount,int[]coins,int[][]dp){
        int n=coins.length;
        if(i==0){
            if(amount%coins[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int notTake=helper(i-1,amount,coins,dp);
        int Take=0;
        if(coins[i]<=amount){
         Take= helper(i,amount-coins[i],coins,dp);
        }
        dp[i][amount]= (notTake+Take);
        return dp[i][amount];
    }
}