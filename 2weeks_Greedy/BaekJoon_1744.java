import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        // set input
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);   //sorting


        // calculate
        int maxSum = 0;
        int idx = 0;
        // calculate (negative ~ 0)
        while(idx < num.length-1 && num[idx] <= 0 && num[idx+1] <= 0){
            maxSum += num[idx] * num[++idx];
            idx++;
        }
        while(idx < num.length && num[idx] <= 0){
            maxSum += num[idx++];
        }

        // calculate ( 1 ~ positive)
        idx = num.length-1;
        while(idx >= 1 && num[idx] > 1 && num[idx-1] > 1){
            maxSum += num[idx] * num[--idx];
            idx--;
        }
        while(idx >= 0 && num[idx] > 0){
            maxSum += num[idx--];
        }

        //print maxSum
        System.out.println(maxSum);
    }
}

/*
리드미 작성하기
 */