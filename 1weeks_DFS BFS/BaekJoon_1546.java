import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        double sum = 0;

        for(int i = 0 ; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            array[i] = tmp;
            if(max < tmp)
                max = tmp;
        }
        for(int i = 0; i < N; i++){
            sum += sejunization(max, array[i]);
        }
        System.out.println(sum / N);


    }
    private static double sejunization(int M, int num){
        return (double)num / M * 100;
    }
}
/*
M -> 자기 점수 중 최대값

 */
