class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        if (n == 0 || n == 1) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
}