import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Queue;
        import java.util.StringTokenizer;
        import java.util.PriorityQueue;

public class BOJ1916 {
    /**
     * 사실 제목만 봐도 BFS 혹은 Dijkstra 확인 가능
     *
     */
    static class Edge {
        int toVertex;
        int weight;

        public Edge(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }

//        @Override
//        public String toString(){
//            return "toVertex : " + toVertex + " // weight : " + weight;
//        }
    }

    static class Info implements Comparable<Info> {
        int idx;
        int startToIdxWeight;

        public Info(int idx, int startToIdxWeight) {
            this.idx = idx;
            this.startToIdxWeight = startToIdxWeight;
        }

        @Override
        public int compareTo(Info o) {
            return this.startToIdxWeight - o.startToIdxWeight;
        }
    }

    static int n, m, start, end;
    static int[] distance;
    static List<Edge> graph[];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // set distance
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        // set start, end
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set distance by dijkstra
        shortestDijkstra();

        // print answer
        System.out.println(distance[end]);
    }

    private static void shortestDijkstra(){
        Queue<Info> queue = new PriorityQueue<>();

        // init startVertex
        distance[start] = 0;
        queue.add(new Info(start, 0));

        // dijkstra
        while(!queue.isEmpty()){
            Info thisVertex = queue.poll();

            // check validation (distance array에 저장되어 있는 값보다 크면 검사할 필요X)
            if(distance[thisVertex.idx] < thisVertex.startToIdxWeight) continue;

            // update (다음 Vertex에 대해서 distance array에 저장되어 있는 값보다 작으면 갱신)
            for(Edge adjacency : graph[thisVertex.idx]){
                if(distance[adjacency.toVertex] <= thisVertex.startToIdxWeight + adjacency.weight) continue;

                distance[adjacency.toVertex] = thisVertex.startToIdxWeight + adjacency.weight;
                queue.add(new Info(adjacency.toVertex, distance[adjacency.toVertex]));
            }
        }
    }
}
