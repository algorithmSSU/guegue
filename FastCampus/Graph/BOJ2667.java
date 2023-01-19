package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {
    static int n, answerCount;
    static int[][] arrayMap;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static List<Integer> answerList;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrayMap = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                arrayMap[i][j] = st.charAt(j) - '0';
            }
        }

        answerList = new ArrayList<Integer>();
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrayMap[i][j] == 0) continue;
                if (visited[i][j]) continue;

                // dfs
                answerCount = 0;
                dfs(i, j);
                answerList.add(answerCount);
            }
        }

        Collections.sort(answerList);

        // print
        System.out.println(answerList.size());
        for(int i : answerList)
            System.out.println(i);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        answerCount++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
            if(arrayMap[nextX][nextY] == 0) continue;
            if(visited[nextX][nextY]) continue;

            dfs(nextX, nextY);
        }
    }
}
