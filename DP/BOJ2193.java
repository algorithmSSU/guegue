import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ2193 {
    static int n;
    static long[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][2];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set init
        dp[1][0] = 0;
        dp[1][1] = 1;

        // set others
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        // print answer
        System.out.println(dp[n][0] + dp[n][1]);
    }
}