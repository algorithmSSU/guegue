import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    private static int[][] map;
    private static int n, m, nowY, nowX, nowDirection, cleanCount;
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int CLEANED = 2;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        init();

        clean();
        System.out.println(cleanCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set 청소기 위치 및 방향
        st = new StringTokenizer(br.readLine());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        nowDirection = Integer.parseInt(st.nextToken());

        // set map
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanCount = 0;
    }

    private static void clean() {
        // 현재 칸 청소
        if (map[nowY][nowX] == EMPTY) {
            map[nowY][nowX] = CLEANED;
            cleanCount++;
        }

        if (existEmpty()) {
            // 반시계 방향 회전
            rotateDirectionByReverseClock();

            int nextY = nowY + directions[nowDirection][0];
            int nextX = nowX + directions[nowDirection][1];
            if (map[nextY][nextX] == EMPTY){
                nowY += directions[nowDirection][0];
                nowX += directions[nowDirection][1];
            }
            clean();
        } else {
            // 후진
            nowY += directions[inverseDirection()][0];
            nowX += directions[inverseDirection()][1];
            // 벽인 경우
            if (map[nowY][nowX] == WALL)
                return;

            clean();
        }
    }

    private static boolean existEmpty() {
        for (int i = 0; i < 4; i++) {
            int nextY = nowY + directions[i][0];
            int nextX = nowX + directions[i][1];

            if (map[nextY][nextX] == EMPTY)
                return true;
        }

        return false;
    }

    private static int inverseDirection() {
        return (nowDirection + 2) % 4;
    }

    private static void rotateDirectionByReverseClock() {
        nowDirection = (nowDirection == 0) ? 3 : nowDirection - 1;
    }
}
