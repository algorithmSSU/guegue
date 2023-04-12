import java.util.*;
import java.io.*;

public class BOJ12891 {
    private static final int A = 0;
    private static final int C = 1;
    private static final int G = 2;
    private static final int T = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        // set validate
        st = new StringTokenizer(br.readLine());
        int checkCount = 0;
        int[] validate = new int[4];
        for (int i = 0; i < 4; i++) {
            validate[i] = Integer.parseInt(st.nextToken());
            if (validate[i] == 0)
                checkCount++;
        }

        // calculate
        int answerCount = 0;

        // 처음에 p만큼 돌고난 뒤에는 빠지고 추가하는 값 두개 (앞, 뒤)만 봐주면 됨../...
        for (int i = 0; i < p; i++) {
            char ch = str.charAt(i);
            checkCount += addChar(ch, validate);
        }
        if (checkCount == 4)
            answerCount++;

        for (int i = 1; i <= s - p; i++) {
            int removeIdx = i - 1;
            checkCount += removeChar(str.charAt(removeIdx), validate);

            int addIdx = i + (p - 1);
            checkCount += addChar(str.charAt(addIdx), validate);

            if (checkCount == 4)
                answerCount++;
        }

        System.out.println(answerCount);
    }

    private static int addChar(char ch, int[] array) {
        int answer = 0;

        if (ch == 'A') {
            array[A]--;
            if (array[A] == 0) {
                answer = 1;
            }
        } else if (ch == 'C') {
            array[C]--;
            if (array[C] == 0) {
                answer = 1;
            }
        } else if (ch == 'G') {
            array[G]--;
            if (array[G] == 0) {
                answer = 1;
            }
        } else if (ch == 'T') {
            array[T]--;
            if (array[T] == 0) {
                answer = 1;
            }
        }

        return answer;
    }

    private static int removeChar(char ch, int[] array) {
        int answer = 0;

        if (ch == 'A') {
            array[A]++;
            if (array[A] == 1) {
                answer = -1;
            }
        } else if (ch == 'C') {
            array[C]++;
            if (array[C] == 1) {
                answer = -1;
            }
        } else if (ch == 'G') {
            array[G]++;
            if (array[G] == 1) {
                answer = -1;
            }
        } else if (ch == 'T') {
            array[T]++;
            if (array[T] == 1) {
                answer = -1;
            }
        }

        return answer;
    }
}