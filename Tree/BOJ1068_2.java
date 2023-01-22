import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1068_2 {
    static int n, target, root;
    static List<Integer>[] graph;
    static int[] leaf;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new List[n];
        for(int i = 0 ; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        leaf = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int parentNum = Integer.parseInt(st.nextToken());
            if(parentNum == -1){
                root = i;
                continue;
            }

            graph[parentNum].add(i);
        }

        target = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        if(target == root){
            System.out.println(0);
            return;
        }

        // disconnect target
        for(int i = 0 ; i < n; i++){
            if(graph[i].contains(target)){
                graph[i].remove(graph[i].indexOf(target));
            }
        }

        dfs(root);

        // answer print
        System.out.println(leaf[root]);
    }

    private static void dfs(int node){
        if(graph[node].isEmpty()){
            leaf[node] = 1;
            return;
        }

        for(int i : graph[node]){
            dfs(i);
            leaf[node] += leaf[i];
        }
    }

}
