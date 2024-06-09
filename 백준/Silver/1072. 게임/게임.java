import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int X = Integer.parseInt(sa[0]);
        int Y = Integer.parseInt(sa[1]);

        int Z = (int) ((long) Y * 100 / X);

        long result = -1;

        long l = 0;
        long r = 1000000000;

        while(l <= r){
            long mid = (l + r) / 2;

            int value = (int) ((long) (Y + mid) * 100 / (X + mid));

            if(value > Z){
                result = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(result);
    }



}


