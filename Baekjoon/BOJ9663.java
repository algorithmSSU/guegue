import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9663 {
    private static int count = 0;
    private static int n;


    public static void main(String[] args) throws IOException {
        init();

        setCount(new ArrayList<>());

        System.out.println(count);
    }

    private static void setCount(List<Integer> list) {
        if (list.size() == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 같은 행인 경우
            if (list.contains(i))
                continue;
            // 대각선인 경우
            if (!isPossible(list, i))
                continue;

            list.add(i);
            setCount(list);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isPossible(List<Integer> list, int nowIdx) {
        for (int i = 0; i < list.size(); i++) {
            int width = Math.abs(nowIdx - list.get(i));
            int height = Math.abs(list.size() - i);

            if (width == height)
                return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

}


/*
O X O O
O O X O
O O O O
O O O O


 */