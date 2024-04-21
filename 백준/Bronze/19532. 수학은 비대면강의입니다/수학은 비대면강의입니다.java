import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int a = Integer.parseInt(sa[0]);
        int b = Integer.parseInt(sa[1]);
        int c = Integer.parseInt(sa[2]);
        int d = Integer.parseInt(sa[3]);
        int e = Integer.parseInt(sa[4]);
        int f = Integer.parseInt(sa[5]);

        for(int i=-999; i<=999; i++){
            for(int j=-999; j<=999; j++){
                if(a*i + b*j == c && d*i + e*j == f){
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}