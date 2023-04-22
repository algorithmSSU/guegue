import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ10610 {
    private static String strNum;

    public static void main(String[] args) throws IOException {
        init();

        int sum = 0;
        boolean answer = false;
        Integer[] numArray = new Integer[strNum.length()];
        for(int i = 0 ; i < strNum.length(); i++){
            int thisNum = strNum.charAt(i) - '0';
            sum += thisNum;
            numArray[i] = thisNum;
        }

        // 조건 1
        if(sum % 3 == 0) {
            answer = true;
        }

        // 조건 2
        Arrays.sort(numArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if(answer && numArray[numArray.length-1] == 0){
            for(int i : numArray)
                System.out.print(i);
        }else{
            System.out.println(-1);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strNum = br.readLine();
    }
}
