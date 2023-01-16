package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    static int n, m;
    static Set<String> noListenPeople;
    static List<String> noSeePeople;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        noListenPeople = new HashSet<>();
        noSeePeople = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            noListenPeople.add(br.readLine());
        }
        for(int i = 0 ; i < m; i++){
            noSeePeople.add(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        List<String> answerList = new ArrayList<>();

        for(String str : noSeePeople){
            if(noListenPeople.contains(str))
                answerList.add(str);
        }

        // sorting
        Collections.sort(answerList);

        System.out.println(answerList.size());
        for(String str : answerList)
            System.out.println(str);
    }
}
