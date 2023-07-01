import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(bf.readLine()); // 반복 횟수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;
        for (int i = 0; i < repeat; i++) {
            int thisNum = Integer.parseInt(st.nextToken());
            if (primeNum(thisNum))
                answer++;
        }

        System.out.println(answer);
    }

    private static boolean primeNum(int num) {
        if (num == 1)
            return false;

        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0)
                return false;
        }
        return true;
    }
}
