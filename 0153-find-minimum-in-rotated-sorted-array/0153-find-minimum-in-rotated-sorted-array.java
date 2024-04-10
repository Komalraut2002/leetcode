class Solution {
    public int findMin(int[] nums) {
       int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high) {
              int mid=(low+high)/2;
              if(nums[low]<nums[high]){
                ans=Math.min(ans,nums[low]);
                high=mid-1;
              }
              else if(nums[mid]>nums[high]){
                ans=Math.min(ans,nums[high]);
                low=mid+1;
              }
              else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
              }
        }
        return ans;
    }
}