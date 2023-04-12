
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1940
public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int count = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == m) {
                count++;
                i++;
            } else if (sum > m) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}





/*
이건 칭찬할만 함! 입력 보고 무지성 2중 for문 돌려도 시간초과 안날 거 예상했음. 딱 보고 정렬한다음 투포인터 돌리면 O(N)만에
풀수 있을 거 같긴한데 먼저 input size 분석하는 습관은 굿굿
위 풀이는 two pointer, 그 아래는 무지성 2중 for문


import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2018
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] + array[j]) == m)
                    count++;
            }
        }

        System.out.println(count);
    }
}


 */
