import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ2011 {
    /**
     * 문제 거지 같아서 안품
     */
    static String numStr;
    static int dp[];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numStr = br.readLine();
        dp = new int[numStr.length()+1];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        // set dp
        // exception handling
        if(Integer.parseInt(numStr.substring(0,1)) == 0){
            System.out.println(0);
            return;
        }
        if(numStr.length() == 1){
            System.out.println(1);
            return;
        }

        // set idx 1
        dp[1] = 1;

        // set idx 2
        if(Integer.parseInt(numStr.substring(0,2)) > 0 && Integer.parseInt(numStr.substring(0,2)) <= 26 && Integer.parseInt(numStr.substring(0,2)) != 10 && Integer.parseInt(numStr.substring(0,2)) != 20)
            dp[2] = 2;
        else
            dp[2] = 1;

        for(int i = 3; i <= numStr.length(); i++){
            int num = Integer.parseInt(numStr.substring(i-2, i));

            // num > 26인 경우
            if(num % 10 != 0 && num > 26)
                dp[i] = dp[i-1] % 1000000;
                // 0 < num <= 26인 경우
            else if(num == 10 || num == 20)
                dp[i] = dp[i-2] % 1000000;
            else if(num > 0 && num <= 26)
                dp[i] = (dp[i-2] + dp[i-1]) % 1000000;
                // 나머지 0 출력 후 종료
            else{
                System.out.println(0);
                return;
            }
        }

        // print answer
        System.out.println(dp[numStr.length()] % 1000000);
    }
}