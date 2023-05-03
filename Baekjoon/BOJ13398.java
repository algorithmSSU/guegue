import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13398 {
    private static int n;
    private static int[] array;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][2];
    }

    private static void setDp() {
        dp[0][0] = array[0];
        dp[0][1] = array[0];
        int max = array[0];
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0] + array[i], array[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + array[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}
