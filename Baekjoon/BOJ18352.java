import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {
    private static int cityCount, roadCount, k, start;
    private static List<Integer>[] graph;
    private static int[] distanceArray;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        init();

        setDistanceArray();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new List[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            graph[i] = new ArrayList<>();
        }

        distanceArray = new int[cityCount + 1];
        isVisited = new boolean[cityCount + 1];

        // set graph
        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode].add(endNode);
        }
    }

    private static void setDistanceArray() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int thisNode = queue.poll();

            for (int adjacent : graph[thisNode]) {
                if(!isVisited[adjacent]){
                    distanceArray[adjacent] = distanceArray[thisNode] + 1;
                    isVisited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
    }

    private static void printAnswer() {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 1; i <= cityCount; i++) {
            if (distanceArray[i] == k) {
                answerList.add(i);
            }
        }

        Collections.sort(answerList);

        // print
        if (answerList.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int answerNode : answerList)
                System.out.println(answerNode);
        }
    }
}
