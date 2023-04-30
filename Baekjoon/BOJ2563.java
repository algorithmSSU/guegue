import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    private static int[][] array = new int[101][101];
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        init();

        int answer = getAnswer();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            attachPaper(x, y);
        }
    }

    private static void attachPaper(int x, int y) {
        for (int i = y; i < y + 10; i++) {
            for (int j = x; j < x + 10; j++) {
                array[i][j] = 1;
            }
        }
    }

    private static int getAnswer(){
        int answerCount = 0;

        //tmp print
        for(int[] i : array){
            for(int j : i){
                if(j == 1)
                    answerCount++;
            }
        }

        return answerCount;
    }
}
