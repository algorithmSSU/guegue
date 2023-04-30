import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193_2 {
    private static int n;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
        System.out.println(dp[n][0] + dp[n][1]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][n + 1];
    }

    private static void setDp() {
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            // 0으로 끝나는 경우의 수
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];

            // 1
            dp[i][1] = dp[i - 1][0];
        }
    }
}
