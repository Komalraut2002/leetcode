class Solution {
    
    static int helper(int i,int amount,int[]coins,int [][]dp){
        if(i==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
                }
                else{
                    return (int) Math.pow(10, 9);
                }
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int notTake=0+helper(i-1,amount,coins,dp);
        int take=(int) Math.pow(10, 9);
        if(coins[i]<=amount){
            take=1+helper(i,amount-coins[i],coins,dp);
        }
        dp[i][amount]= Math.min(take,notTake);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;
        int [][]dp=new int[n+1][amount+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int ans= helper(n-1,amount,coins,dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}

// Time Complexity: O(N*T)

// Reason: There are N*T states therefore at max ‘N*T’ new problems will be solved.

// Space Complexity: O(N*T) + O(N)

// Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*T)).