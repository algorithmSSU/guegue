import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answerCount;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    static int[][] arrayMap;
    static boolean[][] visited;

    private static void input(int w, int h) throws IOException {
        arrayMap = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arrayMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answerCount = 0;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (w == 0 && h == 0)
                break;

            input(w, h);

            process(w, h);
        }
    }

    private static void process(int w, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && arrayMap[i][j] == 1) {
                    answerCount++;
                    dfs(i, j);
                }
            }
        }

        // print answer
        System.out.println(answerCount);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nextY = y + direction[i][0];
            int nextX = x + direction[i][1];

            if (nextY < 0 || nextX < 0 || nextY >= arrayMap.length || nextX >= arrayMap[0].length) continue;
            if(visited[nextY][nextX]) continue;
            if(arrayMap[nextY][nextX] == 0) continue;

            dfs(nextY, nextX);
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
}
