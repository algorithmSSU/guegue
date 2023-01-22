import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    static int n, target, root, answer;
    static List<Integer>[] tree;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // set tree
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parentNode = Integer.parseInt(st.nextToken());

            // check root
            if (parentNode == -1) {
                root = i;
                continue;
            }

            // set tree
            tree[parentNode].add(i);
        }

        target = Integer.parseInt(br.readLine());

        answer = 0;
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        if(root == target){
            System.out.println(0);
            return;
        }
        dfs(root);

        // print answer
        System.out.println(answer);
    }

    private static void dfs(int node){
        boolean isLeaf = true;

        for(int i : tree[node]){
            // disconnected node
            if(i == target){
                continue;
            }
            isLeaf = false;
            dfs(i);
        }

        if(isLeaf) answer++;
    }
}
