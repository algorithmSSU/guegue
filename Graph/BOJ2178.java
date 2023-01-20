import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class BOJ2178 {
    static int n, m;
    static int[][] arrayMap;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int[][] distance;
    static boolean[][] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrayMap = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];


        String tmpStr;
        for (int i = 0; i < n; i++) {
            tmpStr = br.readLine();
            for (int j = 0; j < m; j++) {
                arrayMap[i][j] = tmpStr.charAt(j) - '0';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // bfs
        bfs(0, 0);

        // answer print
        System.out.println(distance[n - 1][m - 1]);
    }

    private static void bfs(int y, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        queue.add(x);
        visited[y][x] = true;

        // 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
        distance[y][x] = 1;

        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = thisY + direction[i][0];
                int nextX = thisX + direction[i][1];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
                if (visited[nextY][nextX]) continue;
                if (arrayMap[nextY][nextX] != 1) continue;

                queue.add(nextY);
                queue.add(nextX);
                visited[nextY][nextX] = true;
                distance[nextY][nextX] = distance[thisY][thisX] + 1;
            }
        }
    }


    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arrayMap[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
