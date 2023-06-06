import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753_3 {
    private static class Edge {
        int toIdx;
        int toWeight;

        public Edge(int toIdx, int toWeight) {
            this.toIdx = toIdx;
            this.toWeight = toWeight;
        }

        @Override
        public String toString() {
            return "toIdx : " + toIdx + " // toWeight : " + toWeight;
        }
    }

    private static class Info implements Comparable<Info> {
        int idx;
        int startToThisNodeWeight;

        public Info(int idx, int startToThisNodeWeight) {
            this.idx = idx;
            this.startToThisNodeWeight = startToThisNodeWeight;
        }

        public int compareTo(Info o) {
            return this.startToThisNodeWeight - o.startToThisNodeWeight;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "idx=" + idx +
                    ", startToThisNodeWeight=" + startToThisNodeWeight +
                    '}';
        }
    }

    private static int v, e, start;
    private static int[] distance;
    private static List<Edge>[] graph;
    private static Queue<Info> pq;


    public static void main(String[] args) throws IOException {
        init();

        setDistance();

        printAnswer();
    }

    private static void printAnswer() {
        for(int i = 1; i <= v; i++){
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    private static void setDistance() {
        pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info nowInfo = pq.poll();

            if (nowInfo.startToThisNodeWeight > distance[nowInfo.idx])
                continue;

            for (Edge adjacency : graph[nowInfo.idx]) {
                if(nowInfo.startToThisNodeWeight + adjacency.toWeight >= distance[adjacency.toIdx])
                    continue;

                distance[adjacency.toIdx] = nowInfo.startToThisNodeWeight + adjacency.toWeight;
                pq.add(new Info(adjacency.toIdx, distance[adjacency.toIdx]));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set v, e
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // set start
        start = Integer.parseInt(br.readLine());

        // set graph
        graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
        }

        // init distance
        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
    }
}
