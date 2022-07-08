import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        int minSum = 0;

        // separate operand and operator in exp
        Stack stack = stringToStack(exp);


        // calculate stack
        int tmp = 0;
        while(!stack.isEmpty()){
            Object obj = stack.pop();
            // '+'
            if(obj.toString().equals("+")){
                continue;
            }
            // '-'
            else if(obj.toString().equals("-")){
                minSum += (tmp * -1);
                tmp = 0;
            }
            // operand
            else{
                tmp += (int)obj;
            }
        }
        minSum += tmp;

        System.out.println(minSum);
    }

    private static Stack stringToStack(String exp){
        Stack stack = new Stack();

        int i = 0;
        while(i < exp.length()){
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-')   //push operator
                stack.push(exp.charAt(i++));
            else{   //push integer
                String num = "";
                while(i < exp.length() && Character.isDigit(exp.charAt(i))){
                    num += exp.substring(i, ++i);
                }
                stack.push(Integer.parseInt(num));
            }
        }
        return stack;
    }
}



/*
[문제]
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

[입력]
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
입력으로 주어지는 식의 길이는 50보다 작거나 같다.

[출력]
첫째 줄에 정답을 출력한다.

[예제]
<입력>
55-50+40
<출력>
-351
 */