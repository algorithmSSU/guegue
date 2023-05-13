import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    private static int testCase;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0 ; i < testCase; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            process(n ,m);
        }
    }

    private static void process(int n, int m) {
        int[][] dp = new int[n][m];

        // init
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < m; j++) {
                // calculate possible
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += dp[i - 1][k];
                }

                dp[i][j] = sum;
            }
        }

        printAnswer(dp, n, m);
    }

    private static void printAnswer(int[][] dp, int n, int m){
        int answer = 0;

        for (int i = n-1; i < m; i++) {
            answer += dp[n - 1][i];
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        testCase = Integer.parseInt(br.readLine());
    }
}
