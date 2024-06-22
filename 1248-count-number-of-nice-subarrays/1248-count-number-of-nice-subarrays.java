class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public int atMostK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int result = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1) {
                k--;
            }

            while (k < 0) {
                if (nums[left] % 2 == 1) {
                    k++;
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}