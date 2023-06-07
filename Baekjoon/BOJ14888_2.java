import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14888_2 {
    private static int n, maxAnswer, minAnswer;
    private static int[] array, operator;
    private static char[] converter = "+-*/".toCharArray();
    private static List<String> operatorList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        initOperatorList("", 0);

        for(String thisOperator : operatorList){
            int value = calculate(array, thisOperator);
            maxAnswer = Math.max(maxAnswer, value);
            minAnswer = Math.min(minAnswer, value);
        }

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    private static int calculate(int[] array, String thisOperators) {
        int sum = array[0];
        for(int i = 0 ; i < thisOperators.length(); i++){
            char thisOperator = thisOperators.charAt(i);
            int num = array[i+1];

            switch (thisOperator){
                case '+':
                    sum += num;
                    break;
                case '-':
                    sum -= num;
                    break;
                case '*':
                    sum *= num;
                    break;
                case '/':
                    sum /= num;
                    break;
            }
        }

        return sum;
    }

    private static void initOperatorList(String now, int count) {
        if(count == n - 1){
            operatorList.add(now);
            return;
        }

        for(int i = 0 ; i < operator.length; i++){
            if(operator[i] == 0) continue;
            operator[i]--;
            initOperatorList(now + converter[i], count + 1);
            operator[i]++;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set operator
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // init Answer
        maxAnswer = Integer.MIN_VALUE;
        minAnswer = Integer.MAX_VALUE;
    }

}
