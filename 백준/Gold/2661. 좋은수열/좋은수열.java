import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        dfs(0);

    }

    public static void dfs(int depth){
        // 종료 조건
        if(depth == N){
            for(int i : list){
                System.out.print(i);
            }
            System.exit(0);
        }

        // 재귀 조건
        for(int i=1; i<=3; i++){
            list.add(i);
            if(insertCheck(depth)){
                dfs(depth + 1);
            }
            list.remove(list.size() - 1);
        }
    }

    // 이전 수 판단.
    public static boolean insertCheck(int index){
        int length = (index + 1) / 2;
        for(int i=1; i<=length; i++){
            int count = 0;
            for(int j=index; j > index-i; j--){
                if(list.get(j) == list.get(j-i)) count++;
            }
            if(count == i) return false;
        }
        return true;
    }

}
