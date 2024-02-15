class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
        int one=cost[i]+dp[i-1];
        int two=cost[i]+dp[i-2];
        dp[i]=Math.min(one,two);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}