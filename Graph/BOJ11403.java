import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11403 {
    static int n;
    static int[][] array;
    static List<Integer>[] arrayList;
    static int[][] answerArray;
    static List<Integer> list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arrayList = new List[n];
        answerArray = new int[n][n];
        visited = new boolean[n];

        // initialize
        for(int i = 0 ; i < n; i++){
            arrayList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    arrayList[i].add(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        for(int i = 0 ; i < n; i++){
            list = new ArrayList<>();
            dfs(i);
            for(int idx : list)
                answerArray[i][idx] = 1;
        }

        // print
        printArray(answerArray);
    }

    private static void dfs(int vertex){
        for(int i : arrayList[vertex]){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(i);
                visited[i] = false;
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
