import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20167 {
    static class Interval {
        int left;
        long satisfy;

        public Interval(int left, long satisfy) {
            this.left = left;
            this.satisfy = satisfy;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "left=" + left +
                    ", satisfy=" + satisfy +
                    '}';
        }
    }

    private static int n, k;
    private static int[] array;
    private static long[] dp;
    private static List<Interval>[] intervalList;

    public static void main(String[] args) throws IOException {
        init();

        // set intervalList
        int right = 0;
        long sum = 0;
        for (int left = 1; left <= n; left++) {
            sum -= array[left - 1];

            while (right + 1 <= n && sum < k) {
                right++;
                sum += array[right];
            }

            if (sum < k)
                continue;

            intervalList[right].add(new Interval(left, sum - k));
        }

        // set dp
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (Interval now : intervalList[i]) {
                dp[i] = Math.max(dp[i], dp[now.left - 1] + now.satisfy);
            }
        }

        System.out.println(dp[n]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, k
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // init dp
        dp = new long[n + 1];

        // init
        intervalList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            intervalList[i] = new ArrayList<>();
        }
    }
}

