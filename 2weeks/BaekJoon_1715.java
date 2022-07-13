import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaekJoon_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;

        // insert inputs to Queue
        for (int i = 0 ; i < N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }


        if(queue.size() == 1){
            System.out.println(0);
            return;
        }
        /*
        [종료조건] Queue가 빌 때까지
        queue에서 2개 빼서 더한값을 tmp
        sum += tmp
        종료조건 검사 후 break or Queue에 다시 tmp 삽입 후 loop
        */
        while (true){
            int tmp = queue.poll() + queue.poll();
            sum += tmp;

            if(queue.isEmpty())
                break;
            queue.add(tmp);
        }
        System.out.println(sum);
    }
}
