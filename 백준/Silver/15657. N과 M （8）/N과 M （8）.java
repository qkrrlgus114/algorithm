import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int N, M;
    static List<Integer> pick;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf. readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        pick = new ArrayList<>();
        arr = new int[N];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        combination(0, 0);
        System.out.println(sb);

    }

    public static void combination(int depth, int cur){
        // 종료 조건
        if(depth == M){
            for(int i : pick){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=cur; i<N; i++){
            pick.add(arr[i]);
            combination(depth + 1, i);
            pick.remove(pick.size() - 1);
        }
    }
}