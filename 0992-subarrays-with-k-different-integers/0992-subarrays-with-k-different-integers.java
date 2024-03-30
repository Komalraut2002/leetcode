class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int max=atmostK(nums,k);
        int min=atmostK(nums,k-1);
        return max-min;
    }
    public int atmostK(int[] nums,int x){
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int ans=0;
        int n=nums.length;
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>x){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            ans+=r-l+1;
            r++;
        }
        return ans;
    }
}