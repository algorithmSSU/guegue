import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    private static int[] dp, time, price;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();

        setDp();
        System.out.println(dp[1]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        time = new int[n+1];
        price = new int[n+1];
        dp = new int[n+2];

        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void setDp(){
        for(int i = n; i >= 0; i--){
            if(i + time[i] <= n + 1){
                dp[i] = Math.max(dp[i+1], price[i] + dp[i + time[i]]);
            }else{
                dp[i] = dp[i+1];
            }
        }
    }
}
