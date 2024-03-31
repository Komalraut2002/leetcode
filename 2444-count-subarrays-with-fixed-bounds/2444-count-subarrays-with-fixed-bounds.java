class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        int l=-1;
        int r=0;
        int maxi=-1,mini=-1;
        long count=0;
        while(r<n){
            if(nums[r]>maxK || nums[r]<minK){
                maxi=r;
                mini=r;
                l=r;
            }
            mini=nums[r]==minK?r:mini;
            maxi=nums[r]==maxK?r:maxi;
            count+=Math.min(maxi,mini)-l;
            r++;
        }
        return count;
    }
}