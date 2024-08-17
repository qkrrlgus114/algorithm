import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        // 삼각수
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=50; i++){
            list.add(i * (i + 1) / 2);
        }

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(bf.readLine());
            boolean check = false; // 가능한지 여부

            outer: for(int i=0; i<list.size(); i++){
                for(int j=0; j<list.size(); j++){
                    for(int k=0; k<list.size(); k++){
                        if(list.get(i) + list.get(j) + list.get(k) == n){
                            sb.append(1).append("\n");
                            check = true;
                            break outer;
                        }
                    }
                }
            }

            if(!check) sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}