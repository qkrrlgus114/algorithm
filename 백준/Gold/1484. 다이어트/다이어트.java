import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        long G = Long.parseLong(s);
        StringBuilder sb = new StringBuilder();

        long left = 1;
        long right = 2;
        while(right < 100001){
            long leftPow = left * left;
            long rightPow = right * right;
            if(rightPow - leftPow == G){
                sb.append(right).append("\n");
                right++;
            }else if(rightPow - leftPow > G){
                left++;
            }else if(rightPow - leftPow < G){
                right++;
            }
        }

        if(sb.length() != 0) System.out.println(sb);
        else System.out.println(-1);

    }
}

