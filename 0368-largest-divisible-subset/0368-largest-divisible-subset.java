import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        if (n == 0) {
            return ans;
        }

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int endIndex = 0;
        int maxSubsetLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;

                    if (dp[i] > maxSubsetLength) {
                        maxSubsetLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        int currentLength = maxSubsetLength;
        int currentNumber = nums[endIndex];

        for (int i = endIndex; i >= 0; i--) {
            if (currentNumber % nums[i] == 0 && dp[i] == currentLength) {
                ans.add(nums[i]);
                currentNumber = nums[i];
                currentLength--;
            }
        }

        return ans;
    }
}
