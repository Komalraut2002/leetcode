class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int ans = -1;
        if ((long) n < (long) m * k) {
            return ans;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int fb = 0;
            int count = 0;
            for (int i : bloomDay) {
                if (i <= mid) {
                    fb++;
                    if (fb == k) {
                        count++;
                        fb = 0;
                    }
                }
                else{
                   fb=0;
                }
            }
            if(count>=m){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}