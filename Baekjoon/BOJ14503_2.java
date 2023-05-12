import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_2 {
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서
    private static int n, m, answer;
    private static int nowX, nowY, nowDirection;
    private static int[][] array;
    private static final int EMPTY = 0, WALL = 1, CLEAN = 2;


    public static void main(String[] args) throws IOException {
        init();
        dfs();
        System.out.println(answer);
    }

    private static void dfs() {
        if (array[nowY][nowX] == EMPTY) {
            array[nowY][nowX] = CLEAN;
            answer++;
        }

        if (cleanNearHere()) {
            int backDirection = getBackDirection();
            int nextY = nowY + directions[backDirection][0];
            int nextX = nowX + directions[backDirection][1];

            // 후진 못하는 경우
            if (array[nextY][nextX] == WALL) {
                return;
            }

            // 후진
            nowY = nextY;
            nowX = nextX;
            dfs();
        } else {
            rotate();
            int nextY = nowY + directions[nowDirection][0];
            int nextX = nowX + directions[nowDirection][1];

            if (array[nextY][nextX] == EMPTY) {
                nowY = nextY;
                nowX = nextX;
            }
            dfs();
        }
    }

    private static void rotate() {
        nowDirection -= 1;
        if (nowDirection < 0)
            nowDirection += 4;
    }

    private static int getBackDirection() {
        return (nowDirection + 2) % 4;
    }

    private static boolean cleanNearHere() {
        boolean clean = true;

        for (int i = 0; i < 4; i++) {
            int nextY = nowY + directions[i][0];
            int nextX = nowX + directions[i][1];

            if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;

            if (array[nextY][nextX] == EMPTY) {
                clean = false;
                break;
            }
        }

        return clean;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        nowDirection = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
    }

    private static void printArray() {
        for (int[] i : array) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
