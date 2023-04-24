import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11047 {
    private static int[] coins;
    private static int n, targetSum;

    public static void main(String[] args) throws IOException {
        init();

        int minCoinCount = getMinCoinCount();
        System.out.println(minCoinCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());

        // set coins
        coins = new int[n];
        for(int i = 0 ; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
    }

    private static int getMinCoinCount(){
        int coinCount = 0;
        int coinIdx = n-1;

        while(targetSum > 0){
            int thisCoin = coins[coinIdx--];
            int thisCount = targetSum / thisCoin;
            coinCount += thisCount;
            targetSum %= thisCoin;
        }

        return coinCount;
    }
}
