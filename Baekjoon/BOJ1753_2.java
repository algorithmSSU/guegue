import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753_2 {
    static class Edge {
        int toVertexIdx;
        int weight;

        Edge(int toVertexIdx, int weight) {
            this.toVertexIdx = toVertexIdx;
            this.weight = weight;
        }
    }

    static class Info implements Comparable<Info> {
        int nodeIdx;
        int weightSumFromStartNodeIdx;

        Info(int nodeIdx, int weightSumFromStartNodeIdx) {
            this.nodeIdx = nodeIdx;
            this.weightSumFromStartNodeIdx = weightSumFromStartNodeIdx;
        }


        @Override
        public int compareTo(Info o) {
            return this.weightSumFromStartNodeIdx - o.weightSumFromStartNodeIdx;
        }
    }

    private static int startNode;
    private static List<Edge>[] graph;
    private static int[] distanceFromStartNode;

    public static void main(String[] args) throws IOException {
        init();

        setDistance();

        printDistance();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set v, e
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        startNode = Integer.parseInt(br.readLine());

        // init graph
        graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // set graph
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[startNode].add(new Edge(endNode, weight));
        }

        // init distanceFromStartNode
        distanceFromStartNode = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            distanceFromStartNode[i] = Integer.MAX_VALUE;
        }
    }

    private static void setDistance() {
        Queue<Info> queue = new PriorityQueue<>();

        distanceFromStartNode[startNode] = 0;
        queue.add(new Info(startNode, 0));

        while (!queue.isEmpty()){
            Info thisInfo = queue.poll();

            if(distanceFromStartNode[thisInfo.nodeIdx] < thisInfo.weightSumFromStartNodeIdx){
                continue;
            }

            for(Edge edge : graph[thisInfo.nodeIdx]){
                if(distanceFromStartNode[edge.toVertexIdx] < distanceFromStartNode[thisInfo.nodeIdx] + edge.weight) continue;

                distanceFromStartNode[edge.toVertexIdx] = distanceFromStartNode[thisInfo.nodeIdx] + edge.weight;
                queue.add(new Info(edge.toVertexIdx, distanceFromStartNode[edge.toVertexIdx]));
            }
        }
    }

    private static void printDistance() {
        for (int i = 1; i < graph.length; i++) {
            if (distanceFromStartNode[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distanceFromStartNode[i]);
        }
    }
}
