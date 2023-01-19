package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int n, x;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // sorting
        Arrays.sort(array);

        // two pointer
        int count = 0;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int sum = array[left] + array[right];

            if(sum == x){
                count++;
                left++;
                right--;
            }else if(sum > x){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(count);
    }
}
