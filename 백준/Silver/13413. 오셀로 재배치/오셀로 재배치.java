import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";

        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            int diffBWNum = 0;
            int diffPatternNum = 0;
            int str1W = 0;
            int str2W = 0;

            str1 = bf.readLine();
            str2 = bf.readLine();
            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) != str2.charAt(j)) diffPatternNum += 1;
                if (str1.charAt(j) == 'W') str1W += 1;
                if (str2.charAt(j) == 'W') str2W += 1;
            }
            diffBWNum = Math.abs(str1W - str2W);

            int result = (diffPatternNum - diffBWNum) / 2 + diffBWNum;

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());

    }
}
