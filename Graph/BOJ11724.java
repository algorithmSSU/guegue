import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int n, m, answerCount;
    static List<Integer>[] graph;
    static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // set n, m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // initialize graph
        visited = new boolean[n+1];
        graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // set graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            // bidirectional connection
            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }

        //
        answerCount = 0;
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answerCount++;
            }
        }

        System.out.println(answerCount);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for (int i : graph[vertex]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }


}
