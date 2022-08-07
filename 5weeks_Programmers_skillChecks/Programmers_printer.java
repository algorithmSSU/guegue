import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    static int solution(int[] priorities, int location) {
        int sequence = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()){
                    if(i == location)
                        return sequence;
                    pq.poll();
                    sequence++;
                }
            }
        }

        return -1;

    }
}
