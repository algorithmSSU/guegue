import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1920 {
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input setting
        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);   //sorting array
        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        //check existence
        for(int i = 0 ; i < M; i++){
            System.out.println(binarySearch(target[i], 0, N-1));
        }

    }

    /*
    target number exist -> return 1
    else -> 0
    */
    private static int binarySearch(int target, int left, int right){
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(num[mid] == target)
                return 1;
            else if(num[mid] < target)
                left = mid + 1;
            else
                right = mid -1;
        }
        return 0;
    }
}
