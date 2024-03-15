class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] suffix=new int[n];
        int[] prefix=new int[n];
        Arrays.fill(suffix,1);
        Arrays.fill(prefix,1);
        for(int i=1;i<n;i++){
            prefix[i]=nums[i-1]*prefix[i-1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }
         for (int i = 0; i < n; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;
    }
}