import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    private static int[] array;
    private static int n, m;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void init() throws IOException {
        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init array
        array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }
    }

    private static void process() throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isUnionOperation(operation)) {
                union(a, b);
            } else if (isSameSetOperation(operation)) {
                isSameSet(a, b);
            } else {
                System.out.println("Error! : wrong operation");
            }
        }
    }

    private static boolean isUnionOperation(int num) {
        return (num == 0);
    }

    private static boolean isSameSetOperation(int num) {
        return (num == 1);
    }

    private static void union(int a, int b) {
        if (a == b)
            return;

        int rootA = dfs(a);
        int rootB = dfs(b);

        if(rootA != rootB){
            array[rootB] = rootA;
        }
    }

    private static void isSameSet(int a, int b) {
        int rootA = dfs(a);
        int rootB = dfs(b);

        if (rootA == rootB) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int dfs(int num) {
        if (num == array[num]) {
            return num;
        }

        return array[num] = dfs(array[num]);
    }
}
