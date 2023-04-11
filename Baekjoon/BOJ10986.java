import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10986
public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        long count = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, m
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // set array
        long[] array = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        // set sumArray
        long[] sumArray = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        // 모든 값 m으로 나눈 나머지로 저장
        int[] surplusCount = new int[m];
        for (int i = 1; i <= n; i++) {
            sumArray[i] %= m;
            if (sumArray[i] == 0) {
                count++;
            }
            surplusCount[(int) sumArray[i]]++;
        }

        for (int i = 0; i < m; i++) {
            long thisNum = surplusCount[i];
            if (thisNum >= 1) {
                count += (thisNum * (thisNum - 1)) / 2;
            }
        }

        System.out.println(count);
    }
}
