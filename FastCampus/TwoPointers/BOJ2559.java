package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    static int n, k;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        int right = 0;
        int maxSum = Integer.MIN_VALUE;
        int nowSum = 0;

        for(int left = 1; left <= n; left++){
            nowSum -= array[left-1];

            // set right
            while(right+1 <= n && right < (left + k-1)){
                right++;
                nowSum += array[right];
            }

            // update maxSum
            if((right - left + 1) == k){
                maxSum = Math.max(maxSum, nowSum);
            }
        }
        System.out.println(maxSum);
    }
}
