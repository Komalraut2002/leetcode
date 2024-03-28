class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
      
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
             while (map.get(nums[r])> k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            
            maxi = Math.max(r-l+1, maxi);
            r++;
        }
        return maxi;
    }
}
