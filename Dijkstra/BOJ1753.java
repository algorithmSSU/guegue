import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ1753 {
    static class Edge {
        int toVertexIdx;
        int weight;

        public Edge(int toVertexIdx, int weight) {
            this.toVertexIdx = toVertexIdx;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "toVertexIdx : " + toVertexIdx + " // weight : " + weight;
        }
    }

    static class Info implements Comparable<Info> {
        int vertexIdx;
        int startToNowVertexWeight;

        public Info(int vertexIdx, int startToNowVertexWeight) {
            this.vertexIdx = vertexIdx;
            this.startToNowVertexWeight = startToNowVertexWeight;
        }

        @Override
        public int compareTo(Info o) {
            return this.startToNowVertexWeight - o.startToNowVertexWeight;
        }
    }

    static int v, e, start;
    static int[] distance;
    static List<Edge>[] graph;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set v, e
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // set start
        start = Integer.parseInt(br.readLine());

        // init graph
        graph = new List[v + 1];
        for (int i = 1; i <= v; i++)
            graph[i] = new ArrayList<>();

        // set graph
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        // set distance array
        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set distance by dijkstra
        setDistance();

        // print answer
        for (int i = 1; i <= v; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    private static void setDistance() {
        Queue<Info> queue = new PriorityQueue<>();

        // init start
        distance[start] = 0;
        queue.add(new Info(start, 0));

        // dijkstra
        while (!queue.isEmpty()) {
            Info nowInfo = queue.poll();

            // validation check (distance array 에 있는 요소가 더 작아서 검사할 필요가 없는 경우)
            if (nowInfo.startToNowVertexWeight > distance[nowInfo.vertexIdx]) continue;

            for (Edge adjacency : graph[nowInfo.vertexIdx]) {
                // 갱신할 필요가 없는 경우
                if (distance[adjacency.toVertexIdx] <= distance[nowInfo.vertexIdx] + adjacency.weight) continue;

                // 갱신
                distance[adjacency.toVertexIdx] = distance[nowInfo.vertexIdx] + adjacency.weight;
                queue.add(new Info(adjacency.toVertexIdx, distance[adjacency.toVertexIdx]));
            }
        }

    }
}
