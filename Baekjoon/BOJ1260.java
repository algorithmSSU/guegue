import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    private static List<Integer>[] graph;
    private static boolean[] isVisited;
    private static int n, m, start;

    public static void main(String[] args) throws IOException {
        init();

        dfs(start);

        // init again
        isVisited = new boolean[n+1];
        System.out.println();

        bfs();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m , start
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // bidirectional
            graph[start].add(end);
            graph[end].add(start);
        }

        // graph sorting
        // about '정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문'
        for(int i = 1; i <= n; i++){
            Collections.sort(graph[i]);
        }

        // set isVisited
        isVisited = new boolean[n + 1];
    }

    private static void dfs(int idx){
        System.out.print(idx + " ");

        isVisited[idx] = true;

        for(int i : graph[idx]){
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()){
            int thisVertex = queue.poll();
            System.out.print(thisVertex + " ");

            for(int adjacent : graph[thisVertex]){
                if(!isVisited[adjacent]){
                    isVisited[adjacent]= true;
                    queue.add(adjacent);
                }
            }
        }
    }
}
