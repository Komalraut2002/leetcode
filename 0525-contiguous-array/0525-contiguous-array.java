class Solution {
    public int findMaxLength(int[] nums) {
     int maxLen = 0;
        int sum = 0;

       
        Map<Integer, Integer> sumIndices = new HashMap<>();
        sumIndices.put(0, -1); 

        for (int i = 0; i < nums.length; i++) {
           
            sum += (nums[i] == 0) ? -1 : 1;

            if (sumIndices.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndices.get(sum));
            } else {
                sumIndices.put(sum, i);
            }
        }

        return maxLen;
    }
}