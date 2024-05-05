import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int num = 0;
        int value = 1;
        while(num < 1000000000){
            value += num * 6;
            if(value >= N){
                System.out.println(num + 1);
                return;
            }
            num++;
        }
    }
}

