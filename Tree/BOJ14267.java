import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ14267 {
    static int n, m;
    static int[] applauseInfo, answer;
    static List<Integer>[] tree;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // set n, m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int child = 1; child <= n; child++) {
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1) continue;

            tree[parent].add(child);
        }

        // set applauseInfo
        applauseInfo = new int[n + 1];
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            applauseInfo[vertex] += amount;
        }

        //
        answer = new int[n+1];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setApplauseInfo(1, 0);

        // print answer
        for(int i = 1; i <= n; i++)
            System.out.print(answer[i] + " ");
    }

    private static void setApplauseInfo(int vertex, int amount){
        answer[vertex] = amount;

        for(int i : tree[vertex]){
            setApplauseInfo(i, amount + applauseInfo[i]);
        }
    }
}
