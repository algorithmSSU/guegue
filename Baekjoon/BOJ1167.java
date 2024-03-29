import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167 {
    static class Edge {
        int toVertex;
        int weight;

        public Edge(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }

    private static boolean[] isVisited;
    private static List<Edge>[] tree;
    private static List<Integer> candidateVertex;
    private static int n, end, answer;

    public static void main(String[] args) throws IOException {
        init();

        setTreeDiameter();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // set tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int parentNode = Integer.parseInt(st.nextToken());
            while(true){
                int thisNum = Integer.parseInt(st.nextToken());
                if(thisNum == -1)
                    break;

                int childNode = thisNum;
                int weight = Integer.parseInt(st.nextToken());

                // bidirectional
                tree[parentNode].add(new Edge(childNode, weight));
            }
        }

        // init isVisited
        isVisited = new boolean[n+1];

        // init answer
        answer = Integer.MIN_VALUE;

        //
        end = -1;
    }

    private static void setTreeDiameter(){
        dfs(1, 0);
        dfs(end, 0);
    }

    private static void dfs(int idx, int weightSum){
        if(weightSum > answer){
            answer = weightSum;
            end = idx;
        }
        isVisited[idx] = true;

        for(Edge adjacency : tree[idx]){
            if(!isVisited[adjacency.toVertex]){
                dfs(adjacency.toVertex, weightSum + adjacency.weight);
            }
        }

        isVisited[idx] = false;
    }
}


/**
 * 트리의 지름을 구하는 공식
 * 1. 임의의 노드 X를 선택하고 X로부터 가장 먼 거리의 노드 V를 찾는다.
 * 2. V로부터 가장 먼 거리의 노드 T를 찾는다.
 * 3. V와 T 사이의 거리가 곧 트리의 지름이다.
 */