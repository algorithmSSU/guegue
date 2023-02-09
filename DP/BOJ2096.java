import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ2096 {
    static int n;
    static int[][] array, minDp, maxDp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // init dp array
        minDp = new int[n + 1][3];
        maxDp = new int[n + 1][3];

        // set init
        for(int i = 0; i < 3; i++){
            minDp[1][i] = array[1][i];
            maxDp[1][i] = array[1][i];
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set dp
        setMaxDp();
        setMinDp();

        // print max answer
        System.out.print(Math.max(Math.max(maxDp[n][0], maxDp[n][1]), maxDp[n][2]) + " ");

        // pint min answer
        System.out.print(Math.min(Math.min(minDp[n][0], minDp[n][1]), minDp[n][2]));
    }

    private static void setMaxDp(){
        for(int i = 2; i <= n; i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + array[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + array[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + array[i][2];
        }
    }

    private static void setMinDp(){
        for(int i = 2; i <= n; i++){
            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + array[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + array[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + array[i][2];
        }
    }
}