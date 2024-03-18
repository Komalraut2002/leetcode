class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
        int start=points[0][1];
        int arrow=1;
        for(int i=0;i<points.length;i++){
            if(points[i][0]>start){
                arrow++;
                start=points[i][1];
            }
        }
        return arrow;
    }
}