import java.util.*;
import java.io.*;

public class BOJ2023 {
    private static List<Integer> answer;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();

        setAnswer();

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void init() throws IOException {
        answer = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
    }

    private static void setAnswer() {
        for (int i = 1; i <= 9; i++) {
            if (isPrimeNum(i))
                dfs(String.valueOf(i));
        }
    }

    private static void dfs(String numStr) {
        if (numStr.length() == n) {
            answer.add(Integer.parseInt(numStr));
            return;
        }

        for (int i = 0; i <= 9; i++) {
            String nextNumStr = numStr + String.valueOf(i);
            if (isPrimeNum(Integer.parseInt(nextNumStr))) {
                dfs(nextNumStr);
            }
        }
    }

    private static boolean isPrimeNum(int num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
