import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[m+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
