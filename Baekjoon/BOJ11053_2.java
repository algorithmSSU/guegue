import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053_2 {
    private static int[] dp, array;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
        printAnswer();
    }

    private static void printAnswer() {
        int num = Integer.MIN_VALUE;
        for(int i : dp){
            num = Math.max(num, i);
        }

        System.out.println(num);
    }

    private static void setDp() {
        for(int i = 1; i < n; i++){
            int baseNum = array[i];
            boolean update = false;

            for(int j = 0; j < i; j++){
                int thisNum = array[j];

                if(thisNum <= baseNum){
                    dp[i] = Math.max(dp[i], dp[j]);
                    update = true;
                }
            }

            // update가 된 경우 + 1
            if(update)
                dp[i]++;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
    }
}
