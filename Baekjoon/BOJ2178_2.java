import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_2 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static int[][] maze;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        init();

        bfs();

        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, m
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set maze
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String inputInfo = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = (inputInfo.charAt(j) - '0');
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        // insert (0, 0)
        queue.add(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = thisY + directions[i][0];
                int nextX = thisX + directions[i][1];

                // check validation
                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
                if (maze[nextY][nextX] == 0 || maze[nextY][nextX] > 1) continue; // 1인 경우 방문안한 걸로 처리 (출발점 예외처리 해야하지만 출력 대상 아니라 별도의 처리를 하지 않았음)

                queue.add(nextY);
                queue.add(nextX);
                maze[nextY][nextX] = maze[thisY][thisX] + 1;
            }
        }
    }

    private static void printAnswer() {
        System.out.println(maze[n - 1][m - 1]);
    }
}
