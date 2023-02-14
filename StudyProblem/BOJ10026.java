import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ10026 {
    private static int n;
    private static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static char[][] array;
    private static boolean[][] visited;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n
        n = Integer.parseInt(br.readLine());

        // set array
        array = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = str.charAt(j);
            }
        }

        //
        visited = new boolean[n][n];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        int answerCount1 = 0;
        int answerCount2 = 0;

        // calculate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    answerCount1++;
                    bfs(i, j);
                }
            }
        }

        // convert G to R
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(array[i][j] == 'G')
                    array[i][j] = 'R';
            }
        }

        // calculate2
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    answerCount2++;
                    bfs(i, j);
                }
            }
        }

        // print answer
        System.out.print(answerCount1 + " " + answerCount2);
    }

    private static void bfs(int startY, int startX) {
        Queue<Integer> queue = new LinkedList<>();

        // set init
        queue.add(startY);
        queue.add(startX);
        visited[startY][startX] = true;

        //
        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int nextY = thisY + direction[i][0];
                int nextX = thisX + direction[i][1];

                // validation check
                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) continue;
                if (array[thisY][thisX] != array[nextY][nextX]) continue;
                if (visited[nextY][nextX]) continue;

                queue.add(nextY);
                queue.add(nextX);
                visited[nextY][nextX] = true;
            }
        }
    }
}
