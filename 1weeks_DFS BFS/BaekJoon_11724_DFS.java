import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_11724_DFS {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // initialize lists and visited
        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1;i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //bidirection
            lists[u].add(v);
            lists[v].add(u);
        }

        // 방문 안되어 있으면 dfs
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);

    }

    private static void dfs(int idx) {
        //방문 되어 있으면 return
        if(visited[idx])
            return;

        //방문 처리
        visited[idx] = true;

        //인접리스트들 방문 안되어 있으면 dfs
        for(int i : lists[idx]){
            if(!visited[i])
                dfs(i);
        }
    }

}

/*
6 5
1 2
2 5
5 1
3 4
4 6
 */

/*
    static ArrayList<Integer>[] lists;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // set N, M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // initialize lists, isVisited
        lists = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        for(int i = 1; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }


        // set adjacent lists
        for(int i = 0; i < M; i++){
            // set connected element
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // because of bidirection
            lists[u].add(v);
            lists[v].add(u);
        }

        int count = 0;
        for(int i = 1; i < N+1; i++){
            if(!isVisited[i]){
                count++;
                dfs(i);
            }

        }

        System.out.println("count is " + count);
    }

    static void dfs(int idx){
        if(isVisited[idx])
            return;

        isVisited[idx] = true;

        for(int i : lists[idx]){
            if(!isVisited[i]) {
                System.out.println(i);
                dfs(i);
            }
        }
        System.out.println();
    }
 */