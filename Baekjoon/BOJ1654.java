import java.util.*;
import java.io.*;

public class BOJ1654 {
    private static int[] lan;
    private static int k, wantNum, lanMax;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(getLanMaxLength());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        wantNum = Integer.parseInt(st.nextToken());

        // set lan, max
        lan = new int[k];
        lanMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            lanMax = Math.max(lanMax, lan[i]);
        }
    }

    private static long getLanMaxLength() {
        long left = 1, right = lanMax;
        long lanMaxLength = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (validate(mid)) {
                lanMaxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lanMaxLength;
    }

    private static boolean validate(long length) {
        long lanCount = 0;

        for (int thisLan : lan) {
            lanCount += (thisLan / length);
        }

        return lanCount >= wantNum;
    }
}
