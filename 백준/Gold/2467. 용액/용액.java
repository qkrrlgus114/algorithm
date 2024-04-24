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

        int N = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        int[] result = new int[2];

        while(left < right){
            int value = arr[left] + arr[right];
            if(Math.abs(value) < answer){
                answer = Math.abs(value);
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if(value < 0) left++;
            else if(value > 0) right--;
            else if(value == 0) break;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}

