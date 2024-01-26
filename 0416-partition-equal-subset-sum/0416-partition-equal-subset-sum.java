class Solution {
    boolean helper(int i,int k,int[]nums,int[][]dp){
        if(i==0){
            return k == nums[0]?true:false;
        }
        if(k==0){
            return true;
        }
        if(dp[i][k] != -1){
            return dp[i][k] == 0 ? false : true;
        }
        
        boolean notTake=helper(i-1,k,nums,dp);
        boolean take=false;
        if(k>=nums[i]){
            take=helper(i-1,k-nums[i],nums,dp);
        }
        dp[i][k]=(notTake||take)? 1 : 0;

        return notTake||take;
    }
    public boolean canPartition(int[] nums) {
       
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int k=sum/2;
        int [][]dp=new int [n+1][k+1];
        for (int row[] : dp)
                Arrays.fill(row, -1);

        return helper(n-1,k,nums,dp);
    }
}

// memoization t.c=O(N*K)+O(N)
