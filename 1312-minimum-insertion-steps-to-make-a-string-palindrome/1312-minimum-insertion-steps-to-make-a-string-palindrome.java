class Solution {
    public int minInsertions(String s) {
       int n=s.length();
        int [][]dp=new int [n+1][n+1];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }
        int ans= helper(0,n-1,s,dp);
        return (n-ans);
        
    }

    static int helper(int start,int end,String s,int[][]dp){
        if(start==end)return 1;

        if(start>end){
            return 0;
        }
        
        if(dp[start][end]!=-1){
            return dp[start][end];
        }

         if(s.charAt(start)== s.charAt(end)){
            dp[start][end] = 2 + helper(start+1,end-1,s,dp);
            return dp[start][end];
        }
        int not=helper(start+1,end,s,dp);
        int right=helper(start,end-1,s,dp);
       
         dp[start][end]= Math.max(not,right);

        return dp[start][end];
    }
    
}