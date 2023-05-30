import java.util.*;

class MoreSpicy {
    Queue<Integer> pq = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        init(scoville);

        // process
        int count = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                return count;
            }

            int sum = (pq.poll() + (pq.poll() * 2));
            pq.add(sum);
            count++;
        }

        if (pq.poll() >= K)
            return count;

        return -1;
    }

    private void init(int[] scoville) {
        for (int i : scoville) {
            pq.add(i);
        }
    }
}
/*
총합은 pq에 넣으면서 init후 한번에 관리 (매번 순회하면 효율 떨어짐)

가장 낮은 거 2개 pick
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
*/