import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651_2 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        init();

        process(n, m, "", 0);
    }

    private static void process(int n, int m, String now, int count) {
        if(count == m){
            System.out.println(now);
            return;
        }

        for(int i = 1; i <= n; i++){
            process(n, m, now + i + " ", count + 1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

}
