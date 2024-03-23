class Solution {
    public int trap(int[] height) {
        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;
        int l=0;
        int res=0;
        int n=height.length-1;
        while(l<n){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[n]);

          res+=(lmax<rmax)?(lmax-height[l++]):(rmax-height[n--]);

        }
        return res;
    }
}