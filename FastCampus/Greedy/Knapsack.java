package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {
    public static void main(String[] args) {
        // bag[i][0] : 무게, bag[i][1] : 가치
        int[][] bag = {{10,10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        frationalKnapsackFunc(bag, 30);
    }

    private static void frationalKnapsackFunc(int[][] bag, int capacity){
        double valueSum = 0.0;

        // 무게당 가치로 정렬
        Arrays.sort(bag, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });


        for(int i = 0; i < bag.length; i++){
            int[] thisBag = bag[i];
            if((capacity - thisBag[1]) > 0){
                capacity -= thisBag[0];
                valueSum += thisBag[1];
            }else{
                // calculate fraction
                valueSum += ((double)capacity / thisBag[0]) * thisBag[1];
                capacity = 0;
                // loop break
                break;
            }
        }

        // tmp print for debugging
        for(int[] i : bag) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(valueSum);
    }
}
