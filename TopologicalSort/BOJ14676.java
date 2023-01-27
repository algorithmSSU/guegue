import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ14676 {
    static int n, m, k;
    static boolean answer;
    static int[] inDegree, constructions, available;
    static int[][] games;
    static List<Integer>[] graph;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // set others
        inDegree = new int[n + 1];
        constructions = new int[n + 1];
        available = new int[n + 1];

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);

            inDegree[child]++;
        }

        // set games
        games = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int game = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            games[i][0] = game;
            games[i][1] = vertex;
        }

        // set answer
        answer = true;
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set available Array
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                available[i] = 1;
            }
            inDegree[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            // 종료 조건
            if (!answer) break;
            doGame(games[i][0], games[i][1]);
        }

        // 한 건물이 최대 3개의 영향이 미치는 지 검사
        for (int i = 1; i <= n; i++) {
            if(graph[i].size() > 3)
                answer = false;
        }

        System.out.println((answer) ? "King-God-Emperor" : "Lier!");
    }

    private static void doGame(int game, int vertex) {
        // 건설
        if (game == 1) {
            // 건설 불가능한 vertex인 경우 return
            if (available[vertex] <= 0) {
                answer = false;
                return;
            }

            // 건설 가능한 vertex인 경우
            constructions[vertex]++;

            // 건설 가능해진 다음 vertex setting
            for (int i : graph[vertex])
                available[i]++;
        }
        // 파괴
        else if (game == 2) {
            // 파괴 불가능한 vertex인 경우 (== 만든 적 없는 건물인 경우)
            if (constructions[vertex] <= 0) {
                answer = false;
                return;
            }

            constructions[vertex]--;

            // 파괴되어 건물이 아예 없는 경우
            if(constructions[vertex] == 0){
                for(int i : graph[vertex])
                    available[i]--;
            }
        }
    }
}