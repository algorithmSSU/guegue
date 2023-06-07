import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_3 {
    private static int n;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(array);

        int left = 0; int right = array.length - 1;
        int minAnswer = Integer.MAX_VALUE; int maxAnswer = Integer.MIN_VALUE;
        int nowAnswer = Integer.MAX_VALUE;
        while(left < right){
            int sum = array[left] + array[right];

            if(Math.abs(sum) < nowAnswer){
                // save answer
                nowAnswer = Math.abs(sum);
                minAnswer = Math.min(array[left], array[right]);
                maxAnswer = Math.max(array[left], array[right]);
            }

            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(minAnswer + " " + maxAnswer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set array
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];
        for(int i = 0 ; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

}
