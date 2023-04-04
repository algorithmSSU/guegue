import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {
    private static List<Integer> list;
    private static int distance;

    public static void main(String[] args) throws IOException {
        input();

        printAnswer();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            list.add(i);

        distance = Integer.parseInt(st.nextToken());
    }

    private static void printAnswer() {
        int idx = 0;

        System.out.print("<");
        while (list.size() > 1) {
            idx = (idx + (distance - 1)) % list.size();
            System.out.print(list.remove(idx));
            System.out.print(", ");
        }
        System.out.print(list.remove(0));
        System.out.print(">");
    }
}
