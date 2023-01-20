import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1697 {
    static final int maxIdx = 100000;
    static int n, k;
    static boolean[] visited;
    static int[] distance;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[maxIdx + 1];
        distance = new int[maxIdx + 1];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        bfs(n);

        System.out.println(distance[k]);
    }

    private static void bfs(int startIdx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIdx);
        visited[startIdx] = true;

        while (!queue.isEmpty()) {
            int thisIdx = queue.poll();

            int nextIdx = thisIdx - 1;
            if (nextIdx >= 0 && nextIdx <= maxIdx && !visited[nextIdx]) {
                queue.add(nextIdx);
                visited[nextIdx] = true;
                distance[nextIdx] = distance[thisIdx] + 1;
            }

            nextIdx = thisIdx + 1;
            if (nextIdx >= 0 && nextIdx <= maxIdx && !visited[nextIdx]) {
                queue.add(nextIdx);
                visited[nextIdx] = true;
                distance[nextIdx] = distance[thisIdx] + 1;
            }

            nextIdx = thisIdx * 2;
            if (nextIdx >= 0 && nextIdx <= maxIdx && !visited[nextIdx]) {
                queue.add(nextIdx);
                visited[nextIdx] = true;
                distance[nextIdx] = distance[thisIdx] + 1;
            }
        }
    }


    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
