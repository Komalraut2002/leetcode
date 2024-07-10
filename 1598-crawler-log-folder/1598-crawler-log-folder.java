class Solution {
    public int minOperations(String[] logs) {
        int ans=0;
        for(String log:logs){
            ans+=check(log,ans);
        }
        return ans;
    }
    public int check(String log,int ans){
        return log.charAt(1) == '.' ? ans == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 : 1;
    }
}