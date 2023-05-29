import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13398_2 {
    private static int n;
    private static int[][] dp;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // set dp
        int answer = Integer.MIN_VALUE;
        for(int i = 1 ; i < array.length; i++){
            // 0 : 제거 안하는 경우
            dp[i][0] = Math.max(dp[i-1][0] + array[i], array[i]);

            // 1 : 제거 한 경우
            int case1 = dp[i-1][1] + array[i]; // 이미 제거가 되어있는 경우
            int case2 = dp[i-1][0]; // 이번에 제거하는 경우
            dp[i][1] = Math.max(Math.max(case1, case2), array[i]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        answer = Math.max(answer, dp[0][0]);

        System.out.println(answer);
    }

    private static void debugPrint() {
        // tmp print
        for(int i = 0 ; i < dp.length; i++){
            System.out.print(dp[i][0] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dp.length; i++){
            System.out.print(dp[i][1] + " ");
        }
        System.out.println();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        // init dp
        dp = new int[n][2];

        // dp 초기값 setting
        dp[0][0] = array[0];
    }

}
