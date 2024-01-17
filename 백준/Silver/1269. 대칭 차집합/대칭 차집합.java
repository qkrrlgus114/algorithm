import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static int N;
    static int M;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        HashMap<Integer, Integer> A = new HashMap<>();
        HashMap<Integer, Integer> B = new HashMap<>();
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        int[] A_arr = new int[N];
        int[] B_arr = new int[M];



        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            A_arr[i] = Integer.parseInt(sa[i]);
            A.put(Integer.parseInt(sa[i]), 0);
        }
        sa = bf.readLine().split(" ");
        for(int i=0; i<M; i++){
            B_arr[i] = Integer.parseInt(sa[i]);
            B.put(Integer.parseInt(sa[i]), 0);
        }

        int b_count = 0;
        int a_count = 0;
        for(int i=0; i<N; i++){
            if(B.containsKey(A_arr[i])) b_count++;
        }
        for(int i=0; i<M; i++){
            if(A.containsKey(B_arr[i])) a_count++;
        }

        System.out.println(A.size() - a_count + B.size() - b_count);
    }
}
