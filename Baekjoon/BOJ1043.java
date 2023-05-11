import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, m;
    private static int[] knowPeople, array;
    private static List<Integer>[] list;
    private static Set<Integer> knowPeopleSet;


    public static void main(String[] args) throws IOException {
        init();

        process();
        printAnswer();
    }

    private static void printAnswer() {
        // union find
        for(int i = 0 ; i < knowPeople.length; i++){
            knowPeopleSet.add(dfs(knowPeople[i]));
        }

        int count = 0;
        for(List<Integer> party : list){
            if(knowPeopleSet.contains(dfs(party.get(0)))){
                continue;
            }
            count++;
        }

        System.out.println(count);
    }

    private static void process() {
        for(List<Integer> party : list){

            int thisPartyRoot = dfs(party.get(0));
            for(int i = 1; i < party.size(); i++){
                int thisNum = party.get(i);
                int thisNumRoot = dfs(thisNum);
                if(thisPartyRoot != thisNumRoot){
                    array[thisNumRoot] = thisPartyRoot;
                }
            }
        }
    }

    private static int dfs(int i) {
        if (array[i] == i) {
            return i;
        }

        return array[i] = dfs(array[i]);
    }

    private static void init() throws IOException {
        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set knowPeople
        st = new StringTokenizer(br.readLine());
        int knowPeopleNum = Integer.parseInt(st.nextToken());
        knowPeople = new int[knowPeopleNum];
        for (int i = 0; i < knowPeopleNum; i++) {
            knowPeople[i] = Integer.parseInt(st.nextToken());
        }

        knowPeopleSet = new HashSet<>();

        // set list
        list = new List[m];
        for(int i = 0; i < m; i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int thisPartyNum = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < thisPartyNum; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // set array
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
    }
}
