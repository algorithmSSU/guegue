import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    private static int num;
    private static int[] array, dp;

    private static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        array = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[num];
        setDpAllValueOne();
    }

    public static void main(String[] args) throws IOException {
        setInput();

        setDp();

        System.out.println(findMaxValueInArray(dp));
    }

    private static void setDp(){
        for(int i = 1; i < num; i++){
            int lastSubArrayLength = getLastSubArrayLength(i, array[i]);
            dp[i] += lastSubArrayLength;
        }
    }

    private static int getLastSubArrayLength(int nowIdx, int targetNum){
        int lastSubArrayLength = 0;

        for(int i = 0 ; i < nowIdx; i++){
            if(targetNum > array[i]){
                lastSubArrayLength = Math.max(lastSubArrayLength, dp[i]);
            }
        }

        return lastSubArrayLength;
    }

    private static void setDpAllValueOne(){
        for(int i = 0 ; i < num; i++){
            dp[i] = 1;
        }
    }

    private static int findMaxValueInArray(int[] array){
        int value = 0;
        for(int i = 0 ; i < array.length; i++){
            value = Math.max(value, array[i]);
        }

        return value;
    }
}

