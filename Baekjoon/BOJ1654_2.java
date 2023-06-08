import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654_2 {
    private static int k, n;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        // process
        long left = 1; long right = array[array.length - 1];
        long maxLanLength = 0;
        while(left <= right){
            long mid = (left + right) / 2;

            if(isPossible(mid)){
                maxLanLength = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(maxLanLength);
    }

    private static boolean isPossible(long target){
        long lanCount = 0;
        for(int now : array){
            lanCount += (now / target);
        }

        return lanCount >= n;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set k, n
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // set array
        array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
    }

}


/*
최대로 길게 랜선을 잘라서 N개 이상으로 만들고 싶음

자르는 랜선의 길이를 binary search


 */