import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] takeCard;
    static int[] searchCard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(s);
        takeCard = new int[N];
        for(int i=0; i<N; i++){
            takeCard[i] = Integer.parseInt(sa[i]);
        }

        s = bf.readLine();
        sa = bf.readLine().split(" ");
        M = Integer.parseInt(s);
        searchCard = new int[M];
        for(int i=0; i<M; i++){
            searchCard[i] = Integer.parseInt(sa[i]);
        }

        int[] countArr = new int[20000002];
        for(int i=0; i<N; i++){
            countArr[10000000 + takeCard[i]]++;
        }
        int[] result = new int[M];
        for(int i=0; i<M; i++){
            result[i] = countArr[10000000 + searchCard[i]];
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}