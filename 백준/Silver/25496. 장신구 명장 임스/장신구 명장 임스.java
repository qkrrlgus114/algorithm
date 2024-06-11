import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int P = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);

        int result = 0;

        for(int i=0; i<N; i++){
            if(P < 200){
                P += arr[i];
                result++;
            }
        }

        System.out.println(result);
    }
}

