import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ2623 {
    static int n, m;
    static int[] inDegree;
    static List<Integer>[] graph;
    static List<Integer> answer;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        inDegree = new int[n + 1];
        answer = new ArrayList<>();

        // set graph
        for (int i = 0; i < m; i++) {
            // set 1 pd
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] array = new int[num];
            for (int j = 0; j < num; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < array.length - 1; j++) {
                graph[array[j]].add(array[j+1]);
                inDegree[array[j+1]]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        topologicalSorting();

        // print answer - Exception handling (no answer)
        if(answer.size() != n){
            System.out.println(0);
        }else{
            for(int i : answer)
                System.out.println(i);
        }
    }

    private static void topologicalSorting(){
        Queue<Integer> queue = new LinkedList<>();

        // set init value
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        // topological Sorting
        while(!queue.isEmpty()){
            int thisVertex = queue.poll();
            answer.add(thisVertex);

            for(int i : graph[thisVertex]){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
    }
}