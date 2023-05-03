import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    private static int[][] dp;
    private static int n;
    private static final int DIVIDE = 10007;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
        System.out.println((dp[n][0] + dp[n][1]) % DIVIDE);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
    }

    private static void setDp() {
        // init
        dp[1][0] = 1;
        if(n >= 2){
            dp[2][0] = 1;
            dp[2][1] = 1;
        }

        // calculate
        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % DIVIDE;
            dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % DIVIDE;
        }
    }
}
