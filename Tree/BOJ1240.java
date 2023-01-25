import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ1240 {
    static int n, m;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[][] target;
    static int[][] weights = new int[1001][1001];
    static List<Integer> answer = new ArrayList<>();


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // set initialize
            weights[node1][node2] = weight;
            weights[node2][node1] = weight;

            // tree
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        target = new int[m][2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            target[i][0] = Integer.parseInt(st.nextToken());
            target[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for(int i = 0; i < m; i++){
            visited = new boolean[n+1];
            dfs(target[i][0], target[i][1], 0);
        }

        // print answer
        for(int i : answer)
            System.out.println(i);
    }

    private static void dfs(int vertex, int target, int weightSum){
        if(vertex == target){
            answer.add(weightSum);
            return;
        }

        visited[vertex] = true;

        for(int i : tree[vertex]){
            if(!visited[i]){
                dfs(i, target, weightSum + weights[vertex][i]);
            }
        }
    }
}