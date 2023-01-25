import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ15681 {
    /**
     * 1. set input
     * 2. vertex 별로 가지는 본인 포함 자식 vertex 개수 저장
     * 3. query Array를 loop 돌며 print
     */

    static int n, root, queryCnt;
    static int[] childCntArray, queryArray;
    static boolean[] visited;
    static List<Integer>[] tree;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //
        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        queryCnt = Integer.parseInt(st.nextToken());

        //
        childCntArray = new int[n + 1];
        visited = new boolean[n + 1];
        queryArray = new int[queryCnt];

        // set childCntArray
        for(int i = 0 ; i < n+1; i++){
            childCntArray[i] = 1;
        }

        // set tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            // bidirectional
            tree[vertex1].add(vertex2);
            tree[vertex2].add(vertex1);
        }

        // set query array
        for (int i = 0; i < queryCnt; i++) {
            queryArray[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setChildCntArray(root);

        // print answer
        for (int i : queryArray)
            System.out.println(childCntArray[i]);
    }

    private static void setChildCntArray(int vertex) {
        visited[vertex] = true;

        boolean isLeaf = true;
        for (int i : tree[vertex]) {
            if (!visited[i]) {
                // 방문할 노드가 있는 경우 leaf 아님
                isLeaf = false;

                setChildCntArray(i);
                childCntArray[vertex] += childCntArray[i];
            }
        }

        if (isLeaf) childCntArray[vertex] = 1;
    }
}