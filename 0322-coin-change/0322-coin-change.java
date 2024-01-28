class Solution {
    public int coinChange(int[] coins, int amount) { 
        int n=coins.length;
        int [][]dp=new int[n+1][amount+1];
        for(int tar=0;tar<=amount;tar++){
            if(tar%coins[0]==0){
                dp[0][tar]= tar/coins[0];
            }
            else{
                dp[0][tar]=(int) Math.pow(10, 9);
            }
}
        for(int i=1;i<n;i++){
            for(int tar=0;tar<=amount;tar++){
                int notTake=0+dp[i-1][tar];
                int take=(int) Math.pow(10, 9);
                  if(coins[i]<=tar){
                        take=1+dp[i][tar-coins[i]];
                   }
                    dp[i][tar]= Math.min(take,notTake);
               }
        }
        int ans=dp[n-1][amount];
        if (ans >=(int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}

// Time Complexity: O(N*T)

// Reason: There are N*T states therefore at max ‘N*T’ new problems will be solved.

// Space Complexity: O(N*T)

// Reason:  2D array ( O(N*T)).