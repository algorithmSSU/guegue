import java.util.*;
import java.io.*;

public class BOJ2606 {
    static int vertexCount, edgeCount, answerCount;
    static List<Integer>[] graph;
    static boolean[] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        vertexCount = Integer.parseInt(br.readLine());
        edgeCount = Integer.parseInt(br.readLine());

        visited = new boolean[vertexCount+1];
        
        graph = new List[vertexCount+1];
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }

        answerCount = 0;
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
//        dfs(1);
        bfs(1);

        System.out.println(answerCount-1);
    }

    private static void bfs(int startVertex){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while(!queue.isEmpty()){
            answerCount++;
            int nowVertex = queue.poll();

            for(int i : graph[nowVertex]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int vertex){
        visited[vertex] = true;
        answerCount++;

        for(int i : graph[vertex]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}

/*
바이러스
https://www.acmicpc.net/problem/2606


 */
