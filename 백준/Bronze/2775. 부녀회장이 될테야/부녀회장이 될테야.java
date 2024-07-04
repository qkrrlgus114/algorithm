import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        house = new int[15][15];

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int k = 14 - Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine()) - 1;

            int value = dp(k, n);

            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }

    private static int dp(int k, int n){
        if(n == 0){
            return house[k][n] = 1;
        }
        if(k == 14){
            return house[k][n] = n + 1;
        }
        if(house[k][n] != 0){
            return house[k][n];
        }

        return house[k][n] = dp(k+1, n) + dp(k, n-1);
    }

}
