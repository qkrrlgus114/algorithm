import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] number = {1, 2, 3};
    static List<String> list = new ArrayList<>();
    static int N, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        dfs(0);
        Collections.sort(list);
        sb.setLength(0);

        if(list.size() < K){
            System.out.println(-1);
            return;
        }

        String value = list.get(K-1);
        String[] temp = value.split("");
        for(int i=0; i<temp.length; i++){
            sb.append(temp[i]);
            if(i != temp.length - 1) sb.append("+");
        }

        System.out.println(sb);

    }

    private static void dfs(int sum){
        if(sum == N){
            list.add(sb.toString());
            return;
        }else if(sum > N) return;

        for(int i=0; i<3; i++){
            sb.append(number[i]);
            dfs(sum + number[i]);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

