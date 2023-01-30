import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ2252 {
    /**
     * Topological Sorting
     * 특정 작업을 위해서 선행되어야 하는 작업이 있을 때
     * ex) install package
     */
    static int n, m;
    static List<Integer>[] graph;
    static List<Integer> answer;
    static int[] inDegree;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inDegree = new int[n + 1];

        // set tree
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent].add(child);
            inDegree[child]++;
        }

        answer = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // 위상 정렬
        topologicalSorting();

        // print answer
        for (int i : answer)
            System.out.print(i + " ");
    }

    private static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();

        // add start vertex
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int thisVertex = queue.poll();
            answer.add(thisVertex);

            for (int i : graph[thisVertex]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}