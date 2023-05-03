import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    private static int n;
    private static int[] array, dp, sumArray;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set sumArray
        sumArray = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        dp = new int[n + 1];
    }

    private static void setDp() {
        dp[1] = array[1];
        int max = array[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
