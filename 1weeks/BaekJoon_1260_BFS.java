import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1260_BFS {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];

        for(int i = 1 ; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        for(int i = 1; i < lists.length; i++){
            Collections.sort(lists[i]);
        }


        // dfs
        visited = new boolean[N+1];
        System.out.print(start + " ");
        dfs(start);
        System.out.println();

        visited = new boolean[N+1];
        bfs(start);
    }

    private static void dfs(int start){
        visited[start] = true;

        for(int i : lists[start]){
            if(!visited[i]){
                System.out.print(i + " ");
                dfs(i);
            }

        }
    }



    private static void bfs(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            for(int i : lists[tmp]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
            System.out.print(tmp + " ");
        }
    }
}
