import java.io.*;
import java.util.*;

public class BOJ_ICPC_1 {
    private static String target;

    public static void main(String[] args) throws IOException {
        init();

        int[] array = new int["MOBIS".length()];
        for (int i = 0; i < target.length(); i++) {
            char thisCh = target.charAt(i);
            switch (thisCh) {
                case 'M':
                    array[0]++;
                    break;
                case 'O':
                    array[1]++;
                    break;
                case 'B':
                    array[2]++;
                    break;
                case 'I':
                    array[3]++;
                    break;
                case 'S':
                    array[4]++;
                    break;
            }
        }

        boolean answer = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                answer = false;
                break;
            }
        }

        System.out.println((answer) ? "YES" : "NO");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
    }

}
