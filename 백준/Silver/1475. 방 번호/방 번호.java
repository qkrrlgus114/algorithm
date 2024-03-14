import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        char[] c = s.toCharArray();

        int[] num = new int[10];
        for(int i=0; i<s.length(); i++){
            if(c[i] - 48 == 6 || c[i] - 48 == 9){
                num[9]++;
            }else{
                num[c[i] - 48]++;
            }
        }

        int max = 0;
        for(int i=0; i<9; i++){
            max = Math.max(max, num[i]);
        }

        int nine = 0;
        if(num[9] % 2 == 0) nine = num[9] / 2;
        else nine = num[9] / 2 + 1;

        System.out.println(Math.max(max, nine));


    }
}