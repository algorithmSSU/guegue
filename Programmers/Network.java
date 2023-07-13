import java.util.*;

public class Network {
    private boolean[] isVisited;
    private List<Integer>[] graph;

    public int solution(int n, int[][] computers) {
        init(n, computers);

        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(!isVisited[i]){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int now){
        isVisited[now] = true;

        for(int adjacency : graph[now]){
            if(!isVisited[adjacency]){
                dfs(adjacency);
            }
        }
    }

    private void init(int n, int[][] computers){
        // set graph
        graph = new List[n];
        for(int i = 0 ; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < computers.length; i++){
            int[] computer = computers[i];
            for(int j = 0; j < computer.length; j++){
                if(i == j || computer[j] == 0) continue;
                graph[i].add(j);
            }
        }

        // init isVisited
        isVisited = new boolean[n];

    }
}
