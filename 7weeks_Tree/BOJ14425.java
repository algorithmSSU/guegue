import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14425 {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] NArray = new String[N];
        String[] MArray = new String[M];

        for (int i = 0; i < N; i++) {
            NArray[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            MArray[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            count += stringInArray(MArray[i], NArray);
        }

        System.out.println(count);
    }

    private static int stringInArray(String str, String[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str))
                count++;
        }

        return count;
    }

}

