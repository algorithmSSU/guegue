import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ1562_2 {
    private static int[][][] dp;
    private static int n;
    private static final int DIVIDE = 1000000000;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set dp
        dp = new int[n + 1][9 + 1][1 << 10];

        // init dp
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
    }

    private static void setDp() {
        for (int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k < (1 << 10); k++){
                    int nowVisit = (1 << j) | k;
                    if(j == 0){
                        dp[i][0][nowVisit] += dp[i-1][1][k] % DIVIDE;
                    }else if(j == 9){
                        dp[i][9][nowVisit] += dp[i-1][8][k] % DIVIDE;
                    }else{
                        dp[i][j][nowVisit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k]) % DIVIDE;
                    }
                    dp[i][j][nowVisit] %= DIVIDE;
                }
            }
        }
    }

    private static void printAnswer() {
        int sum = 0;
        for(int i = 0; i <= 9; i++){
            sum += dp[n][i][(1 << 10) -1] % DIVIDE;
            sum %= DIVIDE;
        }

        System.out.println(sum);
    }

    private static String toBinaryNum(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num /= 2;
        }

        return str;
    }
}
