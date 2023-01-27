import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ9470 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m, p;
    static int[] inDegree, strahler;
    static boolean[] plusOne;
    static List<Integer>[] graph;

    private static void input() throws IOException {


        st = new StringTokenizer(br.readLine());
        sb.append(st.nextToken()).append(" "); // 테스트 케이스 번호
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        inDegree = new int[m + 1];
        strahler = new int[m + 1];
        plusOne = new boolean[m+1];


        graph = new List[m + 1];
        for (int i = 1; i <= m; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent].add(child);
            inDegree[child]++;
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input();

            process();
        }

        // print answer
        System.out.println(sb.toString());
    }

    private static void process() {
        topologicalSorting();
    }

    private static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();

        // set init
        for (int i = 1; i <= m; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
                strahler[i] = 1;
                plusOne[i] = true;
            }
        }

        //
        while(!queue.isEmpty()){
            int thisVertex = queue.poll();

            for(int i : graph[thisVertex]){
                inDegree[i]--;

                // update strahler
                if(strahler[i] < strahler[thisVertex])
                    strahler[i] = strahler[thisVertex];
                else if(!plusOne[i] && strahler[i] == strahler[thisVertex]){
                    strahler[i]++;
                    plusOne[i] = true;
                }

                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }

        // answer append
        sb.append(strahler[m]).append("\n");
    }
}
