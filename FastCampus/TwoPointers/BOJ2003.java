package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    static int n, m;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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
        int right = 0;
        int nowSum = 0;
        int count = 0;

        for (int left = 1; left <= n; left++) {
            // left 우측으로 옮기기
            nowSum -= array[left - 1];

            // set right
            while ((right + 1) <= n && nowSum < m) {
                right++;
                nowSum += array[right];
            }

            if(nowSum == m)
                count++;
        }

        System.out.println(count);
    }
}
