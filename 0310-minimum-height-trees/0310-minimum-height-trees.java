class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> adj=new HashMap<>() ;
        int ind[] = new int[n];
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            ind[edges[i][0]]++;
            ind[edges[i][1]]++;
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<ind.length;i++) {
            if(ind[i] == 1) {
                queue.add(i);
            }
        }

        int processed = 0;
        while(n - processed > 2) {
            int size = queue.size();
            processed += size;
            for(int i=0;i<size;i++) {
                int poll = queue.poll();
                for(int ad: adj.get(poll)) {
                    if(--ind[ad] == 1) {
                        queue.add(ad);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList();
        if (n == 1) {
            list.add(0);
            return list;
        }
        list.addAll(queue);
        return list;
    }
}