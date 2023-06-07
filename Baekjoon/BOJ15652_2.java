import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652_2 {
    private static int n, m;
    private static int[] saveArray;

    public static void main(String[] args) throws IOException {
        init();

        process(0, 0);
    }

    private static void process(int depth, int nowIdx) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(saveArray[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = nowIdx; i < n; i++) {
            saveArray[depth] = i + 1;
            process(depth + 1, i);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        saveArray = new int[m];
    }
}
