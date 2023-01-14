package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11652_new {
    static int n, maxCount, nowCount;
    static long maxCard, nowCard;
    static long array[];

    public static void main(String[] args) throws IOException {
        input();
    
        // sorting
        Arrays.sort(array);
        
        calculate();

        System.out.println(maxCard);
    }
    
    private static void calculate(){
        for(int i = 1; i < array.length; i++){
            // 이전 카드와 다르면
            if(nowCard != array[i]){
                if(maxCount < nowCount){
                    maxCount = nowCount;
                    maxCard = nowCard;
                }
                nowCount = 1;
                nowCard = array[i];
            }else{
            // 이전 카드랑 같은 경우
                nowCount++;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        maxCount = 1;
        maxCard = array[0];
        nowCount = 1;
        nowCard = array[0];
    }
}