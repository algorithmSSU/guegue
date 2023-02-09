import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ11052 {
    static int n;
    static int[] p;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set p array
        p = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for (int i = 2; i <= n; i++) {
            dp(i);
        }

        // print answer
        System.out.println(p[n]);
    }

    private static void dp(int targetIdx) {
        int left = 1;
        int right = targetIdx - 1;

        while(left <= right){
            // Exception handling
            if(left + right != targetIdx){
                System.out.println("logic error");
                return;
            }

            // dp
            p[targetIdx] = Math.max(p[targetIdx], p[left] + p[right]);

            // move cursor
            left++;
            right--;
        }
    }
}

