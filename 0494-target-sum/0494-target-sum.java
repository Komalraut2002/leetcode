class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum = Arrays.stream(nums).sum();
        int offset=sum; 
        int range = 2 * sum + 1;
        int [][]dp=new int [n+1][range];
        for(int []row:dp){
                Arrays.fill(row,-1);
        }
        return helper(0,nums,target,dp,offset,offset);
    }
    static int helper(int i,int[]nums,int target,int [][] dp,int j,int offset){
       int n=nums.length;
       if (i == n) {
            return (j - offset == target) ? 1 : 0;
        }
        if(i>n-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int add=helper(i+1,nums,target,dp,j+nums[i],offset);
        int sub=helper(i+1,nums,target,dp,j-nums[i],offset);

        dp[i][j]= (add+sub);
        return dp[i][j];
    }
}
// memoization;