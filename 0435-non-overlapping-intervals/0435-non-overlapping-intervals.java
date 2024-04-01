class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
        int end=intervals[0][1];
        int count=0;
        for (int i = 1; i < n; i++) {
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            if(currStart<end){
                count++;
                end = Math.min(end, currEnd);
            }
            else{
                end=currEnd;
            }
        }

        return count;
    }
}