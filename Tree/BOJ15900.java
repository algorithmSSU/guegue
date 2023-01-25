import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15900 {
    static int n, answerCount;
    static List<Integer>[] graph;
    static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        // set graph
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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

    private static void process() {
        dfs(1, 0);

        // answer print
        System.out.println((answerCount % 2 == 0) ? "No" : "Yes");
    }

    private static void dfs(int vertex, int depth) {
        visited[vertex] = true;

        boolean isLeaf = true;
        for (int i : graph[vertex]) {
            if (!visited[i]) {
                isLeaf = false;
                dfs(i, depth + 1);
            }
        }
        if (isLeaf) answerCount += depth;
    }
}
