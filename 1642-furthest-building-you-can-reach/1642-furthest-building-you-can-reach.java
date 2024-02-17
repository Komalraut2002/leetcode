

class Solution {
    public int furthestBuilding(int[] h, int bricks, int l) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        
        int i = 0, diff = 0;
        for (i = 0; i < h.length - 1; i++) {
            diff = h[i + 1] - h[i];
            
            if (diff <= 0) {
                continue;
            }

            bricks -= diff;
            p.offer(diff);

            if (bricks < 0) {
                bricks += p.poll();
                l--;
            }

            if (l < 0) {
                break;
            }
        }
        
        return i;
    }
}
