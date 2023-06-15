import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_3 {
    private static final int EMPTY = 0, WALL = 1, CLEANED = -1;
    private static int n, m;
    private static int nowX, nowY, nowDirection;
    private static int[][] map;

    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서

    public static void main(String[] args) throws IOException {
        init();

        int cleanCount = 0;
        while(true){
            if(!isCleaned(nowY, nowX)){
                map[nowY][nowX] = CLEANED;
                cleanCount++;
            }

            if(!shouldCleanNearHere()){
                if(canGoBack()){
                    goBack();
                }else{
                    break; // 종료조건
                }
            }else{
                rotateByReverseClock();
                int nextY = nowY + directions[nowDirection][0];
                int nextX = nowX + directions[nowDirection][1];
                if(map[nextY][nextX] == EMPTY){
                    goForward();
                }
            }
        }

        System.out.println(cleanCount);
    }

    /*
    뒤로 갈 수 있는가
    */
    private static boolean canGoBack(){
        int reverseDirection = (nowDirection + 2) % 4;

        int backY = nowY + directions[reverseDirection][0];
        int backX = nowX + directions[reverseDirection][1];

        return map[backY][backX] != WALL;
    }

    private static void goForward(){
        nowY += directions[nowDirection][0];
        nowX += directions[nowDirection][1];
    }

    /*
    청소가 되었는가 (벽인 경우는 고려하지 않아도 됨)
     */
    private static boolean isCleaned(int y, int x){
        return map[y][x] == CLEANED;
    }

    /*
    주변 4칸에 청소할 곳이 있는가
     */
    private static boolean shouldCleanNearHere(){
        for(int i = 0 ; i < 4; i++){
            int nextY = nowY + directions[i][0];
            int nextX = nowX + directions[i][1];

            if(map[nextY][nextX] == EMPTY){
                return true;
            }
        }

        return false;
    }

    /*
    반시계 회전
     */
    private static void rotateByReverseClock(){
        nowDirection -= 1;
        if(nowDirection == -1)
            nowDirection = 3;
    }

    private static void goBack(){
        int reverseDirection = (nowDirection + 2) % 4;
        nowY += directions[reverseDirection][0];
        nowX += directions[reverseDirection][1];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set nowX, nowY, nowDirection
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
    }

    private static void printMap(){
        for(int[] i : map){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}


/*
반시계 => 남에서 동
map 밖으로 벗어나는 경우 고려 X

 */

/*
조건
현재 청소X => 청소시키기 CLEAN = -1;


 */