import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1976 {
    private static int[] array;
    private static int n, m;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        // union find
        for(int i = 1; i <= n; i++){
            int rootBase = findRoot(i);
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                int thisNum = Integer.parseInt(st.nextToken());
                if(thisNum == 1){
                    int thisNumRoot = findRoot(j);
                    if(rootBase != thisNumRoot){
                        array[thisNumRoot] = rootBase;
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            int thisNum = Integer.parseInt(st.nextToken());
            set.add(findRoot(thisNum));
        }

        System.out.println((set.size() == 1)? "YES" : "NO");
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
    }

    private static int findRoot(int num){
        if(num == array[num]){
            return num;
        }

        return array[num] = findRoot(array[num]);
    }
}
