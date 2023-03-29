import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156_2 {
    private static int n;
    private static int[] array;
    private static int[] maxDrinkAmount;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        maxDrinkAmount = new int[n + 1];
    }

    public static void main(String[] args) throws IOException {
        init();

        setMaxDrinkAmount();

        System.out.println(maxDrinkAmount[n]);
    }

    private static void setMaxDrinkAmount() {
        maxDrinkAmount[1] = array[1];
        if (n >= 2) maxDrinkAmount[2] = array[1] + array[2];

        for (int i = 3; i <= n; i++) {
            int notNowCase = maxDrinkAmount[i - 1];
            int nowCase1 = maxDrinkAmount[i - 2] + 0 + array[i];
            int nowCase2 = maxDrinkAmount[i - 3] + 0 + array[i - 1] + array[i];

            maxDrinkAmount[i] = findMaxValueInThreeNumber(notNowCase, nowCase1, nowCase2);
        }
    }

    private static int findMaxValueInThreeNumber(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
}


