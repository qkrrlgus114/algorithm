import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
    * 해당 위치에 이미 알파벳이 있다면 행운의 바퀴 X
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]); // 바퀴의 칸의 수
        int K = Integer.parseInt(sa[1]); // 바퀴 돌리는 횟수
        int cur = 0; // 현재 위치
        Map<String, Integer> map = new HashMap<>();

        String[] alphabet = new String[N];
        boolean check = true;
        Arrays.fill(alphabet, "?");

        for(int k=0; k<K; k++){
            sa = bf.readLine().split(" ");
            int cycle = Integer.parseInt(sa[0]);
            String alpha = sa[1];

            cur = (cur + cycle) % N;
            if((alphabet[cur].equals("?") && !map.containsKey(alpha)) || alphabet[cur].equals(alpha)){
                alphabet[cur] = alpha;
                map.put(alpha, 0);
            }else{
                check = false;
                break;
            }
        }

        if(!check){
            System.out.println("!");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                sb.append(alphabet[cur]);
                cur--;
                if(cur == -1) cur = N - 1;
            }
            System.out.println(sb);
        }

    }

}