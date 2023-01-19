import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m, n, k, answerCount;
    static int[][] array;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            array[y][x] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();

            process();
        }
    }

    private static void process() {
        answerCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(array[i][j] != 1) continue;
                if(visited[i][j]) continue;

                dfs(i, j);
                answerCount++;
            }
        }

        System.out.println(answerCount);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0 ; i < 4; i++){
            int nextY = y + direction[i][0];
            int nextX = x + direction[i][1];

            if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
            if(array[nextY][nextX] != 1) continue;
            if(visited[nextY][nextX]) continue;

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

    private static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}



/*
유기농 배추
https://www.acmicpc.net/problem/1012


 */