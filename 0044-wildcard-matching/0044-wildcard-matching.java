class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(s,p,m-1,n-1,dp);
    }
    public boolean helper(String s,String p,int i,int j,int[][]dp){
        if (i < 0 && j < 0) {
            return true;
        } else if (j < 0) {
            return false;
        } else if (i < 0) {
            for (int k = j; k >= 0; k--) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=-1){
            return dp[i][j]==1?true:false;
        }
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
           dp[i][j]=helper(s,p,i-1,j-1,dp)==true?1:0;
           return dp[i][j]==1?true:false;
        }
        else if(p.charAt(j)=='*'){
        dp[i][j]=(helper(s,p,i,j-1,dp)||helper(s,p,i-1,j,dp))==true?1:0;
        return dp[i][j]==1?true:false;
        }
        return false;
    }
}