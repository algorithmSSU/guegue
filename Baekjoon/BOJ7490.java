import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ7490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            List<String> answerList = new ArrayList<>();
            dfs(answerList, num, 0, 1, 1, 1, "1");

            Collections.sort(answerList);
            for (String answer : answerList) {
                System.out.println(answer);
            }
            System.out.println();
        }
    }

    private static void dfs(List<String> answerList, int max, int sum, int now, int num, int op, String expression) {
        if (max == now) {
            sum += (num * op);
            if (sum == 0) {
                answerList.add(expression);
            }
            return;
        }

        dfs(answerList, max, sum + (num * op), now + 1, now + 1, 1, expression + "+" + (now + 1));
        dfs(answerList, max, sum + (num * op), now + 1, now + 1, -1, expression + "-" + (now + 1));
        dfs(answerList, max, sum, now + 1, (num * 10) + (now + 1), op, expression + " " + (now + 1));
    }
}
