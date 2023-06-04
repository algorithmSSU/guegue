import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2573 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static int[][] map;
    private static int n, m, year;
    private static List<Integer> iceList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        init();

        while (iceList.size() > 0) {
            if (isDividedMap()) {
                break;
            }
            afterOneYear();
        }

        // print answer
        System.out.println(iceList.size() == 0 ? 0 : year);
    }



    private static boolean isDividedMap() {
        boolean[][] isVisited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    count++;
                    dfs(i, j, isVisited);
                }
            }
        }

        return count >= 2;
    }

    private static void dfs(int nowY, int nowX, boolean[][] isVisited) {
        isVisited[nowY][nowX] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = nowY + directions[i][0];
            int nextX = nowX + directions[i][1];

            if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
                continue;
            if (map[nextY][nextX] == 0)
                continue;
            if (isVisited[nextY][nextX])
                continue;

            dfs(nextY, nextX, isVisited);
        }
    }

    private static void afterOneYear() {
        year++;
        int[][] copyMap = getCopyMap();

        for (int i = 0; i < iceList.size(); i += 2) {
            int nowY = iceList.get(i);
            int nowX = iceList.get(i + 1);

            melting(copyMap, nowY, nowX);
            if (map[nowY][nowX] == 0) {
                iceList.remove(i + 1);
                iceList.remove(i);
                i -= 2;
            }
        }
    }

    private static void melting(int[][] copyMap, int nowY, int nowX) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = nowY + directions[i][0];
            int nextX = nowX + directions[i][1];

            if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
                continue;
            if (copyMap[nextY][nextX] != 0)
                continue;

            count++;
        }

        map[nowY][nowX] -= count;
        if (map[nowY][nowX] < 0)
            map[nowY][nowX] = 0;
    }

    private static int[][] getCopyMap() {
        int[][] copyMap = new int[n][];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        return copyMap;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init year
        year = 0;

        // set map
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빙산 저장
                if (map[i][j] != 0) {
                    iceList.add(i);
                    iceList.add(j);
                }
            }
        }

//        System.out.println("iceList");
//        for (int i = 0; i < iceList.size(); i += 2) {
//            System.out.println(iceList.get(i) + " " + iceList.get(i + 1));
//        }
    }

    private static void debugPrint() {
        for (int[] i : map) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
