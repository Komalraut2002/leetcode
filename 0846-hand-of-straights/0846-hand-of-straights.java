class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n<groupSize || n%groupSize!=0){
            return false;
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int it:hand){
            minHeap.add(it);
        }
        while(!minHeap.isEmpty()){
            int head = minHeap.poll();
            for(int i=1; i<groupSize; i++)
                if(!minHeap.remove(head+i)) return false;
        }
        return true;
    }
}