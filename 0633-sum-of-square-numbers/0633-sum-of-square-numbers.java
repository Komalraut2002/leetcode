class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0){
            return true;
        }
        int i=0;
        int j=(int) Math.sqrt(c);

        while(i<=j){
            long cnt = (long) i * i + (long) j * j;
            if(cnt==c){
                return true;
            }
            else if(cnt<c){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}