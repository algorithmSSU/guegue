import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ2156 {
    static int n;
    static int[] array, dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[10001];
        dp = new int[10001];

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setDp();

        System.out.println(dp[n]);
    }

    private static void setDp() {
        // set init
        dp[1] = array[1];
        dp[2] = array[1] + array[2];

        for (int i = 3; i <= n; i++) {
            int case1 = dp[i-1]; // 현재 포도잔 안마심
            int case2 = dp[i-2] + 0 + array[i];// 현재 포도잔 마심1
            int case3 = dp[i-3] + 0 + array[i-1] + array[i];// 현재 포도잔 마심2
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }
    }
}

