import java.util.*;
import java.io.*;

public class BOJ13023 {
    private static List<Integer>[] graph;
    private static boolean[] isVisited;
    private static int n, m;

    private static boolean exist;

    public static void main(String[] args) throws IOException {
        init();

        setAnswer();
        System.out.println(exist ? 1 : 0);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set graph
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        isVisited = new boolean[n];

        exist = false;
    }

    private static void setAnswer() {
        for (int i = 0; i < n; i++) {
            if (!exist && !isVisited[i]) {
                dfs(i, 1);
            }
        }
    }

    private static void dfs(int idx, int depth) {
        if (depth == 5) {
            exist = true;
            return;
        }

        isVisited[idx] = true;

        for (int i : graph[idx]) {
            if (!exist && !isVisited[i]) {
                dfs(i, depth + 1);
            }
        }

        isVisited[idx] = false;
    }
}