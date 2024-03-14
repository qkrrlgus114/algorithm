import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[][] arr = new int[N][3];
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
            arr[i][2] = Integer.parseInt(sa[2]);
        }

        int result = 0;

        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                for(int k=1; k<=9; k++){
                    if(i==j || j==k || i==k) continue;
                    boolean check = true;
                    for(int q=0; q<N; q++){
                        int qx = arr[q][0] / 100;
                        int qy = (arr[q][0] % 100) / 10;
                        int qz = arr[q][0] % 10;
                        int strike = 0, ball = 0;
                        if(i == qx) strike++;
                        else if(i == qy || i == qz) ball++;
                        if(j == qy) strike++;
                        else if(j == qx || j == qz) ball++;
                        if(k == qz) strike++;
                        else if(k == qx || k == qy) ball++;
                        if(strike != arr[q][1] || ball != arr[q][2]){
                            check = false;
                            break;
                        }
                    }
                    if(check) result++;
                }
            }
        }

        System.out.println(result);

    }
}