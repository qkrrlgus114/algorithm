import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        int downCount = 0;
        int index = 0;

        for(int i=0; i<N-1; i++){
            if(arr[i] > arr[i+1]){
                downCount++;
                index = i;
            }
        }

        if(downCount == 0) System.out.println(N);
        else if(downCount == 1){
            if(index == N-2){
                if(arr[index-1] <= arr[index+1]) System.out.println(2);
                else System.out.println(1);
            }else if(index == 0){
                if(arr[index] <= arr[index+2]) System.out.println(2);
                else System.out.println(1);
            }else{
                int result = 0;
                if(arr[index-1] <= arr[index+1]) result++;
                if(arr[index] <= arr[index+2]) result++;
                System.out.println(result);
            }
        }else{
            System.out.println(0);
        }




    }

}

