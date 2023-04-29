import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {
    private static List<Integer>[] graph;
    private static int[] hackingCount;
    private static boolean[] isVisited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n ,m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        hackingCount = new int[n + 1];

        // init graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // set graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode].add(endNode);
        }
    }

    private static void bfs(int startNode) {
        isVisited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        isVisited[startNode] = true;

        while (!queue.isEmpty()) {
            int thisNode = queue.poll();

            for (int adjacency : graph[thisNode]) {
                if (!isVisited[adjacency]) {
                    isVisited[adjacency] = true;
                    queue.add(adjacency);
                    hackingCount[adjacency]++;
                }
            }
        }
    }

    private static void printAnswer() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, hackingCount[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (hackingCount[i] == max)
                System.out.print(i + " ");
        }
    }
}
