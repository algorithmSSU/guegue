import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] array;
    static int[][] dp;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        // set arrasy
        StringTokenizer st;
        array = new int[2][n + 1];
        for (int row = 0; row < 2; row++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                array[row][i] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[2][n + 1];
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input();
            process();
        }
    }

    private static void process() {
        setDp();

        // print answer
        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }

    private static void setDp() {
        // set init
        dp[0][1] = array[0][1];
        dp[1][1] = array[1][1];

        // set others
        for (int i = 2; i <= n; i++) {
            // row == 0
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + array[0][i];

            // row == 1
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + array[1][i];
        }
    }
}
