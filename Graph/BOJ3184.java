import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184 {
    static int row, column, sheepSum, wolfSum;
    static int nowSheepCount, nowWolfCount;
    static int[][] array;
    static int[][] direction = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        array = new int[row][column];
        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < column; j++) {
                char thisCh = str.charAt(j);
                array[i][j] = convertChar(thisCh);
            }
        }

        sheepSum = 0;
        wolfSum = 0;
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 울타리인 경우 pass
                if(array[i][j] == 1) continue;

                // 방문 안한 울타리 내 영역인 경우
                nowSheepCount = 0; nowWolfCount = 0;
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        // answer print
        System.out.println(sheepSum + " " + wolfSum);
    }

    private static void bfs(int y, int x){
        Queue<Integer> queue = new LinkedList<>();

        // bfs search
        queue.add(y);
        queue.add(x);
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int thisY = queue.poll();
            int thisX = queue.poll();

            // 현재 울타리 안에 양과 늑대 개수 counting
            if(array[thisY][thisX] == 2) nowSheepCount++;
            if(array[thisY][thisX] == 3) nowWolfCount++;

            for(int i = 0 ; i < 4; i++){
                int nextY = thisY + direction[i][0];
                int nextX = thisX + direction[i][1];

                if(nextY < 0 || nextX < 0 || nextY >= row || nextX >= column) continue;
                if(array[nextY][nextX] == 1) continue;
                if(visited[nextY][nextX]) continue;

                // 모든 조건 만족 시 탐색
                queue.add(nextY);
                queue.add(nextX);
                visited[nextY][nextX] = true;
            }
        }


        // update after (sheep vs wolf)
        if(nowSheepCount > nowWolfCount){
            sheepSum += nowSheepCount;
        }else{
            wolfSum += nowWolfCount;
        }
    }


    /**
     * 0 : 빈 필드
     * 1 : 울타리
     * 2 : 양
     * 3 : 늑대
     */
    private static int convertChar(char ch) {
        if (ch == '.')
            return 0;
        else if (ch == '#')
            return 1;
        else if (ch == 'o')
            return 2;
        else if (ch == 'v')
            return 3;

        // input error
        System.out.println("error : maybe input wrong..");
        return -1;
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
