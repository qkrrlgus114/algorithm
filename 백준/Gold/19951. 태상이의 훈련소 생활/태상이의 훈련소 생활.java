import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cop{
    private int start;
    private int end;

    public Cop(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[N+1];
        int[] delta = new int[N+2];
        sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        int result = 0;

        for(int i=0; i<M; i++) {
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int k = Integer.parseInt(sa[2]);
            delta[start] += k;
            delta[end+1] += -k;
        }

        int value = 0;
        for(int i=1; i<=N; i++){
            value += delta[i];
            arr[i] += value;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}
