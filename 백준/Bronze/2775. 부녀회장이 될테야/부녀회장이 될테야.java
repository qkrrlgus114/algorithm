import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        int[][] house = new int[15][15];
        for(int i=0; i<15; i++){
            Arrays.fill(house[i], 1);
        }

        for(int i=0; i<15; i++){
            house[14][i] = i+1;
        }
        Arrays.deepToString(house);
        for(int i=13; i>=0; i--){
            for(int j=1; j<15; j++){
                house[i][j] = house[i+1][j] + house[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int k = 14 - Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine()) - 1;

            sb.append(house[k][n]).append("\n");
        }

        System.out.println(sb);
    }

}
