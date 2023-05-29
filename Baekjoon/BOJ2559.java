import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    private static int n, k;
    private static int[] array, dp;

    public static void main(String[] args) throws IOException {
        init();

        // process
        for(int i = k; i < array.length; i++){
            dp[i] = (dp[i-1] + array[i]) - array[i-k];
        }

        // find max
        int max = Integer.MIN_VALUE;
        for(int i = k-1; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, k
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set dp
        dp = new int[n];
        int sum = 0;
        for(int i = 0 ; i < k; i++){
            sum += array[i];
        }
        dp[k-1] = sum;
    }

}
