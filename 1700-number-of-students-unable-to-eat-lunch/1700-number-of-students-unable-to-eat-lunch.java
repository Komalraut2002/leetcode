class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countZero = 0;
        int countOne = 0;
        for (int st : students) {
            if (st == 0) {
                countZero++;
            } else {
                countOne++;
            }
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (countZero == 0){
                    break;
                }
                countZero--;
            }
            else if(sandwiches[i] == 1){
                if(countOne==0){
                    break;
                }
                countOne--;
            }
        }
        return countZero + countOne;
    }
}