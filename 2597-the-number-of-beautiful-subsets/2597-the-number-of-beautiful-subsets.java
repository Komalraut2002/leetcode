class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); 
        int[][] dp = new int[n + 1][1 << n]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums, k, 0, 0, dp) - 1; 
    }

    private int helper(int[] nums, int k, int index, int mask, int[][] dp) {
        if (index == nums.length) {
            return 1;
        }

        if (dp[index][mask] != -1) {
            return dp[index][mask];
        }

        int notTake = helper(nums, k, index + 1, mask, dp); 

        int take = 0;
        boolean canTake = true;
        for (int j = 0; j < index; j++) {
            if ((mask & (1 << j)) != 0 && Math.abs(nums[index] - nums[j]) == k) {
                canTake = false;
                break;
            }
        }

        if (canTake) {
            take = helper(nums, k, index + 1, mask | (1 << index), dp);  
        }

        dp[index][mask] = notTake + take;  
        return dp[index][mask];
    }
}
