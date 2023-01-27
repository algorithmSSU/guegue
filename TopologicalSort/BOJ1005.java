import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ1005 {
    /**
     * 1. 입력값 세팅
     * 2. 위상 정렬 이용
     *  2-1. 각 노드는 이전 계산값에 현재 노드의 건설 시간을 더해주어야 함
     *  2-2. 특정 노드를 계산하기 위해서는 입력으로 들어오는 노드 중 최대값을 선택하여 현재 노드의 건설 시간을 더해주어야 함
     *  2-3. 즉, 특정 노드가 계산이 되려면 입력으로 들어오는 노드가 모두 계산이 되어있어야 함 -> 위상 정렬 이용
     *
     * 3. w에 해당하는 노드의 총 건설시간인 answer 출력
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k, w;
    static int[] DTime, sumTime, inDegree;
    static List<Integer>[] graph;

    private static void input() throws IOException {
        StringTokenizer st;

        // set n, k
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // set DTime, sumTime, inDegree
        st = new StringTokenizer(br.readLine());
        inDegree = new int[n + 1];
        sumTime = new int[n + 1];
        DTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            DTime[i] = Integer.parseInt(st.nextToken());
        }

        // set graph
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            inDegree[child]++;
        }

        // set w
        w = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input();

            process();
        }
    }

    private static void process() {
        // set sumTime
        setSumTime();

        // print answer
        System.out.println(sumTime[w]);
    }

    private static void setSumTime() {
        Queue<Integer> queue = new LinkedList<>();

        // add init value (no inDegree)
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                sumTime[i] = DTime[i];
            }
        }

        while(!queue.isEmpty()){
            int thisVertex = queue.poll();

            for(int i : graph[thisVertex]){
                inDegree[i]--;

                sumTime[i] = Math.max(sumTime[i], sumTime[thisVertex] + DTime[i]);

                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
    }
}

