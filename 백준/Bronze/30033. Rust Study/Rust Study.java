
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int result = 0;

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(sa[i]);
        }

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr2[i] = Integer.parseInt(sa[i]);
            if(arr1[i] <= arr2[i]) result++;
        }

        System.out.println(result);

    }
}