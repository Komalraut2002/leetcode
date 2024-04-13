class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0)return false;
        int k=sum/2;
        int [][] dp=new int[n][k+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return check(n-1,k,nums,dp);
    }
    public static boolean check(int i,int k,int[]nums,int[][]dp){
        if(k==0)return true;
        if(i==0)return nums[i]==k;
        if(dp[i][k]!=-1)return dp[i][k]==1?true:false;
        boolean not=check(i-1,k,nums,dp);
        boolean take=false;
        if(nums[i]<=k){
            take=check(i-1,k-nums[i],nums,dp);
        }
        dp[i][k]=not||take?1:0;
        return dp[i][k]==1?true:false;
    }
}