import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] lotto;
    static int k;
    static List<Integer> pick = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String[] sa = bf.readLine().split(" ");
            k = Integer.parseInt(sa[0]);
            if(k == 0){
                System.out.println(sb);
                break;
            }
            lotto = new int[k];
            visited = new boolean[k];
            for(int i = 0; i < k; i++){
                lotto[i] = Integer.parseInt(sa[i+1]);
            }

            combination(0, 0);
            sb.append("\n");
        }

    }

    public static void combination(int depth, int cur){
        if(depth == 6){
            for(int i : pick){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        for(int i=cur; i<lotto.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            pick.add(lotto[i]);
            combination(depth + 1, i);
            pick.remove(pick.size() - 1);
            visited[i] = false;
        }
    }
}