import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Programmers_clustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";


//        solution(str1, str2);
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        //둘 다 소문자화
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String newStr1 = "";
        String newStr2 = "";

        // 두 글자씩 끊어서 배열 만들기
        ArrayList<String> divideStr1 = new ArrayList<>();
        ArrayList<String> divideStr2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            divideStr1.add(str1.substring(i, i + 2));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            divideStr2.add(str2.substring(i, i + 2));
        }

        //str1, str2 둘 다 유효한 문자로 바꾸기 (특수 문자 제거)
        for (int j = divideStr1.size() - 1; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                if (divideStr1.get(j).charAt(i) - 'a' < 0 || divideStr1.get(j).charAt(i) - 'a' >= 26) {
                    divideStr1.remove(divideStr1.get(j));
                    break;
                }
            }
        }
        for (int j = divideStr2.size() - 1; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                if (divideStr2.get(j).charAt(i) - 'a' < 0 || divideStr2.get(j).charAt(i) - 'a' >= 26) {
                    divideStr2.remove(divideStr2.get(j));
                    break;
                }
            }
        }
        // 교집합 구하기
        ArrayList<String> bothStr = new ArrayList<>();
        for (String tmp1 : divideStr1) {
            for (String tmp2 : divideStr2) {
                if (tmp1.equals(tmp2)) {
                    bothStr.add(tmp1);
                    break;
                }
            }
        }

        // 합집합 구하기
        ArrayList<String> unionStr = new ArrayList<>(divideStr1);
        for (String tmp : bothStr) {
            divideStr2.remove(tmp);
        }
        unionStr.addAll(divideStr2);

        //자카드 유사도 구하기
        double answer = 0;
        if (unionStr.size() != 0)
            answer = bothStr.size() / (unionStr.size() * 1.0);
        else
            answer = 1;

        return (int) (answer * 65536);
    }
}

/*
1. str1, str2 둘 다 유효한 문자로 바꾸기 (둘 다 소문자화 및 특수 문자 제거)
2. 두 글자씩 끊어서 배열을 만든다.
3. 교집합 개수 구한다.
4. 합집합 개수 구한다.
5. 자카드 유사도 계산한다.
 */