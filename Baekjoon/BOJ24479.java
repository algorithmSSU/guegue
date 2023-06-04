import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24479 {
    private static int n, m, r, count;
    private static List<Integer>[] graph;
    private static boolean[] isVisited;
    private static int[] visitSequence;

    public static void main(String[] args) throws IOException {
        init();

        // dfs
        isVisited[r] = true;
        dfs(r);

        // print answer
        for (int i = 1; i <= n; i++) {
            System.out.println(visitSequence[i]);
        }
    }

    private static void dfs(int idx) {
        visitSequence[idx] = count++;

        for (int adjacency : graph[idx]) {
            if (!isVisited[adjacency]) {
                isVisited[adjacency] = true;
                dfs(adjacency);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m, r
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // init isVisited
        isVisited = new boolean[n + 1];

        // init visitSequence
        visitSequence = new int[n + 1];

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // sort asc
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // init
        count = 1;
    }
}
