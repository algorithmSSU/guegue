import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    private static int n, m;
    private static Set<String> set = new HashSet<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        init();

        // process
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String now = br.readLine();
            if(set.contains(now)){
                answerList.add(now);
            }
        }

        Collections.sort(answerList);

        // print answer
        System.out.println(answerList.size());
        for(String answer : answerList){
            System.out.println(answer);
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init n, m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set set
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
    }

}
