import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            int a = asteroids[i];
            
            if (a > 0) {
                asteroids[idx++] = a;
            } else {
                while (idx > 0 && asteroids[idx - 1] > 0 && asteroids[idx - 1] < Math.abs(a)) {
                    idx--;
                }
                if (idx == 0 || asteroids[idx - 1] < 0) {
                    asteroids[idx++] = a;
                } else if (asteroids[idx - 1] + a == 0) {
                    idx--;
                }
            }
        }
        
        return Arrays.copyOf(asteroids, idx);
    }
}
