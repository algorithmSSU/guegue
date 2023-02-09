import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ11057 {
    static int n;
    static int[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][9 + 1];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setDp();

        // print answer
        int sum = 0;
        for (int i : dp[n]){
            sum += i;
            sum %= 10007;
        }
        System.out.println(sum);
    }

    private static void setDp() {
        // set init
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // set others
        for (int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++){
                for(int k = j; k <= 9; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
    }
}