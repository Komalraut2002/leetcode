class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double ans = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            start = Math.max(start , customers[i][0]);
            start += customers[i][1];
            ans += (start - customers[i][0]);
        }
        ans = ans / n;
        return ans;
    }
}