package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    static int n, s;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

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
        // Two Pointer
        int right = 0;
        int sum = 0;
        int answerLength = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            sum -= array[left-1];

            // set right
            while (right + 1 <= n && sum < s) {
                right++;
                sum += array[right];
            }

            int length = (right - left) + 1;

            if (sum >= s) {
                if (length < answerLength)
                    answerLength = length;
            }
        }


        if (answerLength == Integer.MAX_VALUE)
            answerLength = 0;
        System.out.println(answerLength);
    }
}



/*
Two Pointer 사용해서 문제 해결함
left를 하나씩 오른쪽으로 옮기면서(옆으로 가면 left-1에 해당하는 요소만큼 sum에서 빼기) 총합이 s이상이 될때까지 right을 보냄.
길이를 구해서 sum이 s이상이면서 길이가 현재 구한 최소보다 작으면 갱신!
 */