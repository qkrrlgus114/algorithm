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

        String[] sa = bf.readLine().split(" ");
        int[] home = new int[N];
        for(int i=0; i<N; i++){
            home[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(home);
        int mid = N / 2;

        if(N % 2 == 0) System.out.println(home[mid -1 ]);
        else System.out.println(home[mid]);
    }

}

