class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        long l=0;
        long r=0;
        long ans=0;
        int count=0;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
           maxi=Math.max(maxi,nums[i]);
        }
        while( l>r || r<n){
           if(nums[(int)r]==maxi){
            count++;
           }
           while(count>=k){
            if(nums[(int)l]==maxi){
                count--;
            }
             l++;
             ans+=n-r;
           }
           r++;
        }
      return ans;
    }
}