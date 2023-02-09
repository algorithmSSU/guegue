import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ2688 {
    static int n;
    static long[][] dp;
    static List<Integer> list;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[64 + 1][10];

        list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setDp();

        // print answer
        for(int i : list){
            System.out.println(sumArray(dp[i]));
        }
    }

    private static void setDp(){
        // set init
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // set others
        for (int i = 2; i <= 64; i++) {
            // 각 자리수 계산
            for (int j = 0; j <= 9; j++) {
                // dp[i][j] = sum(dp[i][0~j])
                long sum = 0;
                for(int k = 0; k <= j; k++)  sum += dp[i-1][k];

                dp[i][j] = sum;
            }
        }
    }

    private static long sumArray(long[] array){
        long sum = 0;
        for(long i : array)
            sum += i;

        return sum;
    }
}
