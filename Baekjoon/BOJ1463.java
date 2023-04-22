import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        // init dp
        if (n >= 2)
            dp[2] = 1;
        if (n >= 3)
            dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            int minOperatorCount = dp[i - 1] + 1;
            if (i % 2 == 0)
                minOperatorCount = Math.min(minOperatorCount, dp[i / 2] + 1);
            if (i % 3 == 0)
                minOperatorCount = Math.min(minOperatorCount, dp[i / 3] + 1);

            dp[i] = minOperatorCount;
        }

        System.out.println(dp[n]);
    }
}
