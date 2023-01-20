import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
    static int n, m;
    static List<Integer>[] graph;
    static int[][] kevinNum;
    static boolean[] visited;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        kevinNum = new int[n + 1][n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());

            graph[friend1].add(friend2);
            graph[friend2].add(friend1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // bfs
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            kevinNum[i] = bfs(i);
        }

        // set answer
        int kevinMinNum = Integer.MAX_VALUE;
        int kevinMinVertex = -1;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                sum += kevinNum[i][j];
            }

            if(sum < kevinMinNum){
                kevinMinNum = sum;
                kevinMinVertex = i;
            }
        }

        // print answer
        System.out.println(kevinMinVertex);
    }

    private static int[] bfs(int vertex) {
        int[] answer = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while(!queue.isEmpty()){
            int thisVertex = queue.poll();

            for(int i : graph[thisVertex]){
                if(!visited[i]){
                    answer[i] = answer[thisVertex] + 1;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return answer;
    }

    private static void printArray(int[][] array){
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0 ; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[] array){
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
