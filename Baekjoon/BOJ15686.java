import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15686 {
    static class Chicken {
        int y;
        int x;
        boolean open = false;

        public Chicken(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n, m, minChickenDistance;
    private static int[][] map;
    private static List<Chicken> chickenList;

    private static final int EMPTY = 0;
    private static final int HOME = 1;
    private static final int CHICKEN = 2;


    public static void main(String[] args) throws IOException {
        init();

        calculateByDfs(0, 0);

        System.out.println(minChickenDistance);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set chickenList
        chickenList = new ArrayList<>();

        // set map
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int thisNum = Integer.parseInt(st.nextToken());
                if (thisNum == CHICKEN) {
                    chickenList.add(new Chicken(i, j));
                    thisNum = 0;
                }
                map[i][j] = thisNum;
            }
        }

        // set minChickenDistance
        minChickenDistance = Integer.MAX_VALUE;
    }

    private static void calculateByDfs(int idx, int chickenCount) {
        if (chickenCount == m) {
            int chickenDistanceSum = calculateChickenDistanceSum();
            minChickenDistance = Math.min(minChickenDistance, chickenDistanceSum);
            return;
        }

        if (idx >= chickenList.size()) {
            return;
        }

        map[chickenList.get(idx).y][chickenList.get(idx).x] = CHICKEN;
        chickenList.get(idx).open = true;
        calculateByDfs(idx + 1, chickenCount + 1);
        map[chickenList.get(idx).y][chickenList.get(idx).x] = EMPTY;
        chickenList.get(idx).open = false;
        calculateByDfs(idx + 1, chickenCount);
    }

    private static int calculateChickenDistanceSum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == HOME) {
                    sum += getChickenDistancePerHome(i, j);
                }
            }
        }

        return sum;
    }

    /*
    현재 집 기준으로 치킨 거리를 구하기 위해서 bfs를 사용할 수 있음.
    하지만 인접 행렬로 나타내진 경우 bfs를 사용하면 시간복잡도가 O(N^2)
    그렇기 때문에 시간 초과가 났음
    => 현재 open 되어있는 치킨집이 어디인지 List로 가지고 있으니까 활용
     */
    private static int getChickenDistancePerHome(int startY, int startX) {
        int chickenDistance = Integer.MAX_VALUE;

        for (Chicken chicken : chickenList) {
            if(chicken.open)
                chickenDistance = Math.min(chickenDistance, getDistance(startX, startY, chicken.x, chicken.y));
        }

        return chickenDistance;
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        int xDistance = Math.abs(x1 - x2);
        int yDistance = Math.abs(y1 - y2);

        return xDistance + yDistance;
    }

    private static void printArray(int[][] map) {
        for (int[] i : map) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}

