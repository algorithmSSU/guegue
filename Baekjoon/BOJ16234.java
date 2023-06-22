import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
    private static int n, l, r;
    private static int nowPeopleNum, nowSum;
    private static int[][] array;
    private static Queue<Integer> updateQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();

        // process
        int count = 0;
        while (true) {
            // init
            boolean[][] isVisited = new boolean[n][n];
            int updateCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nowPeopleNum = 0;
                    nowSum = 0;
                    if (!isVisited[i][j]) {
                        isVisited[i][j] = true;
                        updateQueue.clear();
                        updateQueue.add(i); updateQueue.add(j);
                        dfs(i, j, isVisited); // update now value

                        if (update(getPeopleNum()))
                            updateCount++;
                    }
                }
            }

            if (updateCount == 0)
                break;

            count++;
        }

        System.out.println(count);
    }

    private static void dfs(int y, int x, boolean[][] isVisited) {
        nowPeopleNum++;
        nowSum += array[y][x];

        for (int i = 0; i < 4; i++) {
            int nextY = y + directions[i][0];
            int nextX = x + directions[i][1];

            if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n)
                continue;
            if(isVisited[nextY][nextX])
                continue;
            if(!validate(array[y][x], array[nextY][nextX]))
                continue;

            updateQueue.add(nextY); updateQueue.add(nextX);
            isVisited[nextY][nextX] = true;
            dfs(nextY, nextX, isVisited);
        }
    }

    private static boolean validate(int nowValue, int nextValue){
        int difference = Math.abs(nowValue - nextValue);

        return l <= difference && difference <= r;
    }

    private static int getPeopleNum() {
        return nowSum / nowPeopleNum;
    }

    private static boolean update(int convertPeopleNum) {
        if(updateQueue.size() == 2)
            return false;

        while(!updateQueue.isEmpty()){
            int nowY = updateQueue.poll();
            int nowX = updateQueue.poll();

            array[nowY][nowX] = convertPeopleNum;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, l, r
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void debugPrint() {
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}


/*
1. update 할 게 없을 때까지 while
2. 방문된 적 없으면 dfs 돌며 연합 정보 세팅
3. 연합 정보 바탕으로 배열 update
4. update ++
 */