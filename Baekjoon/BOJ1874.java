import java.util.*;
import java.io.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // set array
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // init
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        stack.push(now++);
        sb.append("+").append("\n");

        // process
        for (int i = 0; i < n; i++) {
            int thisElement = array[i];
            if (stack.isEmpty()) {
                if (now > thisElement) {
                    System.out.println("NO");
                    return;
                }
                stack.push(now++);
                sb.append("+").append("\n");
            }

            while (true) {
                if (thisElement == stack.peek()) {
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                } else if (thisElement > stack.peek()) {
                    // 불가능한 경우
                    if (now > thisElement) {
                        System.out.println("NO");
                        return;
                    }

                    stack.push(now++);
                    sb.append("+").append("\n");
                } else {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}