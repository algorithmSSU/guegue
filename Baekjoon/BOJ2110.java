import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    private static int n, c, max;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        // process
        int left = 1; int right = max;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(isPossible(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int targetDistance) {
        int machineCount = 1;
        int lastIdx = array[0];
        for(int i = 1; i < array.length; i++){
            int thisIdx = array[i];
            int distanceByLast = thisIdx - lastIdx;

            if(distanceByLast >= targetDistance){
                machineCount++;
                lastIdx = thisIdx;
            }
        }

        return machineCount >= c;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, c
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // set array
        max = Integer.MIN_VALUE;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }
    }

}

/*
공유기 사이 거리 최대로 만들고싶음
공유기 거리를 binary search
 */