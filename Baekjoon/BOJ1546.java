import java.util.*;
import java.io.*;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] array = new double[n];

        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(st.nextToken());

            if ((int) array[i] > maxValue) {
                maxValue = (int) array[i];
            }
        }

        // calculate
        double sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = (array[i] / maxValue) * 100;
            sum += array[i];
        }

        System.out.println(sum / n);
    }
}

