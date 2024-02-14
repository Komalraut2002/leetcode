class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp=new int [n][n+1];
        for(int [] it:dp){
            Arrays.fill(it,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public int helper(int[]nums,int i,int j,int [][] dp){
        int n=nums.length;
        if(i==n){
            return 0;
        }
        if(dp[i][j+1]!=-1){
            return dp[i][j+1];
        }
        dp[i][j+1]=0+helper(nums,i+1,j,dp);
        
        if(j==-1 || nums[i]>nums[j]){
             dp[i][j+1] = Math.max(dp[i][j+1],1+helper(nums,i+1,i,dp));
        }
             
        return dp[i][j+1];
    }
}
//j==previous