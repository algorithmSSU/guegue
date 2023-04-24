import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {
    static class CCTV {
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    private static final int EMPTY = 0;
    private static final int WALL = 6;

    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상0 하1 좌2 우3

    private static int[][] cctv1Move = {{0}, {1}, {2}, {3}}; // 상, 하, 좌, 우
    private static int[][] cctv2Move = {{0, 1}, {2, 3}}; // 상하, 좌우
    private static int[][] cctv3Move = {{0, 3}, {0, 2}, {1, 3}, {1, 2}}; // 상우, 상좌, 하우, 하좌
    private static int[][] cctv4Move = {{0, 2, 3}, {0, 2, 1}, {2, 1, 3}, {0, 3, 1}}; // 상좌우, 상좌하, 좌하우, 상우하
    private static int[][] cctv5Move = {{0, 1, 2, 3}}; // 상하좌우


    private static int[][] room;
    private static int n, m, hiddenSpaceMinCount;
    private static List<CCTV> cctvList;

    public static void main(String[] args) throws IOException {
        init();

        dfs(0, room);

        System.out.println(hiddenSpaceMinCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set int variable
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hiddenSpaceMinCount = Integer.MAX_VALUE;

        // init cctv
        cctvList = new ArrayList<CCTV>();

        // set room
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int thisNum = Integer.parseInt(st.nextToken());
                room[i][j] = thisNum;

                if (isCCTV(thisNum)) {
                    cctvList.add(new CCTV(i, j, thisNum));
                }
            }
        }
    }

    private static boolean isCCTV(int num) {
        return (num >= 1) && (num <= 5);
    }

    private static void dfs(int depth, int[][] room) {
        if (depth == cctvList.size()) {
            int hiddenSpaceCount = getHiddenSpaceCount(room);
            hiddenSpaceMinCount = Math.min(hiddenSpaceMinCount, hiddenSpaceCount);
            return;
        }

        CCTV nowCCTV = cctvList.get(depth);

        int[][] cctvMoves = getCCTVMoves(nowCCTV.type);

        // 감시 가능한 cctv 경로 탐색
        for (int[] cctvMove : cctvMoves) {
            int[][] copyRoom = getCopyRoom(room);

            // 감시 가능한 cctv 경로 처리 (set -1)
            for (int direction : cctvMove) {
                int nextY = nowCCTV.y + directions[direction][0];
                int nextX = nowCCTV.x + directions[direction][1];

                while(true){
                    // check validation
                    if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) break;
                    if(copyRoom[nextY][nextX] == WALL) break;

                    // CCTV가 아닌 경우
                    if(!isCCTV(copyRoom[nextY][nextX])) {
                        copyRoom[nextY][nextX] = -1;
                    }

                    // next
                    nextY = nextY + directions[direction][0];
                    nextX = nextX + directions[direction][1];
                }
            }

            dfs(depth + 1, copyRoom);
        }
    }

    private static int getHiddenSpaceCount(int[][] room) {
        int hiddenCount = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == EMPTY) {
                    hiddenCount++;
                }
            }
        }

        return hiddenCount;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getCopyRoom(int[][] room) {
        int[][] copyRoom = new int[n][m];

        for (int i = 0; i < room.length; i++) {
            copyRoom[i] = room[i].clone();
        }

        return copyRoom;
    }

    private static int[][] getCCTVMoves(int num) {
        switch (num) {
            case 1:
                return cctv1Move;
            case 2:
                return cctv2Move;
            case 3:
                return cctv3Move;
            case 4:
                return cctv4Move;
            case 5:
                return cctv5Move;
        }

        return null;
    }
}


/**
 * 1. CCTV 종류별 directions 초기화
 * 2. CCTV 배열 생성
 * 3. CCTV 배열에서 dfs
 * 4. CCTV 모두 돌린 경우 update 사각지대 갯수
 */