import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ2579 {
    static int n;
    static int[] array, dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // init array
        if (n < 2) array = new int[2 + 1];
        else array = new int[n + 1];

        // init dp
        if (n < 2) dp = new int[2 + 1];
        else dp = new int[n + 1];

        // set array
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

        // print answer
        System.out.println(dp[n]);
    }

    private static void setDp() {
        // set init
        dp[1] = array[1];
        dp[2] = dp[1] + array[2];

        if(n < 3) return;

        // set dp
        for(int i = 3; i <= n; i++){
            int case2 = dp[i-2] + array[i];
            int case3 = dp[i-3] + array[i-1] + array[i];
            dp[i] = Math.max(case2, case3);
        }
    }
}

