import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ14719{
    private static int h, w;
    private static int[] height;

    public static void main(String[] args) throws IOException {
        init();

        // process
        int waterCount = 0;
        for(int i = 1; i < w - 1; i++){
            int left = 0;
            int right = 0;
            int nowHeight = height[i];
            for(int j = 0; j <= i; j++){
                left = Math.max(left, height[j]);
            }
            for(int j = i + 1; j < w; j++){
                right = Math.max(right, height[j]);
            }

            if(nowHeight < left && nowHeight < right){
                waterCount += (Math.min(left, right) - nowHeight);
            }
        }

        System.out.println(waterCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set w, h
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        // set array
        height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
    }

}



/*
방법1.
public class BOJ14719 {
    private static final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}}; // 하좌우
    private static int w, h, answerCount;
    private static int[][] array;
    private static boolean[][] isVisited;


    public static void main(String[] args) throws IOException {
        init();

        // process
        for (int i = h - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < w; j++) {
                if (array[i][j] == 1) {
                    count++;
                }

                if (count == 2) {
                    answerCount += bfs(i, j - 1);
                    count = 1;
                }
            }
        }
//        debugPrint();

        // print answer
        System.out.println(answerCount);
    }

    private static int bfs(int startY, int startX) {
        if (isVisited[startY][startX])
            return 0;
        if(array[startY][startX] == 1)
            return 0;


        Queue<Integer> queue = new LinkedList<>();
        queue.add(startY);
        queue.add(startX);
        isVisited[startY][startX] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();
            array[thisY][thisX] = 9;
            count++;

            for (int i = 0; i < 3; i++) {
                int nextY = thisY + directions[i][0];
                int nextX = thisX + directions[i][1];

                if (nextY < 0 || nextX < 0 || nextY >= h || nextX >= w) {
                    continue;
                }
                if (isVisited[nextY][nextX])
                    continue;
                if (array[nextY][nextX] == 1)
                    continue;

                isVisited[nextY][nextX] = true;
                queue.add(nextY);
                queue.add(nextX);
            }
        }

        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set w, h
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        // set array
        array = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                array[j][i] = 1;
            }
        }

        // init isVisited
        isVisited = new boolean[h][w];

    }

    private static void debugPrint() {
        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

}
 */