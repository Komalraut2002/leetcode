class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0){
            return 0;
        }
        int count=0;
        int n=nums.length;
        int i=0;
        int j=0;
        int product=1;
        while(j < n && i < n){
           product*=nums[j];
           while(product>=k && i <= j){
            product/=nums[i++];
           }
           count+=1+(j-i);
           j++;
        }
        return count;
    }
}