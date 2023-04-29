import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1541 {
    private static Stack<Integer> operand;
    private static Stack<Character> operator;
    private static int answer;

    public static void main(String[] args) throws IOException {
        init();

        setAnswer();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        operand = new Stack<>();
        operator = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        for (int i = 0; i < expression.length();) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                operator.add(expression.charAt(i++));
            }
            else{
                String numStr = "";
                while(true){
                    if(i >= expression.length())
                        break;
                    if(expression.charAt(i) == '+' || expression.charAt(i) == '-')
                        break;

                    numStr += expression.charAt(i++);
                }
                operand.add(Integer.parseInt(numStr));
            }
        }
    }

    private static void setAnswer(){
        answer = 0;
        int tmpSum = 0;
        while(!operator.isEmpty()){
            char thisOperator = operator.pop();
            int thisOperand = operand.pop();

            if(thisOperator == '+'){
                tmpSum += thisOperand;
            }else{
                tmpSum += thisOperand;
                tmpSum *= -1;
                answer += tmpSum;
                tmpSum = 0;
            }
        }
        answer += operand.pop();
        answer += tmpSum;
    }
}
// 55-60-80+20-10+20


/*
if(thisOperator == '+'){
                answer += thisOperand;
            }else if(thisOperator == '-'){
                if(answer > 0)
                    answer *= -1;
                answer += thisOperand;
            }
 */