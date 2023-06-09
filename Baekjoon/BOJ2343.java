import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
    private static int n, m, sum;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // process
        // binary search about bluelay size
        int left = 1; int right = sum;
        int answer = 0;
        while (left <= right){
            int blueLaySize = (left + right) / 2;

            if(isPossible(blueLaySize)){
                answer = blueLaySize;
                right = blueLaySize - 1;
            }else{
                left = blueLaySize + 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isPossible(int targetSize) {
        int nowCount = 1;
        int lastSum = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > targetSize)
                return false;

            if(lastSum + array[i] > targetSize){
                nowCount++;
                lastSum = array[i];
                continue;
            }
            lastSum += array[i];
        }

        return nowCount <= m;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init sum
        sum = 0;

        // set array
        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
        }
    }
}
