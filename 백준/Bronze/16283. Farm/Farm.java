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

        int sheep = 0;

        for(int i=1; i<=n-1; i++){
            if(i * a + (n-i) * b == w){
                if(sheep == 0){
                    sheep = i;
                }else{
                    System.out.println(-1);
                    return;
                }
            }
        }

        if(sheep == 0) System.out.println(-1);
        else System.out.println(sheep + " " + (n - sheep));
    }
}