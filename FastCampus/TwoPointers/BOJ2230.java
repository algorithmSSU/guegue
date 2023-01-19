package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    static int n, m;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // ascending sort
        Arrays.sort(array);

        // two pointer 이용
        int right = 0;
        int answer = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            // set right
            while(right + 1 <= n && (array[right] - array[left]) < m){
                right++;
            }

            if(array[right] - array[left] >= m){
                answer = Math.min(answer, array[right] - array[left]);
            }
        }

        System.out.println(answer);
    }
}
