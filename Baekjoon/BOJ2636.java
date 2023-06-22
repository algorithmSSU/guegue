import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int EMPTY = 0, CHEEZE = 1;
    private static int[][] map;
    private static int h, w;

    public static void main(String[] args) throws IOException {
        init();

        int time = 0;
        int lastCheeze = 0;
        while(true){
            // 검사
            if(isAllEmpty()){
                break;
            }

            lastCheeze = getLastCheezeAndMelting();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheeze);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // set h, w
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        // set map
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isAllEmpty(){
        for(int i = 1; i < h - 1; i++){
            for(int j = 1; j < w - 1; j++){
                if(map[i][j] == CHEEZE){
                    return false;
                }
            }
        }
        return true;
    }

    private static int getLastCheezeAndMelting(){
        int nowCheezeCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[h][w];

        isVisited[0][0] = true;
        queue.add(0); queue.add(0);
        while(!queue.isEmpty()){
            int thisY = queue.poll(); int thisX = queue.poll();

            for(int i = 0 ; i < 4; i++){
                int nextY = thisY + directions[i][0];
                int nextX = thisX + directions[i][1];

                if(nextY < 0 || nextX < 0 || nextY >= h || nextX >= w)
                    continue;
                if(isVisited[nextY][nextX])
                    continue;

                int now = map[nextY][nextX];
                if(now == EMPTY){
                    queue.add(nextY); queue.add(nextX);
                }else if(now == CHEEZE){
                    nowCheezeCount++;
                    // tmp
                    map[nextY][nextX] = 0;
                }
                isVisited[nextY][nextX] = true;
            }
        }

        return nowCheezeCount;
    }
}


/*
1. 구멍 뚫린 부분 처리
2. 가장자리 제거
 */