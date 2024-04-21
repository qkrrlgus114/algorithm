import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int a = Integer.parseInt(sa[0]); // 양 한마리 사료
        int b = Integer.parseInt(sa[1]); // 염소 한마리 사료
        int n = Integer.parseInt(sa[2]); // 양+염소
        int w = Integer.parseInt(sa[3]); // 소비한 사료

        int sheep = n-1;
        int cow = 1;
        boolean check = false;
        int result1 = -1;
        int result2 = -1;

        while(cow < n){
            int eatA = a * sheep;
            int eatB = b * cow;

            if(eatA + eatB == w && !check){
                result1 = sheep;
                result2 = cow;
                check = true;
            }else if(eatA + eatB == w && check){
                result1 = -1;
                result2 = -1;
                break;
            }

            sheep--;
            cow++;
        }
        if(result1 != -1) System.out.println(result1 + " " + result2);
        else System.out.println(-1);

    }
}