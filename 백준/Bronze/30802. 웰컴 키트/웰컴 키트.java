import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] sa = br.readLine().split(" ");
        int[] arr = new int[sa.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        sa = br.readLine().split(" ");
        int T = Integer.parseInt(sa[0]);
        int P = Integer.parseInt(sa[1]);

        int tShirt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % T == 0) tShirt += arr[i] / T;
            else tShirt += (arr[i] / T) + 1;
        }
        int pSet = 0;
        int pCount = 0;
        pSet = N / P;
        if(N % P != 0){
            pCount = N % P;
        }

        System.out.println(tShirt);
        System.out.println(pSet + " " + pCount);
    }
}
