class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m=nums2.length;
        int n=nums1.length;
        int [] ans=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            int greater=st.isEmpty()?-1:st.peek();
            map.put(nums2[i],greater);
            st.push(nums2[i]);
        }
        System.out.print(map);
        int i=0;
        for(int it:nums1){
            ans[i++]=map.get(it);
        }
        return ans;
    }
}