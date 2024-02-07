class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int [] ans=new int[numCourses];
        int [] arr={};
        int [] indegree=new int [numCourses];
        Queue<Integer> q=new LinkedList<>();
        int cnt=0;
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int dependent = prerequisites[i][0];
            int subject = prerequisites[i][1];
            indegree[dependent]++;
            adj.get(subject).add(dependent);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front=q.poll();
            ans[cnt++]=front;
            for(int it:adj.get(front)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

        }

        return cnt==numCourses?ans:arr;
    }
}
