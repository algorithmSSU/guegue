import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20364 {
    static int n, q;
    static int[] wantEstate;
    static boolean[] occupied;
    static List<Integer> answer;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        occupied = new boolean[n + 1];
        wantEstate = new int[q];
        answer = new ArrayList<>();

        // set 점유하길 원하는 땅
        for (int i = 0; i < q; i++) {
            wantEstate[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        for (int i : wantEstate) {
            goParent(i);
        }

        for (int i : answer)
            System.out.println(i);
    }


    private static void goParent(int vertex) {
        int thisAnswer = 0;

        int thisVertex = vertex;
        while (thisVertex != 1) {
            // 점유된 땅인 경우
            if (occupied[thisVertex]) {
                thisAnswer = thisVertex;
            }

            thisVertex /= 2;
        }

        // 성공한 경우
        answer.add(thisAnswer);
        if(thisAnswer == 0) occupied[vertex] = true;
    }
}
