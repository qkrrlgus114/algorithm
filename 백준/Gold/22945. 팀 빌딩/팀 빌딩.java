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

        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = 0;

        int l = 0;
        int r = N-1;
        while(l < r){
            answer = Math.max(answer, (r-l-1) * Math.min(arr[l], arr[r]));

            if(arr[l] >= arr[r]) r--;
            else if(arr[l] < arr[r]) l++;
        }

        System.out.println(answer);
    }
}

