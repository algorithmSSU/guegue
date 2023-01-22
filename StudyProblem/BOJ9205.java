import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] array;
    static List<Integer>[] graph;
    static List<Boolean> answerList = new ArrayList<>();
    static boolean answer;
    static boolean[] visited;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        array = new int[n + 2][2];

        // initialize graph
        graph = new List[n + 2];
        for (int i = 0; i < n + 2; i++) {
            graph[i] = new ArrayList<>();
        }
        // set graph
        for (int i = 0; i < n + 2; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }


    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            input();

            process();
        }

        // answer print
        for (boolean answer : answerList) {
            System.out.println((answer) ? "happy" : "sad");
        }
    }

    private static void process() {
        // vertex connecting
        for (int i = 0; i < n + 2; i++) {
            connect(i);
        }

        // dfs
        visited = new boolean[n+2];
        answer = false;
        dfs(0);
        answerList.add(answer);
    }

    private static void dfs(int vertex) {
        if(vertex == array.length-1){
            answer = true;
            return;
        }
        visited[vertex] = true;

        for(int i : graph[vertex]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    private static void connect(int vertex) {
        int thisXIdx = array[vertex][0];
        int thisYIdx = array[vertex][1];

        for (int i = 0; i < array.length; i++) {
            if (i == vertex) continue;
            if (graph[i].contains(vertex)) continue; // already connected


            int xIdx = array[i][0];
            int yIdx = array[i][1];
            int distance = Math.abs(xIdx - thisXIdx) + Math.abs(yIdx - thisYIdx);

            if (distance <= 1000) {
                // bidirectional connection
                graph[vertex].add(i);
                graph[i].add(vertex);
            }
        }
    }


    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
