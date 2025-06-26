import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        String answer = "";
        int maxCnt = 0;
        int totalCnt = 0;
        for (int i = 0; i < t; i++) {
            String name = bf.readLine();
            String[] sa = bf.readLine().split(" ");

            int K = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            int tempCnt = 0;
            while (M >= K) {
                M -= K;
                tempCnt++;
                M += 2;
            }

            if (maxCnt < tempCnt) {
                answer = name;
                maxCnt = tempCnt;
            }
            totalCnt += tempCnt;
        }

        System.out.println(totalCnt);
        System.out.println(answer);
    }
}
