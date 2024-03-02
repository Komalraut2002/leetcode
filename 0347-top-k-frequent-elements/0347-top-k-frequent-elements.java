class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] ans = new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }    
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i:map.keySet()){
            q.add(i);
        }
         for(int i=0; i<k; i++){
            ans[i]=q.poll();
        }
        return ans;
    }
}