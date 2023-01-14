package Graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge("A", 5))));

        Map<String, Integer> shortestDistanceMap = dijkstraSearch(graph, "A");

        // print
        for(String vertex : shortestDistanceMap.keySet()){
            System.out.println(vertex + " : " + shortestDistanceMap.get(vertex));
        }
    }

    private static Map<String, Integer> dijkstraSearch(Map<String, List<Edge>> graph, String start){
        // 예외처리
        if(!graph.keySet().contains(start)){
            System.out.println("start Key error");
            System.exit(1);
        }

        // initialize 출발지로부터 가중치합 Map
        Map<String, Integer> weights = new HashMap<>();
        for(String key : graph.keySet()){
            weights.put(key, Integer.MAX_VALUE);
        }
        weights.put(start, 0);

        // initialize 우선순위큐
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, weights.get(start)));

        // calculate
        while(pq.size() != 0){
            Edge thisEdge = pq.poll();
            String thisVertex = thisEdge.vertex;
            int thisWeight = thisEdge.weight;

            // 예외처리
            // 현재 뽑은 엣지의 가중치가 weights에 저장되어있는 것보다 크면 계산할 필요도 없음
            if(thisWeight > weights.get(thisVertex))
                continue;

            // 인접한 vertex loop
            for(Edge adjacentEdge : graph.get(thisVertex)){
                int weightSum = thisWeight + adjacentEdge.weight;

                // 현재 저장되어있는 가중치합보다 현재 계산중인 인접노드 방향으로 가는 가중치합이 더 작은 경우
                if(weightSum < weights.get(adjacentEdge.vertex)){
                    // weights 업데이트
                    weights.put(adjacentEdge.vertex, weightSum);

                    // 우선순위 큐에 넣기
                    pq.offer(new Edge(adjacentEdge.vertex, weightSum));
                }
            }
        }

        return weights;
    }


    static class Edge implements Comparable<Edge>{
        String vertex;
        int weight;

        public Edge(String vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1){
            return this.weight - o1.weight;
        }

        @Override
        public String toString(){
            return this.vertex + " : "  + this.weight;
        }
    }
}


/*
- 출발점으로부터 특정 vertex까지 최단경로 구하는 알고리즘 중 하나
- 자기 노드와 연결된 vertex부터 계산하기 때문에 BFS랑 비슷함
- 우선순위 큐 사용하는 것이 가장 보편 (minHeap)
*/