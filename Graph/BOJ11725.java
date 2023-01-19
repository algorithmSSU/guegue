import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int n;
    static int[] answer;
    static List<Integer>[] graph;
    static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        answer = new int[n+1];
        visited = new boolean[n+1];
        graph = new List[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        dfs(1);

        // answer print
        for(int i = 2 ; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int vertex){
        visited[vertex] = true;

        for(int i : graph[vertex]){
            if(!visited[i]){
                answer[i] = vertex;
                dfs(i);
            }
        }
    }
}
