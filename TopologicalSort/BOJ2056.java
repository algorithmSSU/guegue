import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2056 {
    static int n;
    static int[] now, timeSum, inDegree;
    static List<Integer>[] graph;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //
        n = Integer.parseInt(br.readLine());

        //
        now = new int[n + 1];
        timeSum = new int[n + 1];
        inDegree = new int[n + 1];

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            // set now array
            int time = Integer.parseInt(st.nextToken());
            now[i] = time;

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int parent = Integer.parseInt(st.nextToken());
                graph[parent].add(i);
                inDegree[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        topologicalSorting();

        // print answer
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (max < timeSum[i])
                max = timeSum[i];
        }
        System.out.println(max);
    }

    private static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();

        // set init
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                timeSum[i] = now[i];
            }
        }

        while (!queue.isEmpty()) {
            int thisVertex = queue.poll();

            for (int adjacency : graph[thisVertex]) {
                inDegree[adjacency]--;
                timeSum[adjacency] = Math.max(timeSum[adjacency], timeSum[thisVertex] + now[adjacency]);

                if (inDegree[adjacency] == 0) {
                    queue.add(adjacency);
                }
            }
        }
    }
}
