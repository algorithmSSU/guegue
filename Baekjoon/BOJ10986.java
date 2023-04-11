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


/*
나머지 합

수학적으로 생각하기 => 공식 세우기
연속된 부분 구간의 합이 M으로 나누어 떨어지는 경우면, 그 때 각 인덱스를 M으로 나누어도 떨어짐.
합배열을 모드 m으로 나눈 나머지로 업데이트

1. 0인거 개수세서 ++
2. 나머지가 같은 원소의 개수를 n이라 하면 nC2 해서 count += nC2 해주기
 */