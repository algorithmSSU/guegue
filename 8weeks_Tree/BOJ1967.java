import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967 {
    // Node 클래스 생성
    static class Node{
        private int num;
        private int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }

    private static ArrayList<Node>[] arrayLists;
    private static boolean[] isVisted;
    private static int answer;

    public static void main(String[] args) throws IOException {
        // input setting
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // initialize ArrayList
        arrayLists = new ArrayList[n+1];
        for(int i = 1; i < arrayLists.length; i++){
            arrayLists[i] = new ArrayList<Node>();
        }

        // set ArrayList
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            // bidirectional
            arrayLists[parent].add(new Node(child, length));
            arrayLists[child].add(new Node(parent, length));
        }

        // dfs 돌며 제일 긴 값 찾기
        answer = 0;
        for(int i = 1; i < arrayLists.length; i++){
            isVisted = new boolean[n+1];
            isVisted[i] = true;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int num, int length){
        for(Node node : arrayLists[num]){
            if(!isVisted[node.num]){
                isVisted[node.num] = true;
                dfs(node.num, length + node.length);
            }
        }
        if(answer < length)
            answer = length;
    }
}
