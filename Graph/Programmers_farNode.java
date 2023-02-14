import java.util.*;

class Programmers_farNode {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int[] length;

    private void input(int n, int[][] edges){
        length = new int[n+1];
        visited = new boolean[n+1];

        // set graph
        graph = new List[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }

    public int solution(int n, int[][] edge) {
        input(n, edge);

        // set length
        setLength(1);

        // find maxLength
        int maxLength = 0;
        for(int i : length)
            maxLength = Math.max(maxLength, i);

        // find count
        int count = 0;
        for(int i : length)
            if(i == maxLength) count++;

        // return
        return count;
    }

    private void setLength(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()){
            int thisNode = queue.poll();

            for(int i : graph[thisNode]){
                if(!visited[i]){
                    length[i] = length[thisNode] + 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}




/*

 */