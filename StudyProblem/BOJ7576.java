import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int m, n;
    static int[][] array;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static boolean allOne = true;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set m, n
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // init array
        array = new int[n][m];
        visited = new boolean[n][m];

        // set array
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if(array[i][j] == 0) allOne = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // spread
        bfs();

        // print answer
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                // 익지 않은 토마토가 있는 경우
                if(array[i][j] == 0){
                    System.out.println(-1);
                    return;
                }

                maxNum = Math.max(maxNum, array[i][j]);
            }
        }
        System.out.println((allOne) ? 0 : maxNum-1);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // set init (1tomato add in queue)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = thisY + directions[i][0];
                int nextX = thisX + directions[i][1];

                // check index validation
                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
                if (visited[nextY][nextX]) continue;
                if (array[nextY][nextX] == -1) continue;

                queue.add(nextY);
                queue.add(nextX);
                array[nextY][nextX] = array[thisY][thisX] + 1;
                visited[nextY][nextX] = true;
            }
        }
    }
}
/*
모두 익는 최소 날짜 출력
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 */