import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon_2437_Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i = 0 ; i < n-1; i++){
            int sum = sum(num, i);
            if(num[i+1] > sum+1){
                System.out.println(sum+1);
                break;
            }
        }
    }
    private static int sum(int[] num, int idx){
        int sum = 0;
        for(int i =0 ; i <= idx; i++){
            sum += num[i];
        }
        return sum;
    }

}







/*
첫째 줄에 주어진 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 출력한다.


 */