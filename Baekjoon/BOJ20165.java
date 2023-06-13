import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20165 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북 EWSN
    private static final int E = 0, W = 1, S = 2, N = 3;
    private static int n, m, roundCount, answerCount;
    private static int[][] gameBoard;
    private static boolean[][] isFallDown;


    public static void main(String[] args) throws IOException {
        init();

        // process
        for (int i = 0; i < roundCount; i++) {
            StringTokenizer attack = new StringTokenizer(br.readLine());
            StringTokenizer shield = new StringTokenizer(br.readLine());

            processAttack(Integer.parseInt(attack.nextToken()), Integer.parseInt(attack.nextToken()), attack.nextToken().charAt(0));
            processShield(Integer.parseInt(shield.nextToken()), Integer.parseInt(shield.nextToken()));
        }

        printAnswer();
    }

    /*
    미는 중에
    이미 넘어진 경우  => continue
    서있는 경우 => 넘어뜨리기 + Queue
    */
    private static void processAttack(int y , int x, char direction) {
        y--; x--;
        // 이미 넘어져있는 경우
        if(isFallDown[y][x])
            return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(y); queue.add(x);
        while(!queue.isEmpty()){
            int nowY = queue.poll();
            int nowX = queue.poll();

            int size = gameBoard[nowY][nowX];
            for(int i = 0 ; i < size; i++){
                if(nowY < 0 || nowX < 0 || nowY >= n || nowX >= m) break;

                if(!isFallDown[nowY][nowX]){
                    isFallDown[nowY][nowX] = true; // 넘어뜨림
                    answerCount += 1;
                    queue.add(nowY); queue.add(nowX);
                }
                nowY += directions[directionConvert(direction)][0];
                nowX += directions[directionConvert(direction)][1];
            }
        }
    }

    private static int directionConvert(char ch){
        switch (ch){
            case 'E':
                return E;
            case 'W':
                return W;
            case 'S':
                return S;
            case 'N':
                return N;
        }

        System.out.println("ERROR");
        return -1;
    }



    private static void processShield(int y, int x) {
        y--; x--;
        isFallDown[y][x] = false;
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append(answerCount).append("\n");

        for(int i = 0 ; i < gameBoard.length; i++){
            for(int j = 0 ; j < gameBoard[i].length; j++){
                if(isFallDown[i][j]){
                    sb.append('F').append(' ');
                }else{
                    sb.append('S').append(' ');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void init() throws IOException {
        // set n, m, roundCount
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        roundCount = Integer.parseInt(st.nextToken());

        // init isFallDown
        isFallDown = new boolean[n][m];

        // set gameBoard
        gameBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                gameBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // init answerCount
        answerCount = 0;
    }

    private static void debugPrint(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
