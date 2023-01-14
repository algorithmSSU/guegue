package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1015 {
    static int N;
    static List<Elem> list = new ArrayList<>();
    static int[] p;
    static class Elem{
        int idx;
        int value;

        public Elem(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString(){
            return "idx[" + this.idx + "] : " + this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        // ascending sorting
        Collections.sort(list, new Comparator<Elem>(){
            @Override
            public int compare(Elem o1, Elem o2){
                return o1.value - o2.value;
            }
        });

        // initialize p
        for(int i = 0 ; i < list.size(); i++){
            Elem thisElem = list.get(i);

            p[thisElem.idx] = i;
        }

        //tmp print
        for(int i = 0; i < p.length; i++){
            System.out.print(p[i] + " ");
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(new Elem(i, Integer.parseInt(st.nextToken())));
        }
    }
}
