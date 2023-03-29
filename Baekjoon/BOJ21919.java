//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class BOJ21919 {
//    private static int[] numArray;
//    private static List<Integer> primeArray;
//
//    public static void main(String[] args) throws IOException {
//        setInputs();
//
//        setPrimeArrayInNumArray();
//
//        if(!hasPrimeNum()){
//            System.out.println(-1);
//        }else{
//            int leastCommonMultipleNum = getLeastCommonMultiple();
//            System.out.println(leastCommonMultipleNum);
//        }
//    }
//
//    private static int getLeastCommonMultiple(){
//
//    }
//
//    private static int getGreatestCommonDivisor(){
//
//    }
//
//    private static boolean hasPrimeNum(){
//        boolean hasPrimeNum;
//
//        if(primeArray.size() == 0)
//            hasPrimeNum = false;
//        else
//            hasPrimeNum = true;
//
//        return hasPrimeNum;
//    }
//
//    private static void setPrimeArrayInNumArray(){
//
//    }
//
//    private static void setInputs() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        primeArray = new ArrayList<>();
//
//        numArray = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0 ; i < n; i++){
//            numArray[i] = Integer.parseInt(st.nextToken());
//        }
//    }
//}
