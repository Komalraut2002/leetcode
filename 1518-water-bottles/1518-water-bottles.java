class Solution {
    public int numWaterBottles(int b, int e) {
        int ans=0;
        int rem=0;
        while(b>0){
            ans+=b;
            rem+=b;
            b=rem/e;
            rem%=e;
        }
        return ans;
    }
}