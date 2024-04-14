class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        int sum=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy==0){
                    sum=Math.max(0+dp[i+1][0],-prices[i]+dp[i+1][1]);
                }
                else{
                    sum=Math.max(0+dp[i+1][1],prices[i]+dp[i+1][0]);
                }
                dp[i][buy]=sum;
            }
        }
        return dp[0][0];
    }
}