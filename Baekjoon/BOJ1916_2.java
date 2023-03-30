import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916_2 {
    static class Edge {
        int nextNodeIdx;
        int weight;

        public Edge(int nextNodeIdx, int weight) {
            this.nextNodeIdx = nextNodeIdx;
            this.weight = weight;
        }
    }

    static class Info implements Comparable<Info>{
        int idx;
        int startToNowNodeWeight;

        public Info(int idx, int startToNowNodeWeight) {
            this.idx = idx;
            this.startToNowNodeWeight = startToNowNodeWeight;
        }

        @Override
        public int compareTo(Info o){
            return this.startToNowNodeWeight - o.startToNowNodeWeight;
        }
    }

    private static List<Edge>[] edges;
    private static int start, targetEnd;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        init();
        setDistance();

        System.out.println(distance[targetEnd]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        distance = new int[n+1];
        for(int i = 1; i <= n; i++)
            distance[i] = Integer.MAX_VALUE;

        edges = new List[n + 1];
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int startNodeIdx = Integer.parseInt(st.nextToken());
            int endNodeIdx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[startNodeIdx].add(new Edge(endNodeIdx, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        targetEnd = Integer.parseInt(st.nextToken());
    }

    private static void setDistance(){
        distance[start] = 0;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start, 0));

        while(!queue.isEmpty()){
            Info thisInfo = queue.poll();

            if(thisInfo.startToNowNodeWeight > distance[thisInfo.idx]) continue;

            for(Edge nextEdge : edges[thisInfo.idx]){
                if(thisInfo.startToNowNodeWeight + nextEdge.weight >= distance[nextEdge.nextNodeIdx]) continue;

                distance[nextEdge.nextNodeIdx] = thisInfo.startToNowNodeWeight + nextEdge.weight;
                queue.add(new Info(nextEdge.nextNodeIdx, distance[nextEdge.nextNodeIdx]));
            }
        }
    }

}
