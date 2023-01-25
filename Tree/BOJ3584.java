import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static boolean[] ancestor;
    static List<Integer>[] tree;
    static int[] target = new int[2]; // 공통 조상 구할 두 Node

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        // initialize tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // set tree
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[child].add(parent);
        }

        // set 공통조상 구할 두 Node
        st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        // initialize ancestor
        ancestor = new boolean[n+1];
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            input();

            process();
        }
    }

    private static void process() {
        // 첫 번째 노드의 조상들 저장
        dfs(target[0]);

        // 두 번째 노드의 조상으로 올라가면서 처음으로 만나는 첫 번째 노드 조상 만나면 출력 후 return
        dfs(target[1]);
    }

    private static void dfs(int node){
        // 종료조건
        if(ancestor[node]){
            System.out.println(node);
            return;
        }

        // 방문 처리
        ancestor[node] = true;

        // go parent
        for(int i : tree[node]){
            dfs(i);
        }
    }
}
