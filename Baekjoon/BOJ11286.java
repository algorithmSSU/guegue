import java.util.*;
import java.io.*;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o2) == Math.abs(o1)) {
                    return o1.compareTo(o2);
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(queue.poll());
            } else {
                queue.add(num);
            }
        }
    }
}
