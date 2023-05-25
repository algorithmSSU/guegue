import java.util.*;

class H_INDEX {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int left = 0;
        int right = citations[citations.length - 1];

        int answer = Integer.MIN_VALUE;
        while (left <= right) {
            int quoteCount = (left + right) / 2;
            int paperCount = getCountPossible(quoteCount, citations);

            if (quoteCount > paperCount) {
                right = quoteCount - 1;
            } else {
                answer = Math.max(answer, quoteCount);
                left = quoteCount + 1;
            }
        }

        return answer;
    }

    private int getCountPossible(int quoteCount, int[] citations) {
        int num = 0;

        for (int citation : citations) {
            if (quoteCount <= citation)
                num++;
        }

        return num;
    }
}
