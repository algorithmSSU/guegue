import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    private static int[][] dp;
    private static int[] item, pleasure;
    private static int maxWeight;

    public static void main(String[] args) throws IOException {
        init();

        dp();
        System.out.println(dp[item.length - 1][maxWeight]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][maxWeight + 1];
        item = new int[n + 1];
        pleasure = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i] = Integer.parseInt(st.nextToken());
            pleasure[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dp() {
        int size = item.length - 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (isPossibleNow(item[i], j)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i]] + pleasure[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    private static boolean isPossibleNow(int itemWeight, int nowPossibleWeight) {
        return itemWeight <= nowPossibleWeight;
    }
}
