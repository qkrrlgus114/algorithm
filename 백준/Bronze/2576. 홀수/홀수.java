import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int oddSum = 0;
        int minOdd = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(bf.readLine());

            if (num % 2 == 0) {
                continue;
            }

            oddSum += num;
            minOdd = Math.min(minOdd, num);
        }

        System.out.println(oddSum == 0 ? -1 : oddSum);
        if (oddSum != 0) {
            System.out.println(minOdd);
        }

    }

}