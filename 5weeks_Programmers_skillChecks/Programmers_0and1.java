import java.util.ArrayList;

public class Programmers_0and1 {
    public static void main(String[] args) {
        int[] answer = solution("110010101001");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }


    }

    public static int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();


        while (s.length() != 1) {
            // 문자열 안에 0 제거
            String tmpS = "";
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                    tmpS += "1";
                }
            }

            // 제거된 0 개수 저장
            answer.add(s.length() - tmpS.length());

            s = Integer.toBinaryString(tmpS.length());
        }

        // ArrayList to Integer Array
        int[] realAnswer = new int[2];
        realAnswer[0] = answer.size();

        //총합 계산
        int sum = 0;
        for(int i : answer)
            sum += i;
        realAnswer[1] = sum;


        return realAnswer;
    }
}



/*
1. 문자열 안에 0 제거
2. 제거된 0 개수 저장
3. 문자열 길이를 이진수로 변환
(반복)
*/