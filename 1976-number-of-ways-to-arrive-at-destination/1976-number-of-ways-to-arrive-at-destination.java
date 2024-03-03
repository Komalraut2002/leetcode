class Solution {
    public int countPaths(int n, int[][] roads) {
        int m = roads.length;
        int mod = 1000000000 + 7;
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        ways[0] = 1;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair top = q.poll();
            long dis = top.first;
            int node = top.second;

            for (Pair it : adj.get(node)) {
                long currDist = it.second;
                int currNode = (int)it.first;
                if (dis + currDist < dist[currNode]) {
                    ways[currNode] = ways[node];
                    dist[currNode] = dis + currDist;
                    q.add(new Pair(dis + currDist, currNode));
                } else if (dis + currDist == dist[currNode]) {
                    ways[currNode] = (int) ((ways[currNode] + ways[node]) % mod);
                }
            }
        }
        return ways[n - 1];
    }
}

class Pair {
    long first;
    int second;

    public Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}
