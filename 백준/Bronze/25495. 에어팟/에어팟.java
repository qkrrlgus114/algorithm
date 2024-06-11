import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int percent = 0;
        int prePercent = 0;
        int preType = 0;

        String[] sa = bf.readLine().split(" ");

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(sa[i]);

            if(preType == num){
                percent += prePercent * 2;
                prePercent *= 2;
            }else{
                percent += 2;
                prePercent = 2;
                preType = num;
            }

            if(percent >= 100){
                preType = 0;
                percent = 0;
                prePercent = 0;
            }
        }

        System.out.println(percent);
    }
}

