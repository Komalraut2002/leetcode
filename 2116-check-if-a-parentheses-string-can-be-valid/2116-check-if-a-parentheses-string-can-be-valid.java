class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                min--;
                max++;     
            } else {
                if(s.charAt(i) == '(') {
                    min++;
                    max++;
                } else {
                    min--;
                    max--;
                }
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }
}