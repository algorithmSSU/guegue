package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static int n, m, startV;
    static List<Integer> graph[];
    static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

        // initialize visited
        visited = new boolean[n + 1];

        // initialize graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            // bidirectional
            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // dfs
        dfs(startV);
        System.out.println();

        // bfs
        visited = new boolean[n + 1];
        bfs(startV);
    }

    private static void dfs(int nowVertex) {
        visited[nowVertex] = true;
        System.out.print(nowVertex + " ");

        for (int adjacentV : graph[nowVertex]) {
            if (!visited[adjacentV]) {
                dfs(adjacentV);
            }
        }
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int thisVertex = queue.poll();
            System.out.print(thisVertex + " ");

            for (int adjacentV : graph[thisVertex]) {
                if (!visited[adjacentV]) {
                    queue.add(adjacentV);
                    visited[adjacentV] = true;
                }
            }
        }
    }
}










/*
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // initialize graph
        for(int i = 0; i <= n; i++){
            graph.add(i, new ArrayList<>());
        }

        // initialize edges
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            // bidirection
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        // 정렬
        for(List<Integer> list : graph){
            Collections.sort(list);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        // dfs and bfs
        process();
    }

    private static void process(){
        // dfs
        boolean[] visited = new boolean[n+1];

        dfs(v, visited);
        System.out.println();

        // bfs
        bfs(v);
    }

    private static void dfs(int startVertex, boolean[] visited){
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for(int i : graph.get(startVertex)){
            if(!visited[i]){
                dfs(i, visited);
            }
        }
    }

    private static void bfs(int startVertex){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while(queue.size() != 0){
            int thisVertex = queue.poll();
            System.out.print(thisVertex + " ");

            // 인접 vertex
            for(int adjcentVertex : graph.get(thisVertex)){
                if(!visited[adjcentVertex]){
                    visited[adjcentVertex] = true;
                    queue.add(adjcentVertex);
                }
            }
        }

    }
 */