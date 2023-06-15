import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13702 {
    private static int n, k, max;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // process
        int left = 0; int right = max;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(mid)){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int withdrawalMoney) {
        int withdrawalCount = 1;
        int nowUseMoney = 0;

        for(int now : array){
            if(now > withdrawalMoney)
                return false;

            if(nowUseMoney + now > withdrawalMoney){
                withdrawalCount++;
                nowUseMoney = now;
                continue;
            }
            nowUseMoney += now;
        }

        return withdrawalCount <= k;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // init
        max = 0;

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max += array[i];
        }
    }
}


