package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15565 {
    static int n, k;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        int lionCount = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            // 이전꺼 라이언있으면 삭제
            if (array[left - 1] == 1)
                lionCount--;

            // 라이언 k개 이상 될 때까지 right ++
            while (right + 1 <= n && lionCount < k) {
                right++;
                if (array[right] == 1)
                    lionCount++;
            }

            if (lionCount >= k) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }

        // print
        if (minLength == Integer.MAX_VALUE)
            minLength = -1;
        System.out.println(minLength);
    }
}
