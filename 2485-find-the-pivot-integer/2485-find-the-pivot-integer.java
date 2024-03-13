class Solution {
    public int pivotInteger(int n) {
        int x=n*(n+1)/2;
        int y=(int)Math.sqrt(x);
        if(y*y==x){return y;}
        return -1;
        
    }
}