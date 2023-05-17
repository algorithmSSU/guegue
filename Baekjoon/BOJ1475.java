import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1475 {
    private static int[] countArray;

    public static void main(String[] args) throws IOException {
        init();

        // process (about 6, 9)
        countArray[6] += countArray[9];
        countArray[9] = 0;

        // process
        int maxCount = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = 0; i <= 9; i++){
            if(i == 6)
                continue;

            if(countArray[i] > maxCount){
                maxCount = countArray[i];
                maxIdx = i;
            }
        }

        countArray[6] = (countArray[6] % 2 == 0) ? countArray[6] : countArray[6] + 1; // 홀수인 경우 + 1
        int requiredSixCount = countArray[6] / 2;

        // print answer
        System.out.println(Math.max(maxCount, requiredSixCount));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        countArray = new int[9+1];
        String strNum = br.readLine();
        for(int i = 0 ; i < strNum.length(); i++){
            int thisNum = strNum.charAt(i) - '0';
            countArray[thisNum]++;
        }
    }

}
