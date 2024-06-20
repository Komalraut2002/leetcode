import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0]; 
        }

        int[] ans = new int[n / 2];
        Arrays.sort(changed);
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : changed) {
            if (i % 2 == 0 && map.containsKey(i / 2) && map.get(i / 2) > 0) {
                ans[j++] = i / 2;
                map.put(i / 2, map.get(i / 2) - 1);
                if (map.get(i / 2) == 0) {
                    map.remove(i / 2);
                }
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        return j == n / 2 ? ans : new int[0];
    }
}
