class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) return "0";
        
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < n) {
            char curr = num.charAt(i);
            while (!st.isEmpty() && curr < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            st.push(curr);
            i++;
        }
        
        while (k > 0) {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        int j = sb.length() - 1;
        while (j >= 0 && sb.charAt(j) == '0') {
            sb.deleteCharAt(j);
            j--;
        }
        
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
